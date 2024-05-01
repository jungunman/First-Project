package notice_p;

import dao_p.NoticeDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NoticeService;

public class NoticeDelete implements NoticeService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("공지 사쿠제데수!");
		int no = Integer.parseInt(request.getParameter("nNo"));
		new NoticeDAO().noticeDelete(no);
		
		request.setAttribute("msg", "삭제되었습니다.");
		request.setAttribute("move", "Notice");
		request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
	}
}
