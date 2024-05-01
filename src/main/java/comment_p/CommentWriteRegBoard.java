package comment_p;

import dao_p.CommentDAO;
import dto_p.CommentDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.CommentService;

public class CommentWriteRegBoard implements CommentService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		CommentDTO cdto = new CommentDTO();
		
		cdto.setmIdBoard(request.getParameter("m_id"));
		cdto.setcContentBoard(request.getParameter("c_content"));
		cdto.setBoardNo(Integer.parseInt(request.getParameter("b_no")));
		
		new CommentDAO().writeBoard(cdto); //댓글 작성 값 넣어주기
		
		//list  뿌리기--------------  
	
		request.setAttribute("msg", "작성되었습니다");
		request.setAttribute("move", "CommentListBoard");
		request.setAttribute("incUrl", "components/moveUrl.jsp");
	}

}
