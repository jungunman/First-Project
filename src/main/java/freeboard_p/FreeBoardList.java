package freeboard_p;

import dto_p.BoardDTO;
import etc_p.Paging;
import dao_p.BoardDAO;
import dao_p.PageDAO;

import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.BoardService;

public class FreeBoardList implements BoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		//페이징 정보			sql = count()로 전체 rows 갯수를 가져오고 int값으로 넣어준다 , 보여줄 row 갯수
		Paging page = new Paging(request, new PageDAO().getTotalFreeBoardCnt(), 20);
		
		ArrayList<BoardDTO> data = new BoardDAO().list(page);
		request.setAttribute("pagingUrl", "/freeboard/FreeBoardList?page=");
		request.setAttribute("paging", page);
		request.setAttribute("mainData", data);
	}
}
