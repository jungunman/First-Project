package admin_p;

import java.util.ArrayList;

import dao_p.MemberDAO;
import dto_p.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.AdminService;
import service_p.JoinService;
import service_p.MyPageService;

public class MemberDetail implements AdminService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		MemberDTO dto = new MemberDTO();
		dto.setmNo(Integer.parseInt(request.getParameter("mNo")));
		MemberDTO mdto = new MemberDAO().memberDetail(dto.getmNo());
		
		request.setAttribute("memberData", mdto);
		
	}
}
