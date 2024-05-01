package join_p;

import java.util.ArrayList;

import dao_p.MemberDAO;
import dto_p.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.JoinService;

public class JoinList implements JoinService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("JoinList 나아따");
		
		ArrayList<MemberDTO> listData = new MemberDAO().list(); //가져아 저장해써
		request.setAttribute("joinData", listData);
		
		//System.out.println("JoinList 나라고!");
		
	}
}
