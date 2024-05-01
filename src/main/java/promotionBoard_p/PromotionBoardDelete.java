package promotionBoard_p;


import dao_p.PromotionBoardDAO;
import dto_p.PromotionBoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.BoardService;

public class PromotionBoardDelete implements BoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		
		PromotionBoardDTO dto = new PromotionBoardDAO().detail(no);
		
		new PromotionBoardDAO().delete(no);
		System.out.println("홍보삭제JAVA진입");
		request.setAttribute("incUrl", "promotionBoard/PromotionBoardDelete.jsp");
		
	}
	
}
