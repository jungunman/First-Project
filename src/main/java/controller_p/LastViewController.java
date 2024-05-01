package controller_p;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.LastViewSevice;

import java.io.IOException;

/**
 * Servlet implementation class LastViewController
 */
@WebServlet("/lastview/*")
public class LastViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LastViewController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("컨트롤러 동작 ");  //진입확인
		String incfolder = "lastview/"; 
		String incJsp = request.getRequestURI().substring((request.getContextPath()+"/"+incfolder).length());
		
//		System.out.println(incJsp);
		//파싱확인
		System.out.println(incfolder+incJsp);
		request.setAttribute("incUrl", incfolder+incJsp+".jsp");
		
		try {
			LastViewSevice ser = (LastViewSevice)Class.forName("lastview_p."+incJsp).newInstance();
			
			ser.execute(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/template.jsp");
			
			dispatcher.forward(request, response);
			
			
		} catch (Exception e) {
			// TODO: handle exception
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
