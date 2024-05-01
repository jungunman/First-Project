package mypage_p;

import dao_p.MemberDAO;
import dto_p.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MyPageService;

public class MyPageProfileModify implements MyPageService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		MemberDTO mdto = new MemberDTO();
		
		mdto.setmNo(Integer.parseInt(request.getParameter("m_no")));
		mdto.setmPwd(request.getParameter("m_pwd"));
		mdto.setEmail(request.getParameter("email"));
		mdto.setmTel(request.getParameter("m_tel"));
		mdto.setmNickname(request.getParameter("m_nickname"));
		
		//new MemberDAO().profileModify(mdto.getmNo());
		
		request.setAttribute("memberData", mdto);
		request.setAttribute("move", "MyPageModify?m_no="+mdto.getmNo());
		request.setAttribute("incUrl", "components/moveUrl.jsp");
		
	}

}
