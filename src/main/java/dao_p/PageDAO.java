package dao_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PageDAO {
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public PageDAO() {
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
	
	public int getTotalFreeBoardCnt() {
		int cnt = 0;
		
		sql = "select COUNT(b_no) as cnt from board "
				+ "where b_type = '자유'";
		 try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		 
		return cnt;
	}
	
	public int getTotalPromotionBoardCnt() {
		int cnt = 0;
		
		sql = "select COUNT(b_no) as cnt from board "
				+ "where b_type = '홍보'";
		 try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		 
		return cnt;
	}
	
	public int getTotalNoticeCnt() {
		int cnt = 0;
		
		sql = "select COUNT(n_no) as cnt from notice";
		
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return cnt;
	}
	
	public int getTotalInquiryCnt() {
		int cnt = 0;
		
		sql = "select COUNT(i_no) as cnt from inquiry";
		
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return cnt;
	}
}
