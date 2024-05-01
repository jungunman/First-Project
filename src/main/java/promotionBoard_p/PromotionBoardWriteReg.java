package promotionBoard_p;


import dao_p.PromotionBoardDAO;
import dto_p.MemberDTO;
import dto_p.NovelDTO;
import dto_p.PromotionBoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.BoardService;

public class PromotionBoardWriteReg implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		try {
			
			System.out.println("promotionBoardWriteReg 실행");
			MemberDTO mdto = (MemberDTO)request.getSession().getAttribute("NovelMember");
			PromotionBoardDTO dto = new PromotionBoardDTO();
			
			dto.setTitle(request.getParameter("title"));
			dto.setmId(mdto.getmId());
			dto.setContent(request.getParameter("content"));
			dto.setnTitle(request.getParameter("nTitle"));
			dto.setnImg(request.getParameter("nImg"));
			dto.setmNickname(request.getParameter("mNickname"));
			System.out.println(dto.getnTitle()+",,"+dto.getmNickname());
		
			NovelDTO pree =new PromotionBoardDAO().getNovelInfo(dto.getmNickname(), dto.getnTitle());
			
			dto.setNovNo(pree.getNovNo());
			
			new PromotionBoardDAO().write(dto);
		
			System.out.println("오냐?");
			request.setAttribute("incUrl", "components/moveUrl.jsp");
			request.setAttribute("msg", "작성되었습니다.");
			request.setAttribute("move", "PromotionBoardList");
		
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
