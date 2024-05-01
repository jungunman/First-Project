package notice_p;

import java.io.IOException;

import dao_p.NoticeDAO;
import dto_p.NoticeDTO;
import etc_p.FileUp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NoticeService;

public class NoticeWriteReg implements NoticeService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("공지 쓱게따리!");
		NoticeDTO dto = new NoticeDTO();
		String upFileName;
		try {
			upFileName = new FileUp(request).fileUpload(request.getPart("upFile"));
			dto.setnTitle(request.getParameter("nTitle"));
			dto.setnContent(request.getParameter("nContent"));
			dto.setmImg(upFileName); //파일 이름 뽑기
			
			System.out.println("습하게띠 : "+upFileName);
			new NoticeDAO().noticeWrite(dto);
			
			request.setAttribute("msg", "공지가 작성되었습니다.");
			request.setAttribute("move", "Notice");
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
