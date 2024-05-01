package admin_p;

import dao_p.AdminDAO;
import dto_p.ReportedMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.AdminService;

public class ReportMemberAnswerForm implements AdminService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int no = Integer.parseInt(request.getParameter("no"));
		ReportedMemberDTO dto = new AdminDAO().getReportedMemberDetail(no);
		request.setAttribute("dto", dto);
	}
	
}
