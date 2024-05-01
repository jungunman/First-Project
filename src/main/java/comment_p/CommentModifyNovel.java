package comment_p;

import java.util.ArrayList;

import dao_p.CommentDAO;
import dto_p.CommentDTO;
import dto_p.NovelDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.CommentService;

public class CommentModifyNovel implements CommentService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		CommentDTO cdto = new CommentDTO();
		cdto.setNovNo(Integer.parseInt(request.getParameter("nov_no")));
		System.out.println(request.getParameter("c_content"));
		NovelDTO ndto = new CommentDAO().comebackReturnNovelInfo(cdto.getNovNo());
		
		ArrayList<CommentDTO> cData = new CommentDAO().listNovel(cdto.getNovNo());
		request.setAttribute("cData", cData);
		if(request.getParameter("c_content")!=null) {
			cdto.setcNoNovel(Integer.parseInt(request.getParameter("c_no")));
			cdto.setcContentNovel(request.getParameter("c_content"));
			
			new CommentDAO().modifyNovel(cdto);
			
			request.setAttribute("msg", "댓글이 수정되었습니다");
			request.setAttribute("move", "/novel/NovelView?novTitle="+ndto.getNovTitle()+"&novMid="+ndto.getmId()+"&novEpi="+ndto.getNovEpi()+"&novNo="+ndto.getNovNo()+"#viewerComment");
			request.setAttribute("incUrl", "components/moveUrl.jsp");
		}else {
			request.setAttribute("msg", "댓글을 작성해주세요");
			request.setAttribute("move", "/novel/NovelView?novTitle="+ndto.getNovTitle()+"&novMid="+ndto.getmId()+"&novEpi="+ndto.getNovEpi()+"&novNo="+ndto.getNovNo()+"#viewerComment");
			request.setAttribute("incUrl", "components/moveUrl.jsp");
		}
		
		
	}

}
