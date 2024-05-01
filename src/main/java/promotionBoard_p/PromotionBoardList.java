package promotionBoard_p;

import java.util.ArrayList;

import dao_p.PageDAO;
import dao_p.PromotionBoardDAO;
import dto_p.PromotionBoardDTO;
import etc_p.Paging;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.BoardService;

public class PromotionBoardList implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	Paging page = new Paging(request, new PageDAO().getTotalPromotionBoardCnt(), 10);
	ArrayList<PromotionBoardDTO> data = new PromotionBoardDAO().list(page);
	
	request.setAttribute("mainData", data);
	request.setAttribute("pagingUrl", "/promotionBoard/PromotionBoardList?page=");
	request.setAttribute("paging", page);
	
	System.out.println("홍보진입확인"+data);
		
		
	}
	
}
