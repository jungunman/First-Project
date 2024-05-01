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
import etc_p.Paging;

/*
create table board(
	b_no int not null primary key auto_increment, -- 게시글번호
	b_type varchar(20) not null default "자유", -- 게시글타입
	b_like int default 0,                  -- 게시글좋아요수
	b_cnt int default 0,                   -- 게시글조회수
	b_content varchar (9999) not null default "내용을 10자이상 입력해주세요",     -- 게시글내용
	b_title varchar(20) not null default "제목을 5자이상 입력해주세요",         -- 게시글제목 
	b_write_day datetime,        -- 작성시간
	m_id varchar(20) not null,	   -- 외래키 ->member 테이블 참조
	b_img varchar(100) default 'nosign.jpg'
	
);
	*/
public class BoardDAO {
	
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public BoardDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/novel");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Board Con : "+ con);
		
		//close();
	}
	
	void close() {
		if(rs!=null) { try { rs.close();} catch (SQLException e) {}}
		if(psmt!=null) { try { psmt.close();} catch (SQLException e) {}}
		if(con!=null) { try { con.close();} catch (SQLException e) {}}
	}
	//*페이징추후 추가*/
	
	public ArrayList<BoardDTO> list(Paging page){   
		ArrayList<BoardDTO> res = new ArrayList<BoardDTO>();
		sql = "select * from board where b_type = '자유' "
				+ "order by b_no desc "
				+ "limit ?,?"; 
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, page.getSearchNo());
			psmt.setInt(2, page.getLimit());
			rs = psmt.executeQuery();
			while(rs.next()) {

				BoardDTO dto = new BoardDTO();
				
				dto.setNo(rs.getInt("b_no"));
				dto.setType(rs.getString("b_type"));
				dto.setLike(rs.getInt("b_like"));
				dto.setCnt(rs.getInt("b_cnt"));
				dto.setContent(rs.getString("b_content"));
				dto.setTitle(rs.getString("b_title"));
				dto.setWriteDay(rs.getTimestamp("b_write_day"));
				dto.setmId(rs.getString("m_id"));
				
				
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
	
	public BoardDTO detail(int no){
		BoardDTO dto = null;
		sql = "select * from board where b_no = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			
			if(rs.next()) {

				dto = new BoardDTO();
				dto.setNo(rs.getInt("b_no"));
				dto.setTitle(rs.getString("b_title"));
				dto.setmId(rs.getString("m_id"));
				dto.setContent(rs.getString("b_content"));
				dto.setWriteDay(rs.getTimestamp("b_write_day"));
				dto.setCnt(rs.getInt("b_cnt"));
				dto.setLike(rs.getInt("b_like"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}

		return dto;
	}
	
	public void modify(BoardDTO dto){

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
	

		public void write(BoardDTO dto){

			
			sql = "insert into board ( b_title , m_id, b_content , b_write_day) values (?,?,?,sysdate())";
			try {
				psmt = con.prepareStatement(sql);
				psmt.setString(1, dto.getTitle());
				psmt.setString(2, dto.getmId());
				psmt.setString(3, dto.getContent());
				
				
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
		//*FreeBoardDetail에서 호출*/
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
	
