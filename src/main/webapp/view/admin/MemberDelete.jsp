<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="MyPageDeleteReg">
	<input type="hidden" name="m_no" value="${memberData.mNo }"/>
	
	<div class="myPage">
	 	<div class="event_title">회원탈퇴</div>
	 	
	 	<div class="myPageDeleteWrap">
	 		<div class="myPageDelte_info">	
	 			<div><input type="text" placeholder="${memberData.mId}" disabled="disabled"></div>
				<div><input type="password" name="m_pwd" placeholder="비밀번호 입력"></div>		
	 		</div>
		 	
			<div class="myPageDelete_button">
				<div><input type="button" value="취소" onclick="location.href='MyPageDetail'" class="myPage_button"></div>
				<div><input type="submit" value="회원탈퇴" class="myPage_button"></div>
			</div>
	 	</div>	 	
 	</div>			
</form>