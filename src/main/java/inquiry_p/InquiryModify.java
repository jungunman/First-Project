package inquiry_p;

import dao_p.InquiryDAO;
import dto_p.InquiryDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.InquiryService;

public class InquiryModify  implements InquiryService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("야야 오냐?모디파이씨?");
		int no = Integer.parseInt(request.getParameter("iNo"));
		System.out.println(no);
		InquiryDTO dto = new InquiryDAO().inquiryDetail(no);
		request.setAttribute("IModifyData", dto);
		
		
	}
}