package login_p;

import dao_p.MemberDAO;
import dto_p.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.LoginService;

public class FindPw implements LoginService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDTO dto = new MemberDTO();
		System.out.println(dto);
		dto.setmId(request.getParameter("mId"));
		dto.setmName(request.getParameter("mName"));
		dto.setEmail(request.getParameter("email"));
		MemberDTO res = new MemberDAO().pwFind(dto);
			
		 if(res==null) {
			 request.setAttribute("msg", "다시 입력해주세요.");
			 request.setAttribute("move", "Find");
			 request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
		 }else {
			request.setAttribute("msg", "비밀번호 : "+res.getmPwd());
			request.setAttribute("move", "Login");
			request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
		 }
	}
}
