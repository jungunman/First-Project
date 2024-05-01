package dao_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto_p.InquiryDTO;
import dto_p.MemberDTO;
import etc_p.Paging;

public class InquiryDAO {

	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	public InquiryDAO() {

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/novel");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void close() {
		if(rs!=null) {try {rs.close();} catch (SQLException e) {}}
		if(psmt!=null) {try {psmt.close();} catch (SQLException e) {}}
		if(con!=null) {try {con.close();} catch (SQLException e) {}}
	}
	
	/**내가 한 1:1문의 전체 리스트 보기 - 회원 본인이 작성한 글만 확인 가능*/
	public ArrayList<InquiryDTO> inquiryList(MemberDTO dto) {
		ArrayList<InquiryDTO> res = new ArrayList<InquiryDTO>();
		InquiryDTO idto = null;
		sql = "select * from inquiry where m_id = ? order by i_no desc";
		System.out.println("퀄희나와따1");
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getmId());
			rs = psmt.executeQuery();
			System.out.println("퀄희나와따2");
			while(rs.next()) {
				idto = new InquiryDTO();
				idto.setiNo(rs.getInt("i_no"));
				idto.setiTitle(rs.getString("i_title"));
				idto.setiTime(rs.getTimestamp("i_time"));
				idto.setiCategory(rs.getString("i_category"));
				res.add(idto);
				System.out.println("퀄희나와따3");
			}
			System.out.println("퀄희나와따4");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res;
	} 
	
	/**관리자용 1:1문의 전체 리스트 보기*/
	public ArrayList<InquiryDTO> inquiryGodList(MemberDTO dto, Paging page) {
		ArrayList<InquiryDTO> res = new ArrayList<InquiryDTO>();
		InquiryDTO idto = null;
		sql = "select * from inquiry order by i_no desc limit ?,?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, page.getSearchNo());
			psmt.setInt(2, page.getLimit());	
			rs = psmt.executeQuery();
			while(rs.next()) {
				idto = new InquiryDTO();
				idto.setiNo(rs.getInt("i_no"));
				//idto.setmId(rs.getInt("m_id"));
				idto.setiTitle(rs.getString("i_title"));
				idto.setiTime(rs.getTimestamp("i_time"));
				idto.setiCategory(rs.getString("i_category"));
				idto.setaTitle(rs.getString("a_title"));
				idto.setiAnswer(rs.getString("i_answer"));
				idto.setAnswerTime(rs.getTimestamp("answer_time"));
				res.add(idto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res;
	} 
	
	
	/**회원이 한 1:1문의 리스트 타고 들어와서 상세보기! - 관리자 답변도 확인 가능함*/
	public InquiryDTO inquiryDetail(int iNo) {
		InquiryDTO dto = null;
		
		sql = "select * from inquiry where i_no = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, iNo);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new InquiryDTO();
				dto.setiNo(rs.getInt("i_no"));
				dto.setiTitle(rs.getString("i_title"));
				dto.setiTime(rs.getTimestamp("i_time"));
				dto.setiCategory(rs.getString("i_category"));
				dto.setiContent(rs.getString("i_content"));
				dto.setiImg(rs.getString("i_img"));
				dto.setaTitle(rs.getString("a_title"));
				dto.setiAnswer(rs.getString("i_answer"));
				dto.setAnswerTime(rs.getTimestamp("answer_time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return dto;
		
	}
	
	/**회원이 본인이 작성한 글 수정 가능하게 해주게!*/
	public void inquiryModify(InquiryDTO dto) {
		MemberDTO mdto = new MemberDTO();
		System.out.println(mdto);
		sql = "update inquiry set i_title = ?, i_time = sysdate(), i_content = ? , i_img = ? , a_title = ?,  i_answer = ?, answer_time = sysdate() where i_no = ?";
		System.out.println("인퀄희 1씨");
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getiTitle());
			psmt.setString(2, dto.getiContent());
			psmt.setString(3, dto.getiImg());
			psmt.setString(4, dto.getaTitle());
			psmt.setString(5, dto.getiAnswer());
			psmt.setInt(6, dto.getiNo());
			psmt.executeUpdate();
			
			System.out.println("인퀄희 2씨");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	/**관리자용 작성한 답변 수정 가능하게 해주게! - 관리자 답글도 가능요~*/
	public void inquiryGodModify(InquiryDTO dto) {
		MemberDTO mdto = new MemberDTO();
		System.out.println(mdto);
		sql = "update inquiry set i_title = ?, i_time = sysdate(), i_content = ? , i_img = ? , a_title = ?,  i_answer = ?, answer_time = sysdate() where i_no = ?";
		System.out.println("인퀄희 1씨");
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getiTitle());
			psmt.setString(2, dto.getiContent());
			psmt.setString(3, dto.getiImg());
			psmt.setString(4, dto.getaTitle());
			psmt.setString(5, dto.getiAnswer());
			psmt.setInt(6, dto.getiNo());
			psmt.executeUpdate();
			
			System.out.println("인퀄희 2씨");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	
	/**회원씨 문의글 작성합니다*/
	public void inquiryWrite(InquiryDTO dto) {
		sql = "insert into inquiry(i_title, i_content, i_time, m_id, i_img) values(?,?,sysdate(),?,?)";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getiTitle());
			psmt.setString(2, dto.getiContent());
			psmt.setString(3, dto.getmId());
			psmt.setString(4, dto.getiImg());
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}	
	}

	/**회원씨 문의글 삭제!하겠습니다. 스미마셍!데쇼!*/
	public InquiryDTO inquiryDelete(int no) {
		InquiryDTO dto = null;
		sql = "delete from inquiry where i_no = ?";		
		System.out.println("딜리투씨~1");
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, no);
			psmt.executeUpdate();
			
			System.out.println("딜리투씨~2");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	
	/**1:1문의글 카테고리 변경 - 문의 답변이 달렸으면 카테고리 답변 완료로 바꾸기 */
	public InquiryDTO changeCate(InquiryDTO dto) {
		
		sql = "update inquiry set i_category = '답변완료' where (a_title is not null)";
		try {
			psmt = con.prepareStatement(sql);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}

}
