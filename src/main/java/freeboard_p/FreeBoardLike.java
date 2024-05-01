package freeboard_p;

import dao_p.BoardDAO;
import dto_p.BoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.BoardService;

public class FreeBoardLike implements BoardService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		new BoardDAO().boardLike(no);
		BoardDTO dto = new BoardDAO().detail(no);
		request.setAttribute("dto", dto);
		System.out.println("FreeBoardLike.execute() 실행:");
		
		request.setAttribute("incUrl", "components/moveUrl.jsp");
		request.setAttribute("msg", "좋아요 감사합니다.");
		request.setAttribute("move", "FreeBoardList");
	}
	
}
