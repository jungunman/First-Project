package admin_p;

import java.util.ArrayList;

import dao_p.AdminDAO;
import dto_p.ReportedBoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.AdminService;

public class ReportedBoardList implements AdminService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<ReportedBoardDTO> dto = new AdminDAO().getReportedBoardList();
		request.setAttribute("dto", dto);
	}
	
}
