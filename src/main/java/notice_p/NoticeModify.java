package notice_p;

import dao_p.NoticeDAO;
import dto_p.NoticeDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NoticeService;

public class NoticeModify implements NoticeService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("너티스양?");
		int no = Integer.parseInt(request.getParameter("nNo"));
		NoticeDTO dto = new NoticeDAO().detail(no);
		request.setAttribute("NModifyData", dto);
		
	}
}
