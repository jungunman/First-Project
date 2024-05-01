<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="MypageNav.jsp"/>

<form action="MyPageModifyReg" method="post" enctype="multipart/form-data">
	<input type="hidden" name="m_no" value="${memberData.mNo }"/>

		  <div class="myPage">
		  	<div class="myPageDetailWrap"> 	
		  		<div class="myPageDetailWrap_profile">
				 	<img alt="" src="/images/${memberData.mProfile }"/>
				 	<input type="file" name="upFile"/>		
				 </div>
		  		<div class="myPageModifyWrap_info">
		  			<div>
				 		<div class="myPageModify_info_title">아이디</div>
				 		<div class="myPageModify_info_content">${memberData.mId }</div>
				 	</div>
				 	<div>
				 		<div class="myPageModify_info_title">비밀번호</div>
			 			<div class="myPageModify_info_content"><input type="password" name="m_pwd"/></div>
			 		</div>
			 		<div>
			 			<div class="myPageModify_info_title">비밀번호 재확인</div>
			 			<div class="myPageModify_info_content"><input type="password" name="m_pwdChk"/></div>
			 		</div>
				 	<div>
			 			<div class="myPageModify_info_title">이름</div>
			 			<div class="myPageModify_info_content">${memberData.mName }</div>
			 		</div>
			 		<div>
			 			<div class="myPageModify_info_title">이메일</div>
			 			<div class="myPageModify_info_content"><input type="text" name="email" value="${memberData.email }"/></div>
			 		</div>
			 		<div>
			 			<div class="myPageModify_info_title">휴대전화</div>
			 			<div class="myPageModify_info_content"><input type="text" name="m_tel" value="${memberData.mTel }"/></div>
			 		</div>
			 		<div>	
			 			<div class="myPageModify_info_title">닉네임</div>
			 			<div class="myPageModify_info_content"><input type="text" name="m_nickname" value="${memberData.mNickname }"/></div>
			 		</div>
			 		<div>
				 		<div><input type="button" value="취소" onclick="location.href='MyPageDetail'" class="myPage_button myPage_Modibutton"/></div>
						<div><input type="submit" value="수정" class="myPage_button"/></div>
			 		</div>
			 		
		  		</div>
		  		
		  	</div>
		  </div>
</form>

