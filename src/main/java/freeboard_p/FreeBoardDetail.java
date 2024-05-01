package freeboard_p;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao_p.BoardDAO;
import dto_p.BoardDTO;
import service_p.BoardService;

public class FreeBoardDetail implements BoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		new BoardDAO().boardCnt(no);
		BoardDTO dto = new BoardDAO().detail(no);
		request.setAttribute("dto", dto);
//		System.out.println("FreeboardDetail.execute() 실행:");
		
	}
}
