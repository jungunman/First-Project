package controller_p;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.BoardService;
import service_p.NovelService;

import java.io.IOException;

/**
 * Servlet implementation class BoardController
 */

@WebServlet("/freeboard/*")
public class FreeBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FreeBoardController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		System.out.println(request.getRequestURI());
//		System.out.println(request.getContextPath());
		System.out.println("컨트롤러 동작 ");  //진입확인
		String incfolder = "freeboard/"; 
		String incJsp = request.getRequestURI().substring((request.getContextPath()+"/"+incfolder).length());
		
		System.out.println(incJsp);
		//파싱확인
		System.out.println(incfolder+incJsp);
		request.setAttribute("incUrl", incfolder+incJsp+".jsp");
		
		try {
			BoardService ser = (BoardService)Class.forName("freeboard_p."+incJsp).newInstance();
			
			ser.execute(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/template.jsp");
			
			dispatcher.forward(request, response);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
