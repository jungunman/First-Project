package main_p;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dao_p.MainDAO;
import dto_p.BoardDTO;
import dto_p.EventDTO;
import dto_p.NoticeDTO;
import dto_p.NovelDTO;
import etc_p.DateControl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainUtills {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private DateControl dc; 
	
	
	public MainUtills(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.dc = new DateControl();
		dc.setMinusDate(7);
	}
	
	/** 일주일 전 기준 조회수가 가장 높은 소설 10개가 뽑혀 옵니다.*/
	public void getWeekTopTen() {
		ArrayList<NovelDTO> dto = new MainDAO().showWeekTopTen(dc.getDaysStr());
		request.setAttribute("weekTopTen", dto);
	}
	
	/** 가장 최근 업로드된 소설을 가져옵니다.*/
	public void getRecentNovel() {
		ArrayList<NovelDTO> dto = new MainDAO().showRecentNovel();
		request.setAttribute("recentUploadNovel", dto);
	}
	
	/**연재 장르별 인기순위 10개 가져옵니다. */
	public void getNovelByGenre(String genre) {
		String selectedGenre ="판타지";
		if(genre != null) {
			selectedGenre = genre;
		}
		ArrayList<NovelDTO> dto = new MainDAO().showPopularNovelsByGenre(selectedGenre);
		request.setAttribute("genreNovel", dto);
	}
	
	
	/**홍보 게시글 인기 5개 가져옵니다.*/
	public void getPromotionalBoard() {
		ArrayList<BoardDTO> dto = new MainDAO().showPopularTypeBoard(dc.getDaysStr(),"홍보");
		request.setAttribute("popularPromotionBoard", dto);
	}
	/**자유 게시글 인기 5개 가져옵니다.*/
	public void getFreeBoard() {
		ArrayList<BoardDTO> dto = new MainDAO().showPopularTypeBoard(dc.getDaysStr(),"자유");
		request.setAttribute("popularFreeBoard", dto);
	}
	/**최근 공지사항 게시글 5개 가져옵니다.*/
	public void getNoticeBoard() {
		ArrayList<NoticeDTO> dto = new MainDAO().showRecentNotice();
		request.setAttribute("recentNotice", dto);
	}
	/**진행중인 이벤트 5개 가져옵니다*/
	public void getEventBoard() {
		ArrayList<EventDTO> dto = new MainDAO().showRecentEvent();
		request.setAttribute("recentEvent", dto);
	}
	
	
}
