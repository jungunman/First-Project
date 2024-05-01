package report_p;

import dao_p.BoardDAO;
import dao_p.NovelDAO;
import dto_p.BoardDTO;
import dto_p.NovelDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.ReportService;

public class ReportNovelWriteForm implements ReportService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		NovelDTO dto = new NovelDAO().novelReport(Integer.parseInt(request.getParameter("target")));
		request.setAttribute("dto", dto);
	}
}
