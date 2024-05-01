package controller_p;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.AdminService;
import service_p.ReportService;

import java.io.IOException;


@WebServlet("/report/*")
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReportController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String incfolder = "report/";
		String incJsp = request.getRequestURI().substring((incfolder).length()+1);
		
		request.setAttribute("incUrl", incfolder+incJsp+".jsp");
		System.out.println("report/ : "+incfolder);
		try {
			ReportService ser = (ReportService)Class.forName("report_p."+incJsp).newInstance();
			ser.execute(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/template.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
