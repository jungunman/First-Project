package novel_p;

import java.util.ArrayList;

import dao_p.CommentDAO;
import dao_p.NovelDAO;
import dto_p.CommentDTO;
import dto_p.MemberDTO;
import dto_p.NovelDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NovelService;

public class NovelView implements NovelService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String novTitle = request.getParameter("novTitle");
		String novMid = request.getParameter("novMid");
	

		int novEpi = Integer.parseInt(request.getParameter("novEpi"));
		int novNo = new NovelDAO().novelView(novTitle, novMid, novEpi).getNovNo();

		int cntUp = new NovelDAO().novelView(novTitle, novMid, novEpi).getNovCnt()+1;
		
		MemberDTO user = (MemberDTO) request.getSession().getAttribute("NovelMember");
		
		// 작성자 or 관리자는 조회수 카운트 안하기
		if(user==null) {
			new NovelDAO().viewCnt(cntUp, novNo);
			
		}else{

			if(!user.getmId().equals(novMid) && !user.getmId().equals("GodNovel")){
				new NovelDAO().viewCnt(cntUp, novNo);
			}
		}
		
		NovelDTO dto = new NovelDAO().novelView(novTitle, novMid, novEpi);
		
		ArrayList<NovelDTO> data = new NovelDAO().novelDetail(novTitle, novMid);

		ArrayList<CommentDTO> cdto = new CommentDAO().listNovel(novNo);

		
		
		request.setAttribute("cData", cdto);
		request.setAttribute("now", novEpi);
		request.setAttribute("dto", dto);
		request.setAttribute("mainData", data);

			
	}

}
