package mypage_p;

import java.util.ArrayList;

import dao_p.MemberDAO;
import dto_p.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MyPageService;

public class MyPageModify implements MyPageService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDTO mdto = new MemberDAO().memberDetail(Integer.parseInt(request.getParameter("m_no"))); 
		
		request.setAttribute("memberData", mdto);
		
	}

}
