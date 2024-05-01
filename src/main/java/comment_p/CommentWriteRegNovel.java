package comment_p;

import java.util.ArrayList;

import dao_p.CommentDAO;
import dao_p.EventDAO;
import dto_p.CommentDTO;
import dto_p.MemberDTO;
import dto_p.NovelDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.CommentService;

public class CommentWriteRegNovel implements CommentService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		CommentDTO cdto = new CommentDTO();
		MemberDTO login = (MemberDTO)request.getSession().getAttribute("NovelMember");
		cdto.setNovNo(Integer.parseInt(request.getParameter("nov_no")));
		
		NovelDTO ndto = new CommentDAO().comebackReturnNovelInfo(cdto.getNovNo());
				
		//list  뿌리기-------------- 
		if(!request.getParameter("c_content").equals("")) {		
			cdto.setmIdNovel(request.getParameter("m_id"));
			cdto.setcContentNovel(request.getParameter("c_content"));
			//cdto.setcRegdateNovelStr(request.getParameter("c_regdate"));
			
			new CommentDAO().writeNovel(cdto); //댓글 작성 값 넣어주기
			request.setAttribute("msg", "댓글이 작성되었습니다");
			request.setAttribute("move", "/novel/NovelView?novTitle="+ndto.getNovTitle()+"&novMid="+ndto.getmId()+"&novEpi="+ndto.getNovEpi()+"&novNo="+ndto.getNovNo()+"#viewerComment");
			request.setAttribute("incUrl", "components/moveUrl.jsp");
		}else {
			request.setAttribute("msg", "댓글을 작성해주세요");
			request.setAttribute("move", "/novel/NovelView?novTitle="+ndto.getNovTitle()+"&novMid="+ndto.getmId()+"&novEpi="+ndto.getNovEpi()+"&novNo="+ndto.getNovNo()+"#viewerComment");
			request.setAttribute("incUrl", "components/moveUrl.jsp");
		}
		
	}

}
