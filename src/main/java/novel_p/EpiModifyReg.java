package novel_p;

import dao_p.NovelDAO;
import dto_p.NovelDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NovelService;

public class EpiModifyReg implements NovelService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String novTitle = request.getParameter("novTitle");
		String novMid = request.getParameter("novMid");
		int novEpi = Integer.parseInt(request.getParameter("novEpi"));
		int novNo = Integer.parseInt(request.getParameter("novNo"));
		
		NovelDTO dto = new NovelDTO();
		dto.setNovNo(novNo);
		dto.setNovSubtitle(request.getParameter("novSubtitle"));
		dto.setNovCont(request.getParameter("novCont"));
		
		new NovelDAO().epiModify(dto);
		
//		System.out.println("에피모디reg 왔음" + novNo);
//		System.out.println(request.getParameter("novSubtitle"));
//		System.out.println(request.getParameter("novCont"));
		
		request.setAttribute("msg", "수정되었습니다");
		request.setAttribute("move","NovelView?novTitle="+novTitle+"&novMid="+novMid+"&novEpi="+novEpi+"&novNo="+novNo);
		request.setAttribute("incUrl", "components/moveUrl.jsp");

	}

}
