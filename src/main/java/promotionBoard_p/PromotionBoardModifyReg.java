package promotionBoard_p;

import dao_p.PromotionBoardDAO;
import dto_p.MemberDTO;
import dto_p.PromotionBoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.BoardService;

public class PromotionBoardModifyReg implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		try {
			MemberDTO login = (MemberDTO)request.getSession().getAttribute("NovelMember");
			PromotionBoardDTO dto = new PromotionBoardDTO();
			dto.setNo(Integer.parseInt(request.getParameter("no")));
			dto.setTitle(request.getParameter("title"));
			dto.setmId(login.getmId());
			dto.setContent(request.getParameter("content"));
			
			new PromotionBoardDAO().modify(dto);

			System.out.println("PromotionBoardModifyReg.execute() 실행:" + dto);

			request.setAttribute("dto", dto);
			
			
			
			request.setAttribute("incUrl", "components/moveUrl.jsp");
			request.setAttribute("msg", "수정되었습니다.");
			request.setAttribute("move", "PromotionBoardList");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
