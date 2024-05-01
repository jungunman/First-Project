package mypage_p;

import java.util.ArrayList;

import dao_p.MyPageDAO;
import dto_p.MemberDTO;
import dto_p.ReportedMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MyPageService;

public class MyPageReportMember  implements MyPageService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDTO dto = (MemberDTO)request.getSession().getAttribute("NovelMember");
		ArrayList<ReportedMemberDTO> res = new MyPageDAO().getMyReportMember(dto);
		
		request.setAttribute("reportMembers", res);
		
	}
}
