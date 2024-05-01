package dao_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dto_p.EventDTO;

public class EventDAO {
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	public EventDAO() {
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
	
	public ArrayList<EventDTO> list(){
		ArrayList<EventDTO> res = new ArrayList<EventDTO>();
		sql = "select * from event order by e_regdate desc"; //등록 날짜 기준 내림차순
		try {
			//System.out.println("1");
			psmt = con.prepareStatement(sql);
			//System.out.println("2");
			rs = psmt.executeQuery();		
			//System.out.println("3");
			while(rs.next()) {
				EventDTO edto = new EventDTO();
				edto.setEveNo(rs.getInt("e_no"));
				edto.setEveTitle(rs.getString("e_title"));
				edto.setEveContent(rs.getString("e_content"));
				edto.setEveImg(rs.getString("e_img"));
				edto.setEveStartDate(rs.getDate("e_startDate"));
				edto.setEveEndDate(rs.getDate("e_endDate"));
				edto.setEveRegdate(rs.getTimestamp("e_regdate"));
				res.add(edto);
			}
		
			//System.out.println("4");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
		return res;
	}
	
	/** event 테이블 삽입 순서 : e_title,e_img,e_content,e_startDate,e_endDate => 제목,이미지파일이름,내용,시작일,마감일 */
	public void eWrite(EventDTO edto) {
		
		sql = "insert into event(e_title,e_img,e_content,e_startDate,e_endDate,e_regdate) "
			 + "values(?,?,?,?,?,sysdate())";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, edto.getEveTitle());
			psmt.setString(2, edto.getEveImg());
			psmt.setString(3, edto.getEveContent());
			psmt.setString(4, edto.getEveStartDateStr());
			psmt.setString(5, edto.getEveEndDateStr());
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public void eModify(EventDTO edto) {
		
		sql = "update event set e_title=?,e_img=?,e_content=?,e_startDate=?,e_endDate=? where e_no=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, edto.getEveTitle());
			psmt.setString(2, edto.getEveImg());
			psmt.setString(3, edto.getEveContent());
			psmt.setString(4, edto.getEveStartDateStr());
			psmt.setString(5, edto.getEveEndDateStr());
			psmt.setInt(6, edto.getEveNo());
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	/** 글쓰기 후 바로 글 작성 상세 페이지로 가기 위한 메소드*/
	public int edtoNo() {
		int res = 0;
		
		sql = "select max(e_no) from event";		
		try {
			psmt = con.prepareStatement(sql);
					
			rs = psmt.executeQuery();	
			rs.next();
			res = rs.getInt(1); //event 테이블의 1번 : e_no
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	
	
	public EventDTO eDetail(int eNo){
		EventDTO edto = null;
		sql = "select * from event where e_no=?"; 
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, eNo);
			rs = psmt.executeQuery();		
			while(rs.next()) {
				edto = new EventDTO();
				edto.setEveNo(rs.getInt("e_no"));
				edto.setEveTitle(rs.getString("e_title"));
				edto.setEveContent(rs.getString("e_content"));
				edto.setEveImg(rs.getString("e_img"));
				edto.setEveStartDate(rs.getDate("e_startDate"));
				edto.setEveEndDate(rs.getDate("e_endDate"));
				edto.setEveRegdate(rs.getTimestamp("e_regdate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
		return edto;
	}
	
	//event 고유 번호를 지움
	public void eDelete(int eNo) {
		
		sql = "delete from event where e_no = ?";  
	
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, eNo);
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
	}
	public void fileDelete(int eNo) {
		
		sql = "update event set e_img = null where e_no = ?";  
	
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, eNo);
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	

}
