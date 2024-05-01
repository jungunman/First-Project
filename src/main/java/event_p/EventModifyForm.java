package event_p;

import dao_p.EventDAO;
import dto_p.EventDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.EventService;

public class EventModifyForm implements EventService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		EventDTO edto = new EventDAO().eDetail(Integer.parseInt(request.getParameter("e_no")));
		
		request.setAttribute("eData", edto);
		
	}

}
