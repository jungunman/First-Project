package notice_p;

import dao_p.NoticeDAO;
import dto_p.NoticeDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NoticeService;

public class NoticeDetail implements NoticeService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("응 ~ 노티스디테일~");
		int no = Integer.parseInt(request.getParameter("nNo"));
		NoticeDTO dto = new NoticeDAO().detail(no);
		System.out.println("응 ~ 노티스디테일~1");
		request.setAttribute("noticeDetail", dto);
		
		System.out.println("응 ~ 노티스디테일~오냐?");
	}
}
