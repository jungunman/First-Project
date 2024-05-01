package promotionBoard_p;

import dao_p.BoardDAO;
import dao_p.PromotionBoardDAO;
import dto_p.PromotionBoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.BoardService;

public class PromotionBoardDetail implements BoardService {

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		
		new PromotionBoardDAO().boardCnt(no);
		PromotionBoardDTO dto = new PromotionBoardDAO().detail(no);
		
		
		
		request.setAttribute("dto", dto);
		
		System.out.println("홍보디테일 java진입----");
		
		
	}
}
