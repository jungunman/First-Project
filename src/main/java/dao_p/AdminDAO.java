package dao_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto_p.MemberDTO;
import dto_p.ReportedBoardDTO;
import dto_p.ReportedMemberDTO;

public class AdminDAO {
	private Connection con;
	private PreparedStatement psmt;
	private ResultSet rs;
	String sql;
	
	public AdminDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/novel");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	void close() {
		if(rs!=null) { try { rs.close();} catch (SQLException e) {}}
		if(psmt!=null) { try { psmt.close();} catch (SQLException e) {}}
		if(con!=null) { try { con.close();} catch (SQLException e) {}}
	}
	
	/** 멤버 정지 */
	public int memberDelete(int mNo){
		int res = 0;
		sql = "update member set unregister=2 where m_no=?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, mNo);
			res = psmt.executeUpdate();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}	
		
		return res;
		
	}
	
	/** 신고 게시판 목록 보여주기*/
	public ReportedBoardDTO getReportedBoardDetail(int no) {
		ReportedBoardDTO dto = null;
		
		sql = "select rb.report_no , rb.m_id , rb.reported_board, rb.title , rb.title , rb.content , rb.r_date , rb.process , rb.answer, "
				+ "b.b_title ,b.b_content ,b.b_write_day ,b.m_id "
				+ "from reported_board  as rb "
				+ "left join board as b "
				+ "on b.b_no = rb.reported_board "
				+ "where rb.report_no = ?";
		
		try {
			psmt= con.prepareStatement(sql);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new ReportedBoardDTO();
				dto.setReportNo(rs.getInt("report_no"));
				dto.setmId(rs.getString("rb.m_id"));
				dto.setReportedBoard(rs.getInt("reported_board"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setrDate(rs.getDate("rb.r_date"));
				dto.setProcess(rs.getInt("process"));
				dto.setBoardTitle(rs.getString("b.b_title"));
				dto.setBoardContent(rs.getString("b.b_content"));
				dto.setBoardRegDate(rs.getDate("b.b_write_day"));;
				dto.setBoardWriter(rs.getString("b.m_id"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return dto;
	}
	
	
	/** 신고 게시판 목록 보여주기*/
	public ArrayList<ReportedBoardDTO> getReportedBoardList() {
		ArrayList<ReportedBoardDTO> dtos = new ArrayList<ReportedBoardDTO>();
		ReportedBoardDTO dto = null;
		sql = "select rb.report_no , rb.m_id , rb.reported_board ,rb.title ,rb.content, rb.r_date ,rb.process ,rb.answer "
				+ "from reported_board as rb "
				+ "order by rb.r_date desc";
		
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new ReportedBoardDTO();
				dto.setReportNo(rs.getInt("report_no"));
				dto.setmId(rs.getString("m_id"));
				dto.setReportedBoard(rs.getInt("reported_board"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setrDate(rs.getDate("r_date"));
				dto.setProcess(rs.getInt("process"));
				dto.setAnswer(rs.getString("answer"));
				
				dtos.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dtos;
	}
	
	/** 신고 멤버 목록 보여주기*/
	public ArrayList<ReportedMemberDTO> getReportedMemberList() {
		ArrayList<ReportedMemberDTO> dtos = new ArrayList<ReportedMemberDTO>();
		ReportedMemberDTO dto = null;
		sql = "select rm.*, m.m_no, reported.m_id as reported_m_id "
				+ "from reported_member as rm "
				+ "left join member as m "
				+ "on rm.m_id = m.m_id "
				+ "left join member as reported "
				+ "on reported.m_no = rm.reported_member "
				+ "order by r_date desc ";
		
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new ReportedMemberDTO();
				dto.setReportNo(rs.getInt("report_no"));
				dto.setmId(rs.getString("m_id"));
				dto.setReportedMemberMId(rs.getString("reported_member"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setrDate(rs.getDate("r_date"));
				dto.setReportedMemberMId(rs.getString("reported_m_id"));
				dto.setReportMember(rs.getInt("m_no"));
				
				dtos.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dtos;
	}
	
	/** 유저 신고 내용 상세보기*/
	public ReportedMemberDTO getReportedMemberDetail(int no) {
		ReportedMemberDTO dto = null;
	
		sql = "select rm.*, m.m_no, reported.m_id as reported_m_id  "
				+ "from reported_member as rm "
				+ "left join member as m "
				+ "on rm.m_id = m.m_id "
				+ "left join member as reported "
				+ "on reported.m_no = rm.reported_member "
				+ "where rm.report_no = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			if(rs.next()) {
				
				dto = new ReportedMemberDTO();
				dto.setReportNo(rs.getInt("report_no"));
				dto.setmId(rs.getString("m_id"));
				dto.setReportMemberId(rs.getString("m_id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setrDate(rs.getDate("r_date"));
				dto.setReportedMemberMId(rs.getString("reported_member"));
				dto.setReportMember(rs.getInt("m_no"));
				dto.setAnswer(rs.getString("answer"));
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return dto;
	}
	
	/** 유저 신고 답변하기*/
	public int getAnswerReportMember(ReportedMemberDTO val) {
		int res = 0;
		sql = "update reported_member set answer = ? "
				+ "where report_no = ? ";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, val.getAnswer());
			psmt.setInt(2, val.getReportNo());
			
			res = psmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res;
	}
	
	/** 유저 신고하기*/
	
	public int reportMember(ReportedMemberDTO dto) {
		int res = 0;
		sql = "insert into reported_member (m_id, reported_member, title, content, r_date) "
				+ "values ("
				+ "	?,?,?,?,sysdate()"
				+ ")";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getmId());
			psmt.setString(2, dto.getReportedMemberMId());
			psmt.setString(3, dto.getTitle());
			psmt.setString(4, dto.getContent());
			res = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res;
	}
	
	/** 게시글 신고하기*/
	public int reportBoard(ReportedBoardDTO dto) {
		int res = 0;
		
		sql = "insert into reported_board (m_id, reported_board, title, content, r_date) "
				+ "values ("
				+ "	?,?,?,?,sysdate()"
				+ ")";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getmId());
			psmt.setInt(2, dto.getReportedBoard());
			psmt.setString(3, dto.getTitle());
			psmt.setString(4, dto.getContent());
			res = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	/** 소설 신고하기*/
	public int reportNovel(ReportedBoardDTO dto) {
		int res = 0;
		
		sql = "insert into reported_novel (m_id, reported_novel, title, content, r_date) "
				+ "values ("
				+ "	?,?,?,?,sysdate()"
				+ ")";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getmId());
			psmt.setInt(2, dto.getReportedBoard());
			psmt.setString(3, dto.getTitle());
			psmt.setString(4, dto.getContent());
			res = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	
	
	
}
