package freeboard_p;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao_p.BoardDAO;
import dto_p.BoardDTO;
import service_p.BoardService;

public class FreeBoardModifyForm implements BoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDTO dto = new BoardDAO().detail(no);
		request.setAttribute("dto", dto);
		
		
	}
}
