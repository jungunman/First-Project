package controller_p;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.CommentService;
import service_p.EventService;

import java.io.IOException;

@WebServlet("/comment/*")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CommentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String incfolder = "comment/";
		String incJsp = request.getRequestURI().substring((incfolder).length()+1);
		request.setAttribute("incUrl", "components/"+incfolder+incJsp+".jsp");
		System.out.println(incJsp);
	
		try {
			CommentService cser = (CommentService)Class.forName("comment_p."+incJsp).newInstance();
			cser.execute(request, response); // 해당 파일 별 implements 인스턴스 한 것들 실행 가능
			
			RequestDispatcher dispatcher = null;
			dispatcher = request.getRequestDispatcher("/view/viewer.jsp");
			//Event 페이지 맨 처음에 보여질 화면 => EventList
			if(incJsp.equals("CommentHistoryNovel")) {
				dispatcher = request.getRequestDispatcher("/view/template.jsp");
			}
			dispatcher.forward(request, response);
		
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
