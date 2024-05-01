package comment_p;

import java.util.ArrayList;

import dao_p.CommentDAO;
import dto_p.CommentDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.CommentService;

public class CommentModifyBoard implements CommentService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		CommentDTO cdto = new CommentDTO();
		//System.out.println(request.getParameter("c_no"));
		//System.out.println(request.getParameter("c_content"));
		
		cdto.setcNoBoard(Integer.parseInt(request.getParameter("c_no")));
		cdto.setcContentBoard(request.getParameter("c_content"));
		
		new CommentDAO().modifyBoard(cdto);
		
		ArrayList<CommentDTO> cData = new CommentDAO().listBoard();
		request.setAttribute("cData", cData);
		request.setAttribute("msg", "수정되었습니다");
		request.setAttribute("move", "CommentListBoard");
		request.setAttribute("incUrl", "components/moveUrl.jsp");
		
	}

}
