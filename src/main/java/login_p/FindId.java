package login_p;

import dao_p.MemberDAO;
import dto_p.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.LoginService;

public class FindId implements LoginService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDTO dto = new MemberDTO();
		dto.setmName(request.getParameter("mName"));
		dto.setEmail(request.getParameter("email"));
		dto.setGeneration(request.getParameter("birth").substring(0,2));
		dto.setFrontNum(request.getParameter("birth").substring(2,8));
		//dto.setFrontNum(request.getParameter("birth"));
		System.out.println("아이디냥");
		System.out.println(request.getParameter("birth").substring(0,2)+request.getParameter("birth").substring(2,8));
		MemberDTO res = new MemberDAO().idFind(dto);
		
		 if(res==null) {
			 request.setAttribute("msg", "다시 입력해주세요.");
			 request.setAttribute("move", "Find");
			 request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
		 }else {
			request.setAttribute("msg", "아이디 : "+res.getmId());
			request.setAttribute("move", "Login");
			request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
		 }
	}
}
