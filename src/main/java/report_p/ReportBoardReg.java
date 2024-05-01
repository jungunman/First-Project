package report_p;

import dao_p.AdminDAO;
import dto_p.MemberDTO;
import dto_p.ReportedBoardDTO;
import dto_p.ReportedMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.ReportService;

public class ReportBoardReg implements ReportService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		   MemberDTO login = (MemberDTO)request.getSession().getAttribute("NovelMember");
		   ReportedBoardDTO dto = new ReportedBoardDTO();
		   
		   dto.setmId(login.getmId());
		   dto.setReportedBoard(Integer.parseInt(request.getParameter("target")));
		   dto.setTitle(request.getParameter("title"));
		   dto.setContent(request.getParameter("content"));
		   
		   int res = new AdminDAO().reportBoard(dto);
		   
		   
		   if(res != 0 ) {
			   request.setAttribute("msg", "신고가 접수되었습니다.");			   
			   request.setAttribute("move", "/main");
		   }else {			   
			   request.setAttribute("msg", "잠시 후 다시 시도해주시길 바랍니다.");			   
			   request.setAttribute("move", "/report/ReportBoardWriteForm?target="+dto.getReportedBoard());			   
		   }
		   
		   request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
		   
		   
	}
	
}
