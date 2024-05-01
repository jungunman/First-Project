package mypage_p;

import dao_p.MemberDAO;
import dto_p.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MyPageService;

public class MyPageDeleteReg implements MyPageService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDTO mdto = new MemberDAO().memberDetail(Integer.parseInt(request.getParameter("m_no")));
		
		if(request.getParameter("m_pwd").equals(mdto.getmPwd())) {
			new MemberDAO().memberDelete(Integer.parseInt(request.getParameter("m_no")));	
			request.getSession().invalidate();
			request.setAttribute("msg", "탈퇴성공했습니다");
			request.setAttribute("move","/");
			request.setAttribute("incUrl", "components/moveUrl.jsp");
		}else {
			request.setAttribute("msg", "비밀번호가 틀렸습니다");
			request.setAttribute("move","MyPageDelete?m_no="+mdto.getmNo());
			request.setAttribute("incUrl", "components/moveUrl.jsp");
		}
		
	}

}
