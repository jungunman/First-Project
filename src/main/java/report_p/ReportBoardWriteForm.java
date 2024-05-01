package report_p;

import dao_p.BoardDAO;
import dto_p.BoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.ReportService;

public class ReportBoardWriteForm implements ReportService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDTO dto =new BoardDAO().detail(Integer.parseInt(request.getParameter("target")));
		request.setAttribute("dto", dto);
	}
}
