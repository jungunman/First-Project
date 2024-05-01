<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <style>
	form[action="FindId"]{
		width:600px;
	}
</style> -->
<form action="FindId" method="post">
	<div class="join__big"> 
		<div class="join__top">
			<h1>아이디 찾기</h1>
			<div class="join__chklist">
				<div class="join__write">이름</div>
				<div class="join__write--input"><input type="text" name="mName" size="15" id="name" placeholder="정확한 이름을 입력하세요." /></div>
			</div>
			<div class="join__chklist">
				<div class="join__write">생년월일</div>
				<div class="join__write--input"><input type="text" name="birth" min="8" maxlength="8" id="birth" placeholder="생년월일 8자리 숫자만 정확하게 입력해 주세요."/></div>
			</div>
			<div class="join__chklist">
				<div class="join__write">이메일</div>
				<div class="join__write--input"><input type="text" name="email" size="40"  id="email" placeholder="100자 미만으로 입력해 주세요."/></div>
			</div>
			<div>
				<div class="join_move"><input type="submit" value="찾기" class="join_button"/></div>
			</div>
		</div>
	</div>
</form>


<form action="FindPw" method="post">
	<div class="join__big"> 
		<div class="join__top">
			<h1>비밀번호 찾기</h1>
			<div class="join__chklist">
				<div class="join__write">아이디</div>
				<div class="join__write--input"><input type="text" name="mId" placeholder="아이디를 입력해 주세요." maxlength="20"/></div>
			</div>
			<div class="join__chklist">
				<div class="join__write">이름</div>
				<div class="join__write--input"><input type="text" name="mName" placeholder="정확한 이름을 입력하세요." maxlength="20"/></div>
			</div>
			<div class="join__chklist">
				<div class="join__write">이메일</div>
				<div class="join__write--input"><input type="text" name="email" size="40"  id="email" placeholder="100자 미만으로 입력해 주세요."/></div>
			</div>
			<div class="join_move">
				<div><input type="submit" value="찾기" class="join_button"/></div>
			</div>
		</div>
	</div>
</form>

