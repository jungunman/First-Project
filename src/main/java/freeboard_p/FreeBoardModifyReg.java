package freeboard_p;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao_p.BoardDAO;
import dto_p.BoardDTO;
import dto_p.MemberDTO;
import service_p.BoardService;

public class FreeBoardModifyReg implements BoardService{

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		try {
			MemberDTO login = (MemberDTO)request.getSession().getAttribute("NovelMember"); //1 세션받기
			BoardDTO dto = new BoardDTO();
			dto.setNo(Integer.parseInt(request.getParameter("no")));
			dto.setTitle(request.getParameter("title"));
			dto.setmId(login.getmId());                          //받은세션 겟
			dto.setContent(request.getParameter("content"));
			
			
			new BoardDAO().modify(dto);
			
			System.out.println("FreeBoardModifyReg.execute() 실행: ㅡㅡㅡㅡㅡㅡㅡ"+dto);
			
			
			request.setAttribute("dto", dto);
			request.setAttribute("incUrl", "components/moveUrl.jsp");
			request.setAttribute("msg", "수정되었습니다.");
			request.setAttribute("move", "FreeBoardList");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
