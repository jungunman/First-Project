package mypage_p;

import dao_p.MyPageDAO;
import dto_p.MemberDTO;
import dto_p.ReportedBoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MyPageService;

public class MyPageReportBoardDetail implements MyPageService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int myReportNo = Integer.parseInt(request.getParameter("no"));
		MemberDTO my = (MemberDTO)request.getSession().getAttribute("NovelMember");
		ReportedBoardDTO dto = new MyPageDAO().getBoardDetail(myReportNo, my);
		request.setAttribute("dto", dto);
	}
}
