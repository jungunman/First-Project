package novel_p;

import dao_p.NovelDAO;
import dto_p.NovelDTO;
import etc_p.FileUp;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NovelService;

public class EpiDelete implements NovelService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int novEpi = Integer.parseInt(request.getParameter("novEpi"));
		String novTitle = request.getParameter("novTitle");
		String novMid = request.getParameter("novMid");
		NovelDTO dto = new NovelDAO().novelView(novTitle, novMid, novEpi);
		
		int novNo = dto.getNovNo();
		/*
		 * String novTitle = dto.getNovTitle(); 
		 * String novMid = dto.getmId();
		 */
		
		
		if(dto.getNovImg()!=null) {
			new FileUp(request).fileDelete(dto.getNovImg());
		}
		
		new NovelDAO().epiDelete(novNo);
		
		
		request.setAttribute("msg", "삭제되었습니다");
		request.setAttribute("move","NovelDetail?novTitle="+novTitle+"&novMid="+novMid);
		request.setAttribute("incUrl", "components/moveUrl.jsp");
	}

}
