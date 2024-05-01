package inquiry_p;

import dao_p.InquiryDAO;
import dto_p.InquiryDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.InquiryService;

public class InquiryWrite implements InquiryService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getParameter("iNo") != null) {			
			int no = Integer.parseInt(request.getParameter("iNo"));
			InquiryDTO dto = new InquiryDAO().inquiryDetail(no);
			request.setAttribute("inquiryDetail", dto);
		}
		
		
	}
}
