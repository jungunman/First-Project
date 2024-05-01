package logout_p;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.LogoutService;

public class Logout implements LogoutService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		
		request.setAttribute("msg", "로그아웃 되었습니다.");
		request.setAttribute("move", "/main");
		request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
		
	}
}
