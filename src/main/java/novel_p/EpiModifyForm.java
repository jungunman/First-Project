package novel_p;

import dao_p.NovelDAO;
import dto_p.NovelDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NovelService;

public class EpiModifyForm implements NovelService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {		
		int novEpi = Integer.parseInt(request.getParameter("novEpi"));
		String novTitle = request.getParameter("novTitle");
		String novMid = request.getParameter("novMid");

		NovelDTO dto = new NovelDAO().novelView(novTitle, novMid, novEpi);		
		String mNick = new NovelDAO().getNick(dto.getmId());
		request.setAttribute("mNick", mNick);

		request.setAttribute("dto", dto);
//		System.out.println("에피소드 모디폼 와써" + dto);

	}

}
