package admin_p;

import dao_p.AdminDAO;
import dao_p.MemberDAO;
import dto_p.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.AdminService;
import service_p.MyPageService;

public class MemberDelete implements AdminService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int res = new AdminDAO().memberDelete(Integer.parseInt(request.getParameter("m_no")));
		
		if(res == 0) {
			request.setAttribute("msg", "멤버 정지 실패");
			request.setAttribute("move", "/admin/MemberList");
		}else {
			request.setAttribute("msg", "멤버 정지 성공");
			request.setAttribute("move", "/admin/MemberList");			
		}
		request.setAttribute("incUrl", "components/moveUrl.jsp");
	}

}
