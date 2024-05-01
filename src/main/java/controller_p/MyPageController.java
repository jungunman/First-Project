package controller_p;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.EventService;
import service_p.MyPageService;

import java.io.IOException;

@WebServlet("/myPage/*")
@MultipartConfig()
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyPageController() {
        super();
   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String incfolder = "myPage/";
		String incJsp = request.getRequestURI().substring((incfolder).length()+1);
		request.setAttribute("incUrl", incfolder+incJsp+".jsp");
		
		try {
			MyPageService mpser = (MyPageService)Class.forName("mypage_p."+incJsp).newInstance();
			mpser.execute(request, response); // 해당 파일 별 implements 인스턴스 한 것들 실행 가능
			
			RequestDispatcher dispatcher = null;
			dispatcher = request.getRequestDispatcher("/view/template.jsp");
			dispatcher.forward(request, response);
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
