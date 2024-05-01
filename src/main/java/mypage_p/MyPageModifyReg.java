package mypage_p;

import java.io.IOException;

import dao_p.EventDAO;
import dao_p.MemberDAO;
import dto_p.MemberDTO;
import etc_p.FileUp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MyPageService;

public class MyPageModifyReg implements MyPageService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {		
		try {	
			MemberDTO mdto = new MemberDTO();	
				
				String upFileName = request.getPart("upFile").getSubmittedFileName();
				mdto.setmNo(Integer.parseInt(request.getParameter("m_no")));
				mdto.setmPwd(request.getParameter("m_pwd"));				
				mdto.setEmail(request.getParameter("email"));
				mdto.setmTel(request.getParameter("m_tel"));
				mdto.setmProfile(upFileName);
				mdto.setmNickname(request.getParameter("m_nickname"));
				
				//System.out.println(request.getParameter("m_pwdChk"));
				
				String truePwd = request.getParameter("m_pwd");
				String checkPwd = request.getParameter("m_pwdChk");
				
				System.out.println(truePwd);
				System.out.println(checkPwd);
				
				//pwd, pwdchk 둘다 입력한 경우 + 두개가 같아야 정보 수정 가능
				if(!truePwd.equals("")&&!checkPwd.equals("")&&truePwd.equals(checkPwd)){
					//프사를 선택하지 않을 경우 -> 기본 프사
					if(upFileName.equals("")) { 
						//사진을 변경하지 않음
						new MemberDAO().profileNoChange(Integer.parseInt(request.getParameter("m_no")));
					}
					//프사를 선택할 경우 
					else{
						//파일에 업로드
						upFileName = new FileUp(request).fileUpload(request.getPart("upFile"));
						//db 프로필 사진저장 변경			
						new MemberDAO().profileModify(mdto);
						
						//수정프사가 기본프사와 같지 않을 경우 기존의 올라가 있던 프사를 삭제하기
						/*if(!upFileName.equals("user.jpg")&&!upFileName.equals(mdto.getmProfile())){
							//업로드한 파일을 삭제
							new FileUp(request).fileDelete(request.getParameter("upFile"));;							
						}*/			
					}
					//다른 정보는 수정
					new MemberDAO().memberModify(mdto); //입력값을 넣어주기
					//세션값도 변경하여 반영
					MemberDTO sessionDTO = (MemberDTO)request.getSession().getAttribute("NovelMember");
					MemberDTO res = new MemberDAO().memberDetail(sessionDTO.getmNo());
					request.getSession();
					request.getSession().setAttribute("NovelMember", res);
					request.setAttribute("msg", "수정되었습니다");
					request.setAttribute("move","MyPageDetail");
					request.setAttribute("incUrl", "components/moveUrl.jsp");				
				}
				
				else{
					request.setAttribute("msg", "비밀번호를 다시 입력해주세요");
					request.setAttribute("move","MyPageModify?m_no="+mdto.getmNo());
					request.setAttribute("incUrl", "components/moveUrl.jsp");
				}
				
				mdto.setmProfile(request.getParameter(upFileName));
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
