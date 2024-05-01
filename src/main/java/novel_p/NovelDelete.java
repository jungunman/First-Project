package novel_p;

import dao_p.NovelDAO;
import etc_p.FileUp;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NovelService;

public class NovelDelete implements NovelService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String novTitle = request.getParameter("novTitle");
		String novMid = request.getParameter("novMid");
		String novImg = request.getParameter("novImg");
		

		if(!novImg.equals("cover_holder.jpg")) {					
			new FileUp(request).fileDelete(novImg);
		}
		
		new NovelDAO().novelDelete(novTitle, novMid);
		
		
		request.setAttribute("msg", "삭제되었습니다");
		request.setAttribute("move","NovelList");
		request.setAttribute("incUrl", "components/moveUrl.jsp");
	}

}
