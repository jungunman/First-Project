package dao_p;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto_p.CommentDTO;
import dto_p.MemberDTO;


/*
 	m_no int not null primary key auto_increment, -- 멤버 번호(유저 회원가입시 부여받는 넘버) 
	m_id varchar(20) not null unique, -- 멤버 아이디(중복 불가)
	m_pwd  varchar(20) not null, -- 멤버 패스워드
	gender int not null default 1, -- 성별(주민등록번호 뒷번호로 구분) 기본값 : 남자(홀수라서 1로 함!) / 0은 여자
	reg_date datetime not null, -- 가입일
	m_profile varchar(100) default 'user.jpg', -- 프로필 사진
	front_num varchar(6) not null, -- 주민등록번호 앞자리
	back_num varchar(7) not null, -- 주민등록번호 뒷자리
	generation varchar(2) not null default 19, -- 1900년대생, 2000년대생 구분 기본값 : 19
	email varchar(50), -- 이메일
	field int default 0, -- 잔여금액 기본값 : 0
	m_name varchar(15) not null, -- 멤버 이름(실명)
	m_tel varchar(15) not null, -- 휴대폰 번호(일단 문자로 받겠습니다!)
	m_nickname varchar(30) not null unique -- 닉네임
 */

public class MemberDAO {
	
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	public MemberDAO() {
		
		try {
			//연결
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/novel");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void close() { //연결 해제 메소드
		if(rs!=null) {try {rs.close();} catch (SQLException e) {}}
		if(psmt!=null) {try {psmt.close();} catch (SQLException e) {}}
		if(con!=null) {try {con.close();} catch (SQLException e) {}}
	}
	
	
	/**회원가입 정보 추가하기*/
	public void memberWrite(MemberDTO dto) {
		
		sql = "insert into member(reg_date, m_id, m_pwd, front_num, back_num, email, m_name, m_tel, m_nickname)values(sysdate(),?,?,?,?,?,?,?,?)";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getmId());
			psmt.setString(2, dto.getmPwd());
			//psmt.setInt(3, dto.getGender());
			//psmt.setString(4, dto.getReg_dateStr());
			//psmt.setString(4, dto.getM_profile());
			psmt.setString(3, dto.getFrontNum());
			psmt.setString(4, dto.getBackNum());
			//psmt.setString(6, dto.getGeneration());
			psmt.setString(5, dto.getEmail());
			//psmt.setInt(8, dto.getField());
			psmt.setString(6, dto.getmName());
			psmt.setString(7, dto.getmTel());
			psmt.setString(8, dto.getmNickname());
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	/**회원가입 정보 리스트 보기 -- 관리자꺼!! */
	public ArrayList<MemberDTO>list(){
		ArrayList<MemberDTO> res = new ArrayList<MemberDTO>();
		
		sql = "select * from member order by reg_date desc";
		try {
			psmt = con.prepareStatement(sql);

			rs = psmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				
				dto.setmNo(rs.getInt("m_no"));
				dto.setmId(rs.getString("m_id"));
				dto.setmPwd(rs.getString("m_pwd"));
				dto.setmNickname(rs.getString("m_nickname"));
				dto.setmName(rs.getString("m_name"));
				dto.setmProfile(rs.getString("m_profile"));
				dto.setGender(Integer.parseInt(rs.getString("gender")));
				dto.setEmail(rs.getString("email"));
				dto.setmTel(rs.getString("m_tel"));
				dto.setRegDateStr(rs.getString("reg_date"));
				
				res.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
		return res;
	}
	
	/**로그인하기 - DB와 비교해서 동일하면 메인페이지, 틀리면 로그인 페이지 유지*/
	public MemberDTO loginChk(MemberDTO dto) {
		MemberDTO res = null;
		
		sql = "select m_id, m_no, m_nickname from member where m_id = ? and m_pwd = ?";
		//입력한 값이랑 db에 있는 m_id, m_pwd랑 같으면 보여줘!  m_nickname은 로그인 하고나서 보여주려구!
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getmId());  //회원이 입력한 값입니다!
			psmt.setString(2, dto.getmPwd());
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {	
				res = new MemberDTO();
				res.setmId(rs.getString("m_id")); 
				res.setmNo(rs.getInt("m_no"));
				res.setmNickname(rs.getString("m_nickname"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	public MemberDTO memberDetail(int mNo){
		MemberDTO memberDto = null;
		
		sql = "select * from member where m_no=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, mNo);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				memberDto = new MemberDTO();
				memberDto.setmNo(rs.getInt("m_no"));
				memberDto.setmId(rs.getString("m_id"));
				memberDto.setmPwd(rs.getString("m_pwd"));
				memberDto.setmNickname(rs.getString("m_nickname"));
				memberDto.setmName(rs.getString("m_name"));
				memberDto.setmProfile(rs.getString("m_profile"));
				memberDto.setGender(Integer.parseInt(rs.getString("gender")));
				memberDto.setEmail(rs.getString("email"));
				memberDto.setmTel(rs.getString("m_tel"));
				memberDto.setRegDateStr(rs.getString("reg_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
		return memberDto;
	}
	
	public void memberModify(MemberDTO dto) {
		sql = "update member set m_pwd=?,email=?,m_tel=?,m_nickname=? where m_no=?";
		try {
			//비밀번호, 이메일,전화번호,닉네임 변경할 것
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getmPwd());  
			psmt.setString(2, dto.getEmail());
			psmt.setString(3, dto.getmTel());
			psmt.setString(4, dto.getmNickname());
			psmt.setInt(5, dto.getmNo());
			
			rs = psmt.executeQuery();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	/** unregister : 탈퇴 여부 확인 => 탈퇴 회원 : 1 */
	public void memberDelete(int mNo){
		sql = "update member set unregister=1 where m_no=?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, mNo);
			psmt.executeUpdate();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}	
		
	}
	
	
	public void profileModify(MemberDTO dto) {  
		
		sql = "update member set m_profile = ? where m_no = ?";  
	
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getmProfile());
			psmt.setInt(2, dto.getmNo());
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	public MemberDTO profileNoChange(int mNo){
		MemberDTO memberDto = null;
		
		sql = "select m_profile from member where m_no=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, mNo);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				memberDto = new MemberDTO();
				memberDto.setmProfile(rs.getString("m_profile")); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
		return memberDto;
	}
	
	/**회원이 하는~ 비밀번호 찾기*/
	public MemberDTO pwFind(MemberDTO dto) {
		MemberDTO res = null;
		sql = "select m_pwd from member where m_id = ? and m_name = ? and email = ?";
		System.out.println("아이디 애 안 ㄴ따");
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getmId());
			psmt.setString(2, dto.getmName());
			psmt.setString(3, dto.getEmail());
			rs = psmt.executeQuery();
			
			if(rs.next()) {	
				res = new MemberDTO();
				res.setmPwd(rs.getString("m_pwd")); 
				System.out.println("야야 오냐?");
			}
			System.out.println("아이디여가 오냐"+dto.getmPwd());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res;
		
	}

	/**회원이 하는! 아이디 찾기*/
	public MemberDTO idFind(MemberDTO dto) {
		MemberDTO res = null;
		System.out.println("간다 아디야");
		sql ="select m_id from member where m_name = ? and email = ? and concat(generation , front_num ) = ?";
		try {

			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getmName());
			psmt.setString(2, dto.getEmail());
			psmt.setString(3, (dto.getGeneration()+dto.getFrontNum()));
//			psmt.setString(3, dto.getGeneration());
//			psmt.setString(3, dto.getFrontNum());
			rs = psmt.executeQuery();
			System.out.println("아디야 오냐?");
			if(rs.next()) {
				res = new MemberDTO();
				res.setmId(rs.getString("m_id")); 
				System.out.println("아디 통과찡?");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
		
	}
	
	/*회원가입하기 - 아이디와 닉네임은 DB와 비교해서 중복 확인하기*/
	public MemberDTO joinChk(MemberDTO dto) {
		MemberDTO res = null;
		
		sql = "select m_id, m_no, m_nickname from member where m_id = ? or m_nickname = ?";
		//입력한 값이랑 db에 있는 m_id 또는 m_nickname랑 같으면 다시 입력하게 할거야!
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getmId());  //회원이 입력한 값입니다!
			psmt.setString(2, dto.getmNickname());
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {	
				res = new MemberDTO();
				res.setmId(rs.getString("m_id")); 
				res.setmNo(rs.getInt("m_no"));
				res.setmNickname(rs.getString("m_nickname"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	
}
