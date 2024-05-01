package controller_p;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main_p.MainUtills;

import java.io.IOException;

/**
 * Servlet implementation class MainController
 */

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * index에 접근하면 그냥 여기에 리센드 다이렉트 보내주고 template로 forward 가야함.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("메인");
		String incfolder = "main/";
		String incJsp = "main.jsp";
		
		request.setAttribute("incUrl", incfolder+incJsp);
		
		
		MainUtills utill = new MainUtills(request, response);
		utill.getWeekTopTen();
		utill.getRecentNovel();
		utill.getNovelByGenre(request.getParameter("genre"));
		utill.getPromotionalBoard();
		utill.getFreeBoard();
		utill.getNoticeBoard();
		utill.getRecentNovel();
		utill.getEventBoard();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/template.jsp");
	
		
		dispatcher.forward(request, response);
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
