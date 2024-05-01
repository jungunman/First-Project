package dao_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto_p.BoardDTO;
import dto_p.EventDTO;
import dto_p.NoticeDTO;
import dto_p.NovelDTO;

public class MainDAO {

	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public MainDAO() {
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
	
	
	
	/** 일주일 전 기준으로 가장 인기 많은 소설을 10개 리턴합니다. */
	public ArrayList<NovelDTO> showWeekTopTen(String date){
		ArrayList<NovelDTO> dtos = new ArrayList<NovelDTO>(); 
		NovelDTO dto = null;
		sql = "select n.nov_no, n.nov_title, n.nov_img, sum(n.nov_like) totLike ,sum(n.nov_cnt) totCnt, m.m_nickname, m.m_id "
				+ "from novel as n "
				+ "left join member as m "
				+ "on n.m_id = m.m_id "
				+ "where Date(n.nov_regdate) >= ? "
				+ "group by n.nov_title "
				+ "order by totCnt desc limit 0, 10";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, date);
			
			rs = psmt.executeQuery();
			
			
			while(rs.next()) {
				dto = new NovelDTO();
				dto.setmId(rs.getString("m_id"));
				dto.setNovNo(rs.getInt("nov_no"));
				dto.setmNickname(rs.getString("m_nickname"));
				dto.setNovTitle(rs.getString("nov_title"));
				dto.setNovImg(rs.getString("nov_img"));
				dto.setNovCnt(rs.getInt("totCnt"));
				dto.setNovLike(rs.getInt("totLike"));
				
				dtos.add(dto);
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dtos;
	}
	
	
	/** 최근에 업데이트 된 순으로 소설을 보여줍니다.*/
	public ArrayList<NovelDTO> showRecentNovel(){
		ArrayList<NovelDTO> dtos = new ArrayList<NovelDTO>(); 
		NovelDTO dto = null;
		sql = "select sum(nov_cnt)as totCnt, sum(nov_like) totLike, "
				+ "n.nov_title, n.nov_img, n.nov_no, m.m_nickname, m.m_id "
				+ "from novel as n "
				+ "left join member as m "
				+ "on m.m_id = n.m_id "
				+ "group by n.nov_title "
				+ "order by max(n.nov_regdate) desc "
				+ "limit 0,20";
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new NovelDTO();
				dto.setmId(rs.getString("m_id"));
				dto.setNovNo(rs.getInt("nov_no"));
				dto.setmNickname(rs.getString("m_nickname"));
				dto.setNovTitle(rs.getString("nov_title"));
				dto.setNovImg(rs.getString("nov_img"));
				dto.setNovCnt(rs.getInt("totCnt"));
				dto.setNovLike(rs.getInt("totLike"));
				
				dtos.add(dto);
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dtos;
	}
	
	
	/**연재 장르별 인기순위 10개 가져옵니다. */
	public ArrayList<NovelDTO> showPopularNovelsByGenre(String genre){
		ArrayList<NovelDTO> dtos = new ArrayList<NovelDTO>(); 
		NovelDTO dto = null;
		sql = "select sum(n.nov_cnt)totCnt, sum(n.nov_like)totLike, max(n.nov_epi) epi, "
				+ "n.nov_title, N.nov_img , max(n.nov_regdate) recentDate, m.m_id as member_id, m.m_nickname, n.nov_genre "
				+ "from novel as n "
				+ "left join member as m "
				+ "on n.m_id = m.m_id "
				+ "where n.nov_genre = ? "
				+ "group by n.nov_title "
				+ "limit 0,10";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, genre);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new NovelDTO();
				dto.setNovCnt(rs.getInt("totCnt"));
				dto.setNovLike(rs.getInt("totLike"));
				dto.setNovEpi(rs.getInt("epi"));
				dto.setNovTitle(rs.getString("nov_title"));
				dto.setNovImg(rs.getString("nov_img"));
				dto.setNovRegdate(rs.getDate("recentDate"));
				dto.setmId(rs.getString("member_id"));
				dto.setmNickname(rs.getString("m_nickname"));
				dto.setNovGenre(rs.getString("nov_genre"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dtos;
	}
	
	/** 홍보 게시판의 이미지일 경우는 소설의 표지를 따와야 하는 것으로 아는데 성재형 쿼리에서 img는 누구의 이미지인지 명시해주십쇼!
	 * 구조를 보아하니 홍보 게시판의 경우에 novel 테이블을 참조하는 외래키도 하나 필요할 것 같습니다.
	 * 그리고 댓글 수를 표시하는 컬럼도 필요합니다.
	 * */
	public ArrayList<BoardDTO> showPopularTypeBoard(String date, String type){
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();
		BoardDTO dto = null;
		
		sql = "select b.b_no, b.b_like, b.b_cnt, b.b_title, b.b_write_day "
				+ "from board as b "
				+ "where b.b_write_day >= ? "
				+ "and b.b_type = ? "
				+ "order by b.b_cnt desc "
				+ "limit 0, 10";
		
		try {
			psmt= con.prepareStatement(sql);
			psmt.setString(1, date);
			psmt.setString(2, type);
			rs= psmt.executeQuery();
			
			while(rs.next()) {
				dto = new BoardDTO();
				dto.setNo(rs.getInt("b_no"));
				dto.setLike(rs.getInt("b_like"));
				dto.setCnt(rs.getInt("b_cnt"));
				dto.setTitle(rs.getString("b_title"));
				dto.setWriteDay(rs.getDate("b_write_day"));
				
				dtos.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return dtos;
	}
	
	public ArrayList<NoticeDTO> showRecentNotice(){
		ArrayList<NoticeDTO> dtos = new ArrayList<NoticeDTO>();
		NoticeDTO dto = null;
		
		sql = "select n_no, n_title, n_time  from notice as n "
				+ "order by n.n_time desc "
				+ "limit 0, 5 ";
		
		try {
			psmt= con.prepareStatement(sql);
			rs= psmt.executeQuery();
			
			while(rs.next()) {
				dto = new NoticeDTO();
				dto.setnNo(rs.getInt("n_no"));
				dto.setnTitle(rs.getString("n_title"));
				dto.setnTime(rs.getDate("n_time"));
				
				dtos.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return dtos;
	}
	
	public ArrayList<EventDTO> showRecentEvent(){
		ArrayList<EventDTO> dtos = new ArrayList<EventDTO>();
		EventDTO dto = null;
		
		sql = "select e.e_no, e.e_title, e.e_regdate , e.e_startDate , e.e_endDate from event as e "
				+ "order by e.e_regdate desc, e.e_startDate desc, e.e_endDate desc "
				+ "limit 0, 5";
		
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new EventDTO();
				dto.setEveNo(rs.getInt("e_no"));
				dto.setEveTitle(rs.getString("e_title"));
				dto.setEveRegdate(rs.getDate("e_regdate"));
				dto.setEveStartDate(rs.getDate("e_startDate"));
				dto.setEveEndDate(rs.getDate("e_endDate"));
				
				dtos.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return dtos;
	}
	
	
}
