package comment_p;

import dao_p.CommentDAO;
import dto_p.NovelDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.CommentService;

public class CommentDeleteNovel implements CommentService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		new CommentDAO().deleteNovel(Integer.parseInt(request.getParameter("c_no")));
		//System.out.println(request.getParameter("nov_no"));
		NovelDTO ndto = new CommentDAO().comebackReturnNovelInfo(Integer.parseInt(request.getParameter("nov_no")));
		
		request.setAttribute("msg", "삭제됐습니다");
		request.setAttribute("move", "/novel/NovelView?novTitle="+ndto.getNovTitle()+"&novMid="+ndto.getmId()+"&novEpi="+ndto.getNovEpi()+"&novNo="+ndto.getNovNo()+"#viewerComment");
		request.setAttribute("incUrl", "components/moveUrl.jsp");
	}

}
