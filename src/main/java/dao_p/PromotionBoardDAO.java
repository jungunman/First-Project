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
import dto_p.NovelDTO;
import dto_p.PromotionBoardDTO;
import etc_p.Paging;

public class PromotionBoardDAO {

	
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	
	public PromotionBoardDAO() {
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
	
	public ArrayList<PromotionBoardDTO> list(Paging page){   
		ArrayList<PromotionBoardDTO> res = new ArrayList<PromotionBoardDTO>();
		sql = "select b.b_no,b.b_title, b.b_write_day, b.b_like ,b.m_id , b.b_content , b.b_cnt, m.m_nickname, n.nov_title,n.nov_img from board as b "
			+"left join member as m "
			+"on b.m_id  = m.m_id "
			+"left join novel as n "
			+"on n.nov_no = b.nov_no "
			+"where b_type='홍보' "
			+"order by b.b_no  desc "
			+"limit ?,?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, page.getSearchNo());
			psmt.setInt(2, page.getLimit());
			
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {

				PromotionBoardDTO dto = new PromotionBoardDTO();
				
				dto.setNo(rs.getInt("b.b_no"));
				dto.setTitle(rs.getString("b.b_title"));
				dto.setmId(rs.getString("b.m_id"));
				dto.setContent(rs.getString("b.b_content"));
				dto.setCnt(rs.getInt("b.b_cnt"));
				dto.setmNickname(rs.getString("m.m_nickname"));
				dto.setnTitle(rs.getString("n.nov_title"));
				dto.setnImg(rs.getString("n.nov_img"));
				dto.setLike(rs.getInt("b.b_like"));
				dto.setWriteDay(rs.getDate("b.b_write_day"));
				
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
	
	
	public PromotionBoardDTO detail(int no){
		PromotionBoardDTO dto = null;
		
		sql = "select b.b_write_day,b.b_cnt, b.b_no,b.b_title , b.m_id , b.b_content , b.b_cnt, m.m_id,m.m_nickname,"
				+" n.nov_title,n.nov_img, n.nov_genre, n.nov_cnt, n.nov_like, n.serial_date, n.m_id , n.nov_intro, max(n.nov_epi) as maxEpi "
				+"from board as b "
				+"left join member as m "
				+"on b.m_id  = m.m_id "
				+"left join novel as n "
				+"on n.nov_no = b.nov_no "
				+"where b_type='홍보'  and b.b_no = ? ";
		
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			
			if(rs.next()) {

				dto = new PromotionBoardDTO();
				
				dto.setnImg(rs.getString("n.nov_img"));
				dto.setnTitle(rs.getString("n.nov_title"));
				dto.setNo(rs.getInt("b.b_no"));
				dto.setTitle(rs.getString("b.b_title"));
				dto.setmId(rs.getString("m.m_id"));
				dto.setContent(rs.getString("b_content"));
				dto.setWriteDay(rs.getTimestamp("b_write_day"));
				dto.setNovGenre(rs.getString("n.nov_genre"));
				dto.setNovCnt(rs.getInt("n.nov_cnt"));
				dto.setNovLike(rs.getInt("nov_like"));
				dto.setSerialDate(rs.getString("n.serial_date"));
				dto.setNovAuthor(rs.getString("n.m_id"));
				dto.setNovIntro(rs.getString("n.nov_intro"));
				dto.setNovMaxEpi(rs.getInt("maxEpi"));
				dto.setCnt(rs.getInt("b.b_cnt"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}

		return dto;
	}
	
	
	public void modify(PromotionBoardDTO dto){

		sql = "update board set b_title = ?, m_id =?, b_content =? where b_no = ?";
		
		try {
			 
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getmId());
			psmt.setString(3, dto.getContent());
			psmt.setInt(4, dto.getNo());
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}

	}
	public void delete(int no){

		sql = "delete from board where b_no = ?";
		
		
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

	}
	
	public NovelDTO getNovelInfo(String mNickname, String title) {
	
		
		NovelDTO dto = null;
		
		sql ="select n.m_id ,n.nov_title , n.nov_no from novel as n "
				+ "group by n.nov_title "
				+ "having n.m_id = ? and n.nov_title = ? ";
		
		
		
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, mNickname);
			psmt.setString(2, title);
			
			rs= psmt.executeQuery();
			if(rs.next()) {
				dto=new NovelDTO();
				dto.setmId(rs.getString("m_id"));
				dto.setNovTitle(rs.getString("nov_title"));
				dto.setNovNo(rs.getInt("nov_no"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		
		
		return dto;
		
	}
	
	
	public void write(PromotionBoardDTO dto){

		sql = "insert into board (b_type, b_title , m_id, b_content , b_write_day,nov_no,b_artist) values ('홍보',?,?,?,sysdate(),?,?)";
		
		
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getmId());
			psmt.setString(3, dto.getContent());
			psmt.setInt(4, dto.getNovNo());
			psmt.setString(5, dto.getmNickname());
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	
	public int newNo(){
		int res = 0;
		sql = "select max(no) from board";
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			rs.next();
			res = rs.getInt(1);			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}

		return res;
	}
	
	public ArrayList<PromotionBoardDTO> searchlist(String title){   
		ArrayList<PromotionBoardDTO> res = new ArrayList<PromotionBoardDTO>();
		sql = "select nov_title,m_id from novel "
				+ "where nov_title like ? ";
				
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, "%"+title+"%");
			System.out.println("psmt : "+psmt);
			rs = psmt.executeQuery();
			
			while(rs.next()) {

				PromotionBoardDTO dto = new PromotionBoardDTO();
				
				dto.setmId(rs.getString("m_id"));
				dto.setnTitle(rs.getString("nov_title"));
				
				
				res.add(dto);
				
			}
			
			System.out.println(res);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}

		return res;
	}
	
	//*promotionBoardDetail에서 호출*/
			public void boardCnt(int bNo) {
				sql="update board set "
						+ "b_cnt = board.b_cnt + 1 "
						+ "where b_no = ? ";
				System.out.println("보더 카운트 실행 ---------------"+sql);
				try {
					psmt = con.prepareStatement(sql);
					psmt.setInt(1, bNo);
					
					
					psmt.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					close();
				}
			}
			
			public void boardLike(int bNo) {
				sql="update board set "
						+ "b_like = board.b_like + 1 "
						+ "where b_no = ? ";
				System.out.println("보더 카운트 실행 ---------------"+sql);
				try {
					psmt = con.prepareStatement(sql);
					psmt.setInt(1, bNo);
					psmt.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					close();
				}
				
			}
	
}


