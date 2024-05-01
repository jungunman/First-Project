package novel_p;

import java.util.ArrayList;

import dao_p.NovelDAO;
import dto_p.NovelDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NovelService;

public class NovelLike implements NovelService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String novTitle = request.getParameter("novTitle");
		String novMid = request.getParameter("novMid");
		int novNo = Integer.parseInt(request.getParameter("novNo"));
		int novEpi = Integer.parseInt(request.getParameter("novEpi"));
		int likeUp = Integer.parseInt(request.getParameter("novLike")) + 1;
		ArrayList<NovelDTO> data = new NovelDAO().novelDetail(novTitle, novMid);
		int totEpiNo = data.get(0).getNovTotEpi();
		
		
		int viewEq = new NovelDAO().novelView(novTitle, novMid, novEpi).getNovCnt()-1;
		new NovelDAO().viewCnt(viewEq,novNo);
		new NovelDAO().novelLike(likeUp, novTitle, novMid, novEpi);
		
		if(likeUp >=15 && novEpi < totEpiNo) {
			new NovelDAO().novelOpen(novTitle, novMid, novEpi+1);
			
		}
		
		
		
		request.setAttribute("msg", "응원해주셔서 감사합니다!");
		request.setAttribute("move","/novel/NovelView?novTitle="+novTitle+"&novMid="+novMid+"&novEpi="+novEpi+"&novNo="+novNo);
		request.setAttribute("incUrl", "components/moveUrl.jsp");
	}

}
