package event_p;

import java.io.IOException;

import dao_p.EventDAO;
import dto_p.EventDTO;
import etc_p.FileUp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.EventService;

public class EventWriteReg implements EventService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {		
			
			try {
				EventDTO edto = new EventDTO();
				
				String upFileName = request.getPart("upFile").getSubmittedFileName();
				
				
				if(request.getParameter("e_title").equals("")||request.getParameter("e_startDate").equals("")) {
					request.setAttribute("msg", "제목과 시작일은 필수입력사항입니다");
					request.setAttribute("move","EventWriteForm");
					request.setAttribute("incUrl", "components/moveUrl.jsp");
				}else {
					if(!request.getParameter("e_endDate").equals("")){
						edto.setEveEndDateStr(request.getParameter("e_endDate"));
					}else if(upFileName!=null) {
						upFileName = new FileUp(request).fileUpload(request.getPart("upFile"));		
						edto.setEveImg(upFileName); //파일 이름 뽑기
					}else if(!request.getParameter("e_content").equals("")){
						edto.setEveContent(request.getParameter("e_content"));
					}
					edto.setEveTitle(request.getParameter("e_title"));
					edto.setEveStartDateStr(request.getParameter("e_startDate"));
					new EventDAO().eWrite(edto); //입력값을 넣어주기
					
					int e_no = new EventDAO().edtoNo();
					
					// 게시글 작성 제출 시 실행 되는 기능 => 확인 후 값을 가지고 Detail 페이지로 이동
					request.setAttribute("msg", "작성되었습니다");
					request.setAttribute("move","EventDetail?e_no="+e_no);
					request.setAttribute("incUrl", "components/moveUrl.jsp");
				}
			
			} catch (IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
								
	}

}
