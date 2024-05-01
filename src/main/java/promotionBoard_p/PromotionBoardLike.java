package promotionBoard_p;

import dao_p.BoardDAO;
import dao_p.PromotionBoardDAO;
import dto_p.BoardDTO;
import dto_p.PromotionBoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.BoardService;

public class PromotionBoardLike implements BoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		new PromotionBoardDAO().boardLike(no);
		PromotionBoardDTO dto = new PromotionBoardDAO().detail(no);
		request.setAttribute("dto", dto);
		System.out.println("PromotionLike.execute() 실행:");
		
		request.setAttribute("incUrl", "components/moveUrl.jsp");
		request.setAttribute("msg", "좋아요 감사합니다.");
		request.setAttribute("move", "PromotionBoardList");
	}
	
}

