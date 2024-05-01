package freeboard_p;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.BoardService;
import dto_p.BoardDTO;
import dto_p.MemberDTO;
import dao_p.BoardDAO;
public class FreeBoardWriteReg implements BoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			MemberDTO mdto = (MemberDTO)request.getSession().getAttribute("NovelMember");
			System.out.println("FreeBoardWriteReg 실행 !!!!");
			BoardDTO dto = new BoardDTO();
			
			dto.setTitle(request.getParameter("title"));
			
			dto.setmId(mdto.getmId());
			dto.setContent(request.getParameter("content"));
			
			new BoardDAO().write(dto);
			
			int no = new BoardDAO().newNo();
			
			request.setAttribute("incUrl", "components/moveUrl.jsp");
			request.setAttribute("msg", "작성되었습니다.");
			request.setAttribute("move", "FreeBoardList");
			

			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	
}
