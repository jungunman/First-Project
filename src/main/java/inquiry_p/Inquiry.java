package inquiry_p;

import java.util.ArrayList;

import dao_p.InquiryDAO;
import dao_p.NoticeDAO;
import dao_p.PageDAO;
import dto_p.InquiryDTO;
import dto_p.MemberDTO;
import dto_p.NoticeDTO;
import etc_p.Paging;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.InquiryService;
import service_p.NoticeService;

public class Inquiry implements InquiryService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("인쿼리 왔다~ㅎ");
		MemberDTO dto = (MemberDTO)request.getSession().getAttribute("NovelMember"); //회원정보가 담긴 세션
		InquiryDTO iDto = new InquiryDTO();
		ArrayList<InquiryDTO> listData = new InquiryDAO().inquiryList(dto);
		/*
		 * for (InquiryDTO noticeDTO : listData) {
		 * System.out.println(noticeDTO.getiTimeStr());
		 * System.out.println(noticeDTO.getiNo());
		 * System.out.println(noticeDTO.getiTitle()); }
		 */
		request.setAttribute("inquiryData", listData);

		
		Paging page = new Paging(request, new PageDAO().getTotalInquiryCnt(),20);
		ArrayList<InquiryDTO> listGodData = new InquiryDAO().inquiryGodList(dto,page);
		request.setAttribute("pagingUrl", "/inquiry/Inquiry?page=");
		request.setAttribute("paging", page);
		request.setAttribute("inquiryGodList", listGodData);
		
		InquiryDTO chDto = new InquiryDAO().changeCate(iDto);
		request.setAttribute("cateChange", chDto);
		
	}
}
