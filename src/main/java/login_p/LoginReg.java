package login_p;

import dao_p.MemberDAO;
import dto_p.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.LoginService;

public class LoginReg implements LoginService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("로그인레그 와쓰여");
		
		 MemberDTO dto = new MemberDTO(); 
		 dto.setmId(request.getParameter("m_id"));
		 dto.setmPwd(request.getParameter("m_pwd"));
		 dto.setmNickname(request.getParameter("m_nickname"));
		 MemberDTO res = new MemberDAO().loginChk(dto);
		 
		 
		 if(res==null) {
			 //System.out.println("dff");
			 request.setAttribute("msg", "아이디, 비밀번호 확인해주세요");
			 request.setAttribute("move", "/login/Login");
			 request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
		 }else {
			 request.setAttribute("msg", "로그인 성공");
			 request.setAttribute("move", "/main");
			 request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
			 request.getSession().setAttribute("NovelMember", res); //로그인정보/상태 유지를 위한 세션 생성데스!
		 }
	}
}
