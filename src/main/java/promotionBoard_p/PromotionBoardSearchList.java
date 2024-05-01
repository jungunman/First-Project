package promotionBoard_p;

import java.util.ArrayList;

import dao_p.PromotionBoardDAO;
import dto_p.PromotionBoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.BoardService;

public class PromotionBoardSearchList implements BoardService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	ArrayList<PromotionBoardDTO> data = new PromotionBoardDAO().searchlist(request.getParameter("title"));
	
	request.setAttribute("mainData", data);
	      // 안받아지는데 "mainData" < 그냥 얘를 "dto"로 바꿔도 되나요?
	System.out.println("서치 자바 진입확인"+data);
		
		
	}

}
