package event_p;

import dao_p.EventDAO;
import dto_p.EventDTO;
import etc_p.FileUp;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.EventService;

public class EventDelete implements EventService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		EventDTO edto = new EventDAO().eDetail(Integer.parseInt(request.getParameter("e_no")));
		
		//System.out.println(edto.getEveImg());
		if(edto.getEveImg()!=null) {
			new FileUp(request).fileDelete(edto.getEveImg());
		}
				
		new EventDAO().eDelete(Integer.parseInt(request.getParameter("e_no")));
		request.setAttribute("msg", "삭제되었습니다");
		request.setAttribute("move","EventList");
		request.setAttribute("incUrl", "components/moveUrl.jsp");
		
		//System.out.println("삭제실행");		
	}

}
