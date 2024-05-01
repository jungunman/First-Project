package controller_p;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.EventService;

import java.io.IOException;

@WebServlet("/event/*")
@MultipartConfig()
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;      

    public EventController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String incfolder = "event/";
		String incJsp = request.getRequestURI().substring((incfolder).length()+1);
		
		//System.out.println(request.getParameter(incJsp)); //Event 목록, 상세 등 이름 뽑기 ex)EventList ..
		
		request.setAttribute("incUrl", incfolder+incJsp+".jsp"); //url 명 ex)EventList.jsp .. 로 뿌리기
			
		try {
			EventService eser = (EventService)Class.forName("event_p."+incJsp).newInstance();
			eser.execute(request, response); // 해당 파일 별 implements 인스턴스 한 것들 실행 가능
			
			RequestDispatcher dispatcher = null;
			dispatcher = request.getRequestDispatcher("/view/template.jsp");
			//Event 페이지 맨 처음에 보여질 화면 => EventList
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
