package inquiry_p;

import java.util.ArrayList;

import dao_p.InquiryDAO;
import dao_p.PageDAO;
import dto_p.InquiryDTO;
import dto_p.MemberDTO;
import etc_p.Paging;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.InquiryService;

public class InquiryProcessingList implements InquiryService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Paging page = new Paging(request, new PageDAO().getTotalInquiryCnt(),20);
		
		MemberDTO dto = (MemberDTO)request.getSession().getAttribute("NovelMember"); //회원정보가 담긴 세션
		ArrayList<InquiryDTO> listGodData = new InquiryDAO().inquiryGodList(dto,page);
		request.setAttribute("pagingUrl", "/inquiry/InquiryProcessingList?page=");
		request.setAttribute("paging", page);
		request.setAttribute("inquiryGodList", listGodData);
	
	}

}
