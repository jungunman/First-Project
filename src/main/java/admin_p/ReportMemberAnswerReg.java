package admin_p;

import dao_p.AdminDAO;
import dto_p.MemberDTO;
import dto_p.ReportedMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.AdminService;

public class ReportMemberAnswerReg implements AdminService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		String answer = request.getParameter("answer");
		
		ReportedMemberDTO dto = new ReportedMemberDTO();
		dto.setReportNo(no);
		dto.setAnswer(answer);
		
		int res = new AdminDAO().getAnswerReportMember(dto);
		
		if(res == 0) {
			request.setAttribute("move", "/admin/ReportMemberAnswerForm?no="+no);
			request.setAttribute("msg", "답변 달기 실패");
		}else {
			request.setAttribute("move", "/admin/BoardDetail?no="+no);
			request.setAttribute("msg", "답변 성공");			
		}
		request.setAttribute("incUrl", "components/moveUrl.jsp");
	}
}
