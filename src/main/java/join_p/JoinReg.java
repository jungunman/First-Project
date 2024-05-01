package join_p;

import dao_p.MemberDAO;
import dto_p.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.JoinService;

public class JoinReg implements JoinService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("조인레그 나와따");
		
		MemberDTO dto = new MemberDTO();
		dto.setmId(request.getParameter("m_id"));
		dto.setmPwd(request.getParameter("m_pwd"));
		dto.setmName(request.getParameter("m_name"));
		dto.setFrontNum(request.getParameter("front_num"));
		dto.setBackNum(request.getParameter("back_num"));
		dto.setEmail(request.getParameter("email"));
		dto.setmTel(request.getParameter("m_tel"));
		dto.setmNickname(request.getParameter("m_nickname"));
		
		new MemberDAO().memberWrite(dto);
		MemberDTO res = new MemberDAO().joinChk(dto);
		
		if(dto != null) {
			request.setAttribute("msg", "회원가입이 완료되었습니다"); //회원가입 성공메세지를 띄워주세요!
			request.setAttribute("move", "/login/Login"); //로그인 창으로 이동하세요!
			request.setAttribute("incUrl", "/view/components/moveUrl.jsp"); //가따오슝! 날라가가쓔!
		}if(res == null) {
			request.setAttribute("msg", "입력 정보를 확인해주세요."); //회원가입 실패메세지를 띄워주세요!
			request.setAttribute("move", "/Join"); //회원가입 창으로 이동하세요!
			request.setAttribute("incUrl", "/view/components/moveUrl.jsp"); 
		}
	}
}
