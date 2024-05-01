package inquiry_p;

import dao_p.InquiryDAO;
import dto_p.InquiryDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.InquiryService;

public class InquiryDelete implements InquiryService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("하잉~삭제녀석임");
		int no = Integer.parseInt(request.getParameter("iNo"));
		new InquiryDAO().inquiryDelete(no);
		System.out.println("바잇~삭제얌");
		
		request.setAttribute("msg", "삭제되었습니다.");
		request.setAttribute("move", "Inquiry");
		request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
	}
}
