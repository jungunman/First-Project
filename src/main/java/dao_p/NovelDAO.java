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

import dto_p.NovelDTO;

public class NovelDAO {
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public NovelDAO() {
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
	
	
	
	public ArrayList<NovelDTO> novelList(String novMenu) {
		ArrayList<NovelDTO> res = new ArrayList<NovelDTO>();
		if(novMenu==null) {					
			sql = "select sum(n.nov_cnt)totalCnt, sum(n.nov_like)totalLike, count(*) totalEpi, "
					+ "n.nov_title, n.nov_intro, N.nov_img , max(n.nov_regdate) recent_reg, m.m_id as member_id, m.m_nickname, n.nov_genre "
					+ "from novel as n "
					+ "left join member as m "
					+ "on n.m_id = m.m_id "
					+ "group by n.nov_title, member_id "
					+ "order by recent_reg desc";
			
		}else if (novMenu.equals("new")){
			sql = "select sum(n.nov_cnt)totalCnt, sum(n.nov_like)totalLike, count(*) totalEpi, "
					+ "n.nov_title, n.nov_intro, N.nov_img , max(n.nov_regdate) recent_reg, m.m_id as member_id, m.m_nickname, n.nov_genre "
					+ "from novel as n "
					+ "left join member as m "
					+ "on n.m_id = m.m_id "
					+ "group by n.nov_title, member_id "
					+ "order by recent_reg desc limit 4";
		}else if(novMenu.equals("best")){
			sql = "select sum(n.nov_cnt)totalCnt, sum(n.nov_like)totalLike, count(*) totalEpi, "
					+ "n.nov_title, n.nov_intro, N.nov_img , max(n.nov_regdate) recent_reg, m.m_id as member_id, m.m_nickname, n.nov_genre "
					+ "from novel as n "
					+ "left join member as m "
					+ "on n.m_id = m.m_id "
					+ "group by n.nov_title, member_id "
					+ "order by totalCnt desc limit 4";
		}else {

			sql = "select sum(n.nov_cnt)totalCnt, sum(n.nov_like)totalLike, count(*) totalEpi, "
					+ "n.nov_title, n.nov_intro, N.nov_img , max(n.nov_regdate) recent_reg, m.m_id as member_id, m.m_nickname, n.nov_genre "
					+ "from novel as n "
					+ "left join member as m "
					+ "on n.m_id = m.m_id "
					+ "where nov_genre='"+novMenu+"' "
					+ "group by n.nov_title, member_id "
					+ "order by recent_reg desc";
		}
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				NovelDTO dto = new NovelDTO();
				
				dto.setmId(rs.getString("member_id"));
				dto.setmNickname(rs.getString("m_nickname"));
				dto.setNovTitle(rs.getString("nov_title"));				
				dto.setNovGenre(rs.getString("nov_genre"));
				dto.setNovIntro(rs.getString("nov_intro"));
				dto.setNovImg(rs.getString("nov_img"));
				dto.setNovTotEpi(rs.getInt("totalEpi"));
				dto.setNovTotCnt(rs.getInt("totalCnt"));
				dto.setNovTotLike(rs.getInt("totalLike"));
				
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
	
	
	public ArrayList<NovelDTO> novelDetail(String title, String id) {
		ArrayList<NovelDTO> res = new ArrayList<NovelDTO>();
		
		sql = "select *, "
				+ "(select count(*) from novel where nov_title=? and m_id=?) totalEpi, "
				+ "(select sum(nov_cnt) from novel where nov_title=? and m_id=?) totalCnt, "
				+ "(select sum(nov_like) from novel where nov_title=? and m_id=?) totalLike "
				+ "from novel "
				+ "where nov_title=? and m_id=? "
				+ "order by nov_Epi desc";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, id);
			psmt.setString(3, title);
			psmt.setString(4, id);
			psmt.setString(5, title);
			psmt.setString(6, id);
			psmt.setString(7, title);
			psmt.setString(8, id);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				NovelDTO dto = new NovelDTO();
				
				dto.setmId(rs.getString("m_id"));
				dto.setNovTitle(rs.getString("nov_title"));				
				dto.setNovGenre(rs.getString("nov_genre"));
				dto.setNovImg(rs.getString("nov_img"));
				dto.setNovIntro(rs.getString("nov_intro"));
				dto.setNovTotEpi(rs.getInt("totalEpi"));
				dto.setNovTotCnt(rs.getInt("totalCnt"));
				dto.setNovTotLike(rs.getInt("totalLike"));
				dto.setSerialDate(rs.getString("serial_date"));
				dto.setNovSubtitle(rs.getString("nov_subtitle"));
				dto.setNovCont(rs.getString("nov_cont"));
				dto.setNovNo(rs.getInt("nov_no"));
				dto.setNovEpi(rs.getInt("nov_epi"));
				dto.setNovCnt(rs.getInt("nov_cnt"));
				dto.setNovLike(rs.getInt("nov_like"));
				dto.setNovOpen(rs.getInt("nov_open"));
				dto.setNovRegdate(rs.getTimestamp("nov_regdate"));
				
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
	
	public String getNick(String mId) {
		String nick="" ;
		sql = "select m_nickname from member where m_id=?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, mId);
			rs = psmt.executeQuery();
			
			if(rs.next()) {

				nick = rs.getString("m_nickname");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return nick;
	}
	
	
	public void novelWrite(NovelDTO dto) {
		sql = "insert into novel (m_id, nov_title, nov_genre, nov_img, nov_intro, serial_date, nov_subtitle, nov_cont, nov_epi, nov_open, nov_regdate) "
				+ "values(?,?,?,?,?,?,?,?,?,?,sysdate())";
		if(dto.getNovImg() == null) {
			dto.setNovImg("cover_holder.jpg");
		}
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getmId());
			psmt.setString(2, dto.getNovTitle());
			psmt.setString(3, dto.getNovGenre());
			psmt.setString(4, dto.getNovImg());
			psmt.setString(5, dto.getNovIntro());
			psmt.setString(6, dto.getSerialDate());
			psmt.setString(7, dto.getNovSubtitle());
			psmt.setString(8, dto.getNovCont());
			psmt.setInt(9, dto.getNovEpi());
			psmt.setInt(10, dto.getNovOpen());
			
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	

	public NovelDTO novelView(String title, String id, int epiNo) {
		NovelDTO dto = null;
		sql = "select * from novel where nov_title=? and m_id=? and nov_epi=?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, id);
			psmt.setInt(3, epiNo);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new NovelDTO();
				dto.setmId(rs.getString("m_id"));
				dto.setNovTitle(rs.getString("nov_title"));
				dto.setNovSubtitle(rs.getString("nov_subtitle"));
				dto.setNovCont(rs.getString("nov_cont"));
				dto.setNovEpi(rs.getInt("nov_epi"));
				dto.setNovNo(rs.getInt("nov_no"));
				dto.setNovLike(rs.getInt("nov_like"));
				dto.setNovCnt(rs.getInt("nov_cnt"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}		
		
		return dto;
	}
	
	public NovelDTO novelReport(int novNo) {
		NovelDTO dto = null;
		sql = "select * from novel where nov_no=?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, novNo);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new NovelDTO();
				dto.setmId(rs.getString("m_id"));
				dto.setNovTitle(rs.getString("nov_title"));
				dto.setNovSubtitle(rs.getString("nov_subtitle"));
				dto.setNovCont(rs.getString("nov_cont"));
				dto.setNovEpi(rs.getInt("nov_epi"));
				dto.setNovNo(rs.getInt("nov_no"));
				dto.setNovLike(rs.getInt("nov_like"));
				dto.setNovCnt(rs.getInt("nov_cnt"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}		
		
		return dto;
	}
	

	public void viewCnt(int cntUp, int novNo) {
		sql="update novel set nov_cnt = ? where nov_no = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, cntUp);
			psmt.setInt(2, novNo);
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	public void novelLike(int upLike, String title, String id, int novEpi) {
		sql="update novel set nov_like=? where nov_title=? and m_id=? and nov_epi=?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, upLike);
			psmt.setString(2, title);
			psmt.setString(3, id);
			psmt.setInt(4, novEpi);
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public void novelOpen(String title, String id, int novEpi) {
		sql="update novel set nov_open=? where nov_title=? and m_id=? and nov_epi=?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, 1);
			psmt.setString(2, title);
			psmt.setString(3, id);
			psmt.setInt(4, novEpi);
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public void epiModify(NovelDTO dto) {
		sql="update novel set nov_subtitle=?, nov_cont=? where nov_no=?";
		
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, dto.getNovSubtitle());
			psmt.setString(2, dto.getNovCont());
			psmt.setInt(3, dto.getNovNo());
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	public void novelModify(NovelDTO dto, String novTitle) {
		sql="update novel set nov_title=?, nov_genre=?, nov_intro=?, serial_date=?, nov_img=? where nov_title=? and m_id=?";
		
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, dto.getNovTitle());
			psmt.setString(2, dto.getNovGenre());
			psmt.setString(3, dto.getNovIntro());
			psmt.setString(4, dto.getSerialDate());
			psmt.setString(5, dto.getNovImg());
			psmt.setString(6, novTitle);
			psmt.setString(7, dto.getmId());
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	public void epiDelete(int novNo){

		sql = "delete from novel where nov_no = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, novNo);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}

	}
	
	public void novelDelete(String title, String id){

		sql = "delete from novel where nov_title=? and m_id=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}

	}

}
