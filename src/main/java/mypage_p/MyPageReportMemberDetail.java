package mypage_p;

import dao_p.MyPageDAO;
import dto_p.MemberDTO;
import dto_p.ReportedMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MyPageService;

public class MyPageReportMemberDetail  implements MyPageService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDTO dto = (MemberDTO)request.getSession().getAttribute("NovelMember");
		int myReportNo = Integer.parseInt(request.getParameter("no"));
		ReportedMemberDTO res = new MyPageDAO().getMemberDetail(myReportNo, dto);
		
		request.setAttribute("dto", res);
		
	}
}
