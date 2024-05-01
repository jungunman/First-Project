package mypage_p;

import dao_p.MemberDAO;
import dto_p.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MyPageService;

public class MyPageDelete implements MyPageService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDTO mdto = new MemberDAO().memberDetail(Integer.parseInt(request.getParameter("m_no"))); 
		
		request.setAttribute("memberData", mdto);
	}

}
