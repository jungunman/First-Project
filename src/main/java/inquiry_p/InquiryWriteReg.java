package inquiry_p;

import java.io.IOException;

import dao_p.InquiryDAO;
import dto_p.InquiryDTO;
import dto_p.MemberDTO;
import etc_p.FileUp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.InquiryService;

public class InquiryWriteReg implements InquiryService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDTO loginInfo = (MemberDTO)request.getSession().getAttribute("NovelMember");
		InquiryDTO dto = new InquiryDTO();
		try {
			String upFileName = new FileUp(request).fileUpload(request.getPart("upFile"));
			//dto.setiNo(Integer.parseInt(request.getParameter("iNo")));
			dto.setmId(loginInfo.getmId());
			dto.setiTitle(request.getParameter("iTitle"));
			dto.setiContent(request.getParameter("iContent"));
			dto.setiImg(upFileName); //파일 이름 뽑기
			
			new InquiryDAO().inquiryWrite(dto);
			
			request.setAttribute("IWriteData", dto);
			request.setAttribute("msg", "문의를 하였습니다.");
			request.setAttribute("move", "Inquiry");
			request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
