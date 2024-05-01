package event_p;

import java.util.ArrayList;

import dao_p.EventDAO;
import dto_p.EventDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.EventService;

public class EventList implements EventService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<EventDTO> edto = new EventDAO().list();
		request.setAttribute("eData", edto);
	}

}
