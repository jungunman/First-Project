package comment_p;

import dao_p.CommentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.CommentService;

public class CommentDeleteBoard implements CommentService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		new CommentDAO().deleteBoard(Integer.parseInt(request.getParameter("c_no")));
		
		request.setAttribute("msg", "삭제됐습니다");
		request.setAttribute("move", "CommentListBoard");
		request.setAttribute("incUrl", "components/moveUrl.jsp");
	}

}
