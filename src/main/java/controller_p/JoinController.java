package controller_p;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.JoinService;

import java.io.IOException;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/join/*")
@MultipartConfig
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String incFolder = "join/"; //폴더
		String incJsp = request.getRequestURI().substring(incFolder.length()+1); //파일명
		
		request.setAttribute("incUrl", incFolder+incJsp+".jsp"); //join폴더에 있는 jsp파일
		
		System.out.println(incJsp);
	
		try {
			JoinService js = (JoinService)Class.forName("join_p."+incJsp).newInstance(); //어떤 패키지에 있는지 꼭!적어
			js.execute(request, response);
	
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/template.jsp"); //불러올 페이지 view/template.jsp(바구니)
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
