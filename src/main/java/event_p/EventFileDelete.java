package event_p;

import dao_p.EventDAO;
import dto_p.EventDTO;
import etc_p.FileUp;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.EventService;

public class EventFileDelete implements EventService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		EventDTO edto = new EventDTO();
		
		//1. 파일에서 삭제하기
		//System.out.println(request.getParameter("upFile"));
		new FileUp(request).fileDelete(request.getParameter("upFile"));		
		
		edto.setEveNo(Integer.parseInt(request.getParameter("e_no")));
		edto.setEveTitle(request.getParameter("e_title"));
		edto.setEveStartDateStr(request.getParameter("e_startDate"));
		edto.setEveContent(request.getParameter("e_content"));
		if(!request.getParameter("e_endDate").equals("")){
			edto.setEveEndDateStr(request.getParameter("e_endDate"));
		}
		
		//2. DB의 e_img 이름을 null으로 변경
		new EventDAO().fileDelete(edto.getEveNo());
		
		//3. 값을 반납하고 원래 수정폼으로 이동
		request.setAttribute("eData", edto);
		request.setAttribute("msg", "사진이 삭제되었습니다");
		request.setAttribute("move","EventModifyForm?e_no="+edto.getEveNo());
		request.setAttribute("incUrl", "components/moveUrl.jsp");
		
	}

}
