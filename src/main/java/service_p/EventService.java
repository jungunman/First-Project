package service_p;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface EventService {
	void execute(HttpServletRequest request, HttpServletResponse response);
}
