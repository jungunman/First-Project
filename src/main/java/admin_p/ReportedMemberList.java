package admin_p;

import java.util.ArrayList;

import dao_p.AdminDAO;
import dto_p.ReportedMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.AdminService;

public class ReportedMemberList implements AdminService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<ReportedMemberDTO> dtos = new AdminDAO().getReportedMemberList();
		request.setAttribute("repotedMemberList", dtos);
		
	}
}
