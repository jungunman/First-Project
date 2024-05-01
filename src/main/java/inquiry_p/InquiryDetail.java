package inquiry_p;

import dao_p.InquiryDAO;
import dto_p.InquiryDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.InquiryService;

public class InquiryDetail  implements InquiryService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("인쿼리니~?");
		int no = Integer.parseInt(request.getParameter("iNo"));
		InquiryDTO dto = new InquiryDAO().inquiryDetail(no);
		request.setAttribute("inquiryDetail", dto);
		System.out.println("인쿼리니 도촥ㅆ>?");
	}
}
