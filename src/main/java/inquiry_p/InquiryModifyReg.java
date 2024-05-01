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

public class InquiryModifyReg  implements InquiryService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDTO loginInfo = (MemberDTO)request.getSession().getAttribute("NovelMember");
		InquiryDTO dto = new InquiryDTO();
		try {
			String upFileName = new FileUp(request).fileUpload(request.getPart("upFile"));
			//System.out.println("noinno " +request.getParameter("iNo"));
			dto.setmId(loginInfo.getmId());
			dto.setiNo(Integer.parseInt(request.getParameter("iNo")));
			dto.setiTitle(request.getParameter("iTitle"));
			dto.setiContent(request.getParameter("iContent"));
			dto.setiAnswer(request.getParameter("iAnswer"));
			dto.setaTitle(request.getParameter("aTitle"));
			dto.setiImg(upFileName); //파일 이름 뽑기
			
			
			new InquiryDAO().inquiryModify(dto);
			
			request.setAttribute("IModifyData", dto);
			request.setAttribute("msg", "수정되었습니다^^");
			request.setAttribute("move", "InquiryDetail?iNo="+dto.getiNo());
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