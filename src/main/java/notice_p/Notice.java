package notice_p;

import java.util.ArrayList;

import dao_p.NoticeDAO;
import dao_p.PageDAO;
import dto_p.NoticeDTO;
import etc_p.Paging;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NoticeService;

public class Notice implements NoticeService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("노티스리스트 나야나~");
		
		
		Paging page = new Paging(request, new PageDAO().getTotalNoticeCnt(),20);
		
		ArrayList<NoticeDTO> listData = new NoticeDAO().list(page);
		request.setAttribute("pagingUrl", "/notice/Notice?page=");
		request.setAttribute("paging", page);
		request.setAttribute("noticeData", listData);
	
		
	}
}
