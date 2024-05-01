package dao_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dto_p.CommentDTO;
import dto_p.NovelDTO;

public class CommentDAO {
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public CommentDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/novel");
			con = ds.getConnection();
		}
		catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
	}
	
	void close() {
		if(rs!=null) {try {rs.close();} catch (SQLException e) {}}
		if(psmt!=null) {try {psmt.close();} catch (SQLException e) {}}
		if(con!=null) {try {con.close();} catch (SQLException e) {}}
	}
		
	/** CommentDAO.list() => comment 테이블 목록*/
	public ArrayList<CommentDTO> listNovel(int novNo){
		ArrayList<CommentDTO> res = new ArrayList<CommentDTO>();
		CommentDTO cdto = null;
		sql = "select * from novcomment where nov_no =? order by c_regdate desc"; //최근 순서로 내림차순
		
		try {			
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, novNo);
			rs = psmt.executeQuery();		
			while(rs.next()) {
				cdto = new CommentDTO();
				cdto.setcNoNovel(rs.getInt("c_no"));
				cdto.setmIdNovel(rs.getString("m_id"));
				cdto.setNovNo(rs.getInt("nov_no"));
				cdto.setcContentNovel(rs.getString("c_content"));
				cdto.setcRegdateNovel(rs.getDate("c_regdate"));
				
				res.add(cdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
		return res;
	}
	
	public ArrayList<CommentDTO> myNovelList(){
		ArrayList<CommentDTO> res = new ArrayList<CommentDTO>();
		CommentDTO cdto = null;
		sql = "select * from novcomment where nov_no =? order by c_regdate desc"; //최근 순서로 내림차순
		
		try {			
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();		
			while(rs.next()) {
				cdto = new CommentDTO();
				cdto.setcNoNovel(rs.getInt("c_no"));
				cdto.setmIdNovel(rs.getString("m_id"));
				cdto.setNovNo(rs.getInt("nov_no"));
				cdto.setcContentNovel(rs.getString("c_content"));
				cdto.setcRegdateNovel(rs.getDate("c_regdate"));
				
				res.add(cdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
		return res;
	}
	
	public void writeNovel(CommentDTO cdto) {
		sql = "insert into novcomment(c_content,m_id,nov_no,c_regdate) values(?,?,?,sysdate())";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, cdto.getcContentNovel());
			psmt.setString(2, cdto.getmIdNovel());
			psmt.setInt(3, cdto.getNovNo());
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
	}
	
	public void modifyNovel(CommentDTO cdto) {
		sql = "update novcomment set c_content=? where c_no=?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, cdto.getcContentNovel());
			psmt.setInt(2, cdto.getcNoNovel());
				
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
	}
		
	public void deleteNovel(int cNo) {
		sql = "delete from novcomment where c_no = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, cNo);
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
	}
	/** 마이페이지에서 내가 쓴 댓글 히스토리*/
	public NovelDTO comebackReturnNovelInfo(int novNo){
		NovelDTO res = null;
		sql = "select nov_title, nov_no, nov_epi, m_id "
				+ "from novel "
				+ "where nov_no = ?";	
		
	try {
		psmt = con.prepareStatement(sql);
		psmt.setInt(1, novNo);
		rs = psmt.executeQuery();		
		if(rs.next()) {
			res = new NovelDTO();
			res.setmId(rs.getString("m_id"));
			res.setNovTitle(rs.getString("nov_title"));
			res.setNovEpi(rs.getInt("nov_epi"));
			res.setNovNo(rs.getInt("nov_no"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close();
	}		
		
		return res;
	}	
	
	/** 마이페이지에서 내가 쓴 댓글 히스토리*/
	public ArrayList<CommentDTO> myCommentHistoryNovel(){
		ArrayList<CommentDTO> res = new ArrayList<CommentDTO>();
		
		CommentDTO cdto = null;
		
		sql = "select novel.nov_img , novel.nov_title , novel.nov_epi , novel.m_id as author, novel.nov_no, "
				+ "novcomment.c_content , novcomment.m_id , novcomment.c_regdate , novcomment.c_no "
				+ "from novcomment join novel "
				+ "on novcomment.nov_no = novel.nov_no "
				+ "order by novcomment.c_regdate desc";	
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();		
			while(rs.next()) {
				cdto = new CommentDTO();
				cdto.setcNoNovel(rs.getInt("c_no"));
				cdto.setmIdNovel(rs.getString("m_id"));
				cdto.setcContentNovel(rs.getString("c_content"));
				cdto.setcRegdateNovel(rs.getDate("c_regdate"));
				cdto.setNovTitle(rs.getString("nov_title"));
				cdto.setNovEpi(rs.getString("nov_epi"));
				cdto.setNovNo(rs.getInt("novel.nov_no"));
				cdto.setNovImg(rs.getString("nov_img"));
				cdto.setNovMid(rs.getString("author"));
				res.add(cdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
		return res;
	}
	
	/** CommentDAO.list() => comment 테이블 목록*/
	public ArrayList<CommentDTO> listBoard(){
		ArrayList<CommentDTO> res = new ArrayList<CommentDTO>();
		CommentDTO cdto = null;
		sql = "select * from boardcomment order by c_regdate desc"; //최근 순서로 내림차순
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();		
			while(rs.next()) {
				cdto = new CommentDTO();
				cdto.setcNoBoard(rs.getInt("c_no"));
				cdto.setmIdBoard(rs.getString("m_id"));
				cdto.setBoardNo(rs.getInt("b_no"));
				cdto.setcContentBoard(rs.getString("c_content"));
				cdto.setcRegdateBoard(rs.getDate("c_regdate"));
				res.add(cdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
		return res;
	}
	
	public void writeBoard(CommentDTO cdto) {
		sql = "insert into boardcomment(c_content,m_id,b_no,c_regdate) values(?,?,?,sysdate())";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, cdto.getcContentBoard());
			psmt.setString(2, cdto.getmIdBoard());
			psmt.setInt(3, cdto.getBoardNo());
				
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
	}
	
	public void modifyBoard(CommentDTO cdto) {
		sql = "update boardcomment set c_content=? where c_no=?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, cdto.getcContentBoard());
			psmt.setInt(2, cdto.getcNoBoard());
				
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
	}
		
	public void deleteBoard(int cNo) {
		sql = "delete from boardcomment where c_no = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, cNo);
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
	}
	
	/** 마이페이지에서 내가 쓴 댓글 히스토리*/
	public ArrayList<CommentDTO> myCommentHistoryBoard(){
		ArrayList<CommentDTO> res = new ArrayList<CommentDTO>();
		
		CommentDTO cdto = null;
		
		sql = "select board.b_title, board.b_type, board.m_id as writer, "
				+ "boardcomment.c_content , boardcomment.m_id , boardcomment.c_regdate , boardcomment.c_no "
				+ "from boardcomment join board "
				+ "on boardcomment.b_no = board.b_no "
				+ "order by boardcomment.c_regdate desc";	
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();		
			while(rs.next()) {
				cdto = new CommentDTO();
				cdto.setcNoBoard(rs.getInt("c_no"));
				cdto.setmIdBoard(rs.getString("m_id"));
				cdto.setcContentBoard(rs.getString("c_content"));
				cdto.setcRegdateBoard(rs.getTimestamp("c_regdate"));
				cdto.setBoardTitle(rs.getString("b_title"));
				cdto.setBoardType(rs.getString("b_type"));
				cdto.setBoardWriter(rs.getString("writer"));
			res.add(cdto);
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
	


