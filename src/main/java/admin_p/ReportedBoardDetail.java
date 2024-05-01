package admin_p;

import dao_p.AdminDAO;
import dto_p.ReportedBoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.AdminService;

public class ReportedBoardDetail implements AdminService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		int no = Integer.parseInt(request.getParameter("no"));
		ReportedBoardDTO dto = new AdminDAO().getReportedBoardDetail(no);
		
		request.setAttribute("dto", dto);
		
		
	}
	
}
