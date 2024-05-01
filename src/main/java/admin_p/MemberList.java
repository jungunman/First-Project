package admin_p;

import java.util.ArrayList;

import dao_p.MemberDAO;
import dto_p.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.AdminService;

public class MemberList implements AdminService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<MemberDTO> dtos = new MemberDAO().list();
		
		request.setAttribute("MemberList", dtos);
	}
}
