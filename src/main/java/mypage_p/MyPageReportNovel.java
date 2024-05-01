package mypage_p;

import java.util.ArrayList;

import dao_p.MyPageDAO;
import dto_p.MemberDTO;
import dto_p.ReportedBoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MyPageService;

public class MyPageReportNovel implements MyPageService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<ReportedBoardDTO> dto= new MyPageDAO().getMyReportNovel((MemberDTO)request.getSession().getAttribute("NovelMember"));
	
		request.setAttribute("reportBoard", dto);
		
	}
	
}
