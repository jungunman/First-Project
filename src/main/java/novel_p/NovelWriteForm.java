package novel_p;

import java.util.ArrayList;

import dao_p.NovelDAO;
import dto_p.NovelDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NovelService;

public class NovelWriteForm implements NovelService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String novTitle = request.getParameter("novTitle");
		String novMid = request.getParameter("novMid");
		String mNick = new NovelDAO().getNick(novMid);
		request.setAttribute("mNick", mNick);
		
		if(novTitle!=null) {			
			ArrayList<NovelDTO> data = new NovelDAO().novelDetail(novTitle, novMid);
			request.setAttribute("mainData", data);
			request.setAttribute("cover", data.get(data.size()-1).getNovImg());			
		}		
//		System.out.println("쓰기폼 와써~");
	}

}
