package controller_p;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NovelService;

import java.io.IOException;



/**
 * Servlet implementation class NovelController
 */
@WebServlet("/novel/*")
@MultipartConfig()
public class NovelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String incfolder = "novel/";
		String incJsp = request.getRequestURI().substring((request.getContextPath()+"/"+incfolder).length());	
		
		request.setAttribute("incUrl", incfolder+incJsp+".jsp");
		
		try {
			NovelService ser = (NovelService)Class.forName("novel_p."+incJsp).newInstance();
			
			ser.execute(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/template.jsp");
			
			if(incJsp.equals("NovelView")) {
				dispatcher = request.getRequestDispatcher("/view/viewer.jsp");
			}
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
