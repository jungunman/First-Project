package novel_p;

import java.util.ArrayList;

import dao_p.NovelDAO;
import dto_p.NovelDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NovelService;

public class NovelList implements NovelService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String novMenu = request.getParameter("novMenu");
		
		ArrayList<NovelDTO> data = new NovelDAO().novelList(novMenu); 
		request.setAttribute("mainData", data);
		
//		System.out.println("NovelList.execute() 왔따리 : " + data );
	}

}
