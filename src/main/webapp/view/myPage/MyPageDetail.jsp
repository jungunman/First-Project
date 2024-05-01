<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	window.onload = function(){
		var menuLi = document.querySelector('.myPageMenu > li:nth-of-type(1)')
		console.log(menuLi)
		menuLi.classList.add('active');
	}
</script>
<jsp:include page="MypageNav.jsp"/>


	 <div class="myPage">
	 	<div class="myPageDetailWrap"> 	
		 	<div class="myPageDetailWrap_infoWrap">
		 		<div class="myPageDetailWrap_profile">
			 	<img alt="" src="/images/${memberData.mProfile }"/>
			 	</div>
			 	<div class="myPageDetailWrap_info">
			 		<div>
			 			<div>아이디</div>
			 			<div>${memberData.mId }</div>
			 		</div>
			 		<div>
			 			<div>이름</div>
			 			<div>${memberData.mName }</div>
			 		</div>
			 		<div>
			 			<div>이메일</div>
			 			<div>${memberData.email }</div>
			 		</div>
			 		<div>
			 			<div>닉네임</div>
			 			<div>${memberData.mNickname }</div>
			 		</div>
			 		<div>
			 			<div>가입일</div>
			 			<div>${memberData.regDateStr }</div>
			 		</div>
			 		
			 		<div>
		 			<input type="button" value="수정" onclick="location.href='MyPageModify?m_no=${memberData.mNo}'" class="myPage_button"/>
					<input type="button" value="탈퇴" onclick="location.href='MyPageDelete?m_no=${memberData.mNo}'" class="myPage_button"/>
		 			</div>
			 	</div>
		 	</div>
		</div>
	 </div>


