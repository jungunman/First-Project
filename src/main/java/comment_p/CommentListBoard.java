package comment_p;

import java.util.ArrayList;

import dao_p.CommentDAO;
import dto_p.CommentDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.CommentService;

public class CommentListBoard implements CommentService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<CommentDTO> cdto = new CommentDAO().listBoard();
		request.setAttribute("cData", cdto);
		
	}

}
