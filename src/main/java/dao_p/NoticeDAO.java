package dao_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto_p.NoticeDTO;
import etc_p.Paging;

public class NoticeDAO {

	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	public NoticeDAO() {

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
	
	/**공지사항 전체 리스트 보기*/
	public ArrayList<NoticeDTO> list(Paging page) {
		ArrayList<NoticeDTO> res = new ArrayList<NoticeDTO>();
		
		sql = "select * from notice order by n_no desc limit ?,?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, page.getSearchNo());
			psmt.setInt(2, page.getLimit());			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				dto.setnNo(rs.getInt("n_no"));
				dto.setnTitle(rs.getString("n_title"));
				dto.setnTime(rs.getTimestamp("n_time"));
				dto.setnContent(rs.getString("n_content"));
				dto.setnTime(rs.getDate("n_time"));
				
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
	
	/**공지사항 상세 보기! - 비회원/회원 구분없이 모두 확인 가능*/
	public NoticeDTO detail(int no) {
		NoticeDTO dto = null;
		
		sql = "select * from notice where n_no = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, no);
			
			rs = psmt.executeQuery();

			if(rs.next()) {
				dto = new NoticeDTO();
				dto.setnNo(rs.getInt("n_no"));
				dto.setnTitle(rs.getString("n_title"));
				dto.setnTime(rs.getTimestamp("n_time"));
				dto.setnContent(rs.getString("n_content"));
				dto.setmImg(rs.getString("n_img"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	
	/**공지사항 글 작성 - 관리자*/
	public void noticeWrite(NoticeDTO dto) {
		
		sql = "insert into notice(n_title, n_content, n_img, n_time) values(?,?,?,sysdate())";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getnTitle());
			psmt.setString(2, dto.getnContent());
			psmt.setString(3, dto.getmImg());
			
			psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	/**공지사항 글 수정 - 관리자*/
	public void noticeModify(NoticeDTO dto) {
		
		sql = "update notice set n_title = ?, n_time = sysdate(), n_content = ?, n_img = ? where n_no = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getnTitle());
			psmt.setString(2, dto.getnContent());
			psmt.setString(3, dto.getmImg());
			psmt.setInt(4, dto.getnNo());
			
			psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	/**공지사항 글 삭제 - 관리자*/
	public NoticeDTO noticeDelete(int no) {
		NoticeDTO dto = null;
		
		sql = "delete from notice where n_no = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, no);
			
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
