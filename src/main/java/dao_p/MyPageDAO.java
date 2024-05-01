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
import dto_p.ReportedBoardDTO;
import dto_p.ReportedMemberDTO;

public class MyPageDAO {
	
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	public MyPageDAO() {
		
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
	
	/** 내가 신고한 유저 보기*/
	public ArrayList<ReportedMemberDTO> getMyReportMember(MemberDTO val) {
		ArrayList<ReportedMemberDTO> dtos = new ArrayList<ReportedMemberDTO>();
		ReportedMemberDTO dto = null;
		sql = "select rm.*, m.m_no, reported.m_id as reported_m_id "
				+ "from reported_member as rm "
				+ "left join member as m "
				+ "on rm.m_id = m.m_id "
				+ "left join member as reported "
				+ "on reported.m_id = rm.reported_member "
				+ "where rm.m_id = ?"
				+ "order by r_date desc ";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, val.getmId());
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new ReportedMemberDTO();
				dto.setReportNo(rs.getInt("report_no"));
				dto.setmId(rs.getString("m_id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setrDate(rs.getDate("r_date"));
				dto.setReportedMemberMId(rs.getString("reported_m_id"));
				dto.setReportMember(rs.getInt("m_no"));
				dto.setProcess(rs.getInt("process"));
				
				dtos.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dtos;
	}
	
	/** 내가 신고한 게시판보기 보기*/
	public ArrayList<ReportedBoardDTO> getMyReportBoard(MemberDTO val) {
		ArrayList<ReportedBoardDTO> dtos = new ArrayList<ReportedBoardDTO>();
		ReportedBoardDTO dto = null;
		sql = "select rb.report_no , rb.m_id , rb.title, rb.content , rb.r_date , rb.process "
				+ ", b.b_title ,b.m_id ,b_write_day, b.b_no "
				+ "from reported_board as rb "
				+ "left join board as b "
				+ "on b.b_no = rb.reported_board "
				+ "where rb.m_id = ? "
				+ "order by rb.r_date desc ";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, val.getmId());
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new ReportedBoardDTO();
				dto.setReportNo(rs.getInt("report_no"));
				dto.setmId(rs.getString("rb.m_id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setrDate(rs.getDate("r_date"));
				dto.setProcess(rs.getInt("process"));
				dto.setBoardTitle(rs.getString("b.b_title"));
				dto.setBoardWriter(rs.getString("b.m_id"));
				dto.setBoardRegDate(rs.getDate("b_write_day"));
				dto.setReportedBoard(rs.getInt("b.b_no"));
				
				dtos.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dtos;
	}
	
	/** 내가 신고한 게시판보기 보기*/
	public ArrayList<ReportedBoardDTO> getMyReportNovel(MemberDTO val) {
		ArrayList<ReportedBoardDTO> dtos = new ArrayList<ReportedBoardDTO>();
		ReportedBoardDTO dto = null;
		sql = "select rn.report_no , rn.m_id, rn.content , rn.title , rn.r_date , rn.process, "
				+ "n.nov_no, n.nov_title, n.nov_epi, n.m_id , n.nov_subtitle, n.nov_regdate "
				+ "from reported_novel as rn "
				+ "left join novel as n "
				+ "on n.nov_no = rn.reported_novel  "
				+ "where rn.m_id = ? "
				+ "order by rn.r_date desc ";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, val.getmId());
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new ReportedBoardDTO();
				dto.setReportNo(rs.getInt("report_no"));
				dto.setmId(rs.getString("rn.m_id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setrDate(rs.getDate("r_date"));
				dto.setProcess(rs.getInt("process"));
				dto.setBoardTitle(rs.getString("nov_title"));
				dto.setNovEpi(rs.getInt("nov_epi"));
				dto.setBoardSubtitle(rs.getString("nov_subtitle"));
				dto.setBoardWriter(rs.getString("n.m_id"));
				dto.setBoardRegDate(rs.getDate("nov_regdate"));
				dto.setReportedBoard(rs.getInt("nov_no"));
				
				dtos.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dtos;
	}
	public ReportedMemberDTO getMemberDetail(int reportNo ,MemberDTO my) {
		ReportedMemberDTO dto = null;
		sql = "select rm.answer ,rm.report_no , rm.m_id , rm.reported_member , rm.title , rm.content, rm.r_date , rm.process , "
				+ "m.m_no , m.m_nickname, m.m_name "
				+ "from reported_member as rm "
				+ "left join member as m "
				+ "on m.m_id = rm.m_id "
				+ "where rm.report_no = ? and rm.m_id = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, reportNo);
			psmt.setString(2, my.getmId());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new ReportedMemberDTO();
				dto.setReportNo(rs.getInt("rm.report_no"));
				dto.setmId(rs.getString("rm.m_id"));
				dto.setReportedMemberMId(rs.getString("rm.reported_member"));
				dto.setTitle(rs.getString("rm.title"));
				dto.setContent(rs.getString("rm.content"));
				dto.setrDate(rs.getDate("rm.r_date"));
				dto.setProcess(rs.getInt("process"));
				dto.setReportedMember(rs.getInt("m.m_no"));
				dto.setReportedMemberNickname(rs.getString("m.m_nickname"));
				dto.setMemberName(rs.getString("m.m_name"));
				dto.setAnswer(rs.getString("rm.answer"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return dto;
	}	
	
	public ReportedBoardDTO getBoardDetail(int reportNo ,MemberDTO my) {
		ReportedBoardDTO dto = null;
		sql = "select rb.report_no , rb.m_id , rb.reported_board , rb.title , rb.content ,"
				+ " rb.r_date ,rb.process ,rb.answer , "
				+ "b.b_title ,b.b_content ,b.b_write_day , b.m_id  "
				+ "from reported_board as rb "
				+ "left join board as b "
				+ "on b.b_no = rb.reported_board "
				+ "where rb.report_no = ? and rb.m_id = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, reportNo);
			psmt.setString(2, my.getmId());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new ReportedBoardDTO();
				dto.setReportNo(rs.getInt("rb.report_no"));
				dto.setmId(rs.getString("rb.m_id"));
				dto.setReportedBoard(rs.getInt("rb.reported_board"));
				dto.setTitle(rs.getString("rb.title"));
				dto.setContent(rs.getString("rb.content"));
				dto.setrDate(rs.getDate("rb.r_date"));
				dto.setProcess(rs.getInt("rb.process"));
				dto.setAnswer(rs.getString("rb.answer"));
				dto.setBoardTitle(rs.getString("b.b_title"));
				dto.setBoardContent(rs.getString("rb.content"));
				dto.setBoardRegDateStr(rs.getString("b.b_write_day"));
				dto.setBoardWriter(rs.getString("b.m_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return dto;
	}
	
	public ReportedBoardDTO getNovelDetail(int reportNo ,MemberDTO my) {
		ReportedBoardDTO dto = null;
		sql = "select rn.report_no , rn.m_id , rn.reported_novel , rn.title , rn.content , "
				+ " rn.r_date ,rn.process ,rn.answer , "
				+ "n.nov_title, n.nov_subtitle , n.nov_regdate , n.m_id "
				+ "from reported_novel as rn "
				+ "left join novel as n "
				+ "on rn.reported_novel = n.nov_no "
				+ "where rn.report_no = ? and rn.m_id = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, reportNo);
			psmt.setString(2, my.getmId());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new ReportedBoardDTO();
				dto.setReportNo(rs.getInt("rn.report_no"));
				dto.setmId(rs.getString("rn.m_id"));
				dto.setReportedBoard(rs.getInt("rn.reported_novel"));
				dto.setTitle(rs.getString("rn.title"));
				dto.setContent(rs.getString("rn.content"));
				dto.setrDate(rs.getDate("rn.r_date"));
				dto.setProcess(rs.getInt("rn.process"));
				dto.setAnswer(rs.getString("rn.answer"));
				dto.setBoardTitle(rs.getString("n.nov_title"));
				dto.setBoardSubtitle(rs.getString("n.nov_subtitle"));
				dto.setBoardRegDate(rs.getDate("n.nov_regdate"));
				dto.setBoardWriter(rs.getString("n.m_id"));
			}
			
			System.out.println(dto.getProcess());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return dto;
	}
	
	
}
