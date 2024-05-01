package promotionBoard_p;

import dao_p.PromotionBoardDAO;
import dto_p.PromotionBoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.BoardService;

public class PromotionBoardModifyForm implements BoardService {

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		PromotionBoardDTO dto = new PromotionBoardDAO().detail(no);
		System.out.println("와냐?");
		request.setAttribute("dto", dto);
		
	}
	
}
