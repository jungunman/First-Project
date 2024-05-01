package admin_p;

import dao_p.AdminDAO;
import dto_p.ReportedMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.AdminService;

public class BoardDetail implements AdminService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ReportedMemberDTO dto = new AdminDAO().getReportedMemberDetail(Integer.parseInt(request.getParameter("no")));
		request.setAttribute("detail", dto);
		
		
	}
	
}
