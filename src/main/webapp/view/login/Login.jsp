<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="LoginReg" method="post">
	<div class="join__big">    
		<div class="loogin__top">
			<h1>로그인</h1>
			<div class="join__chklist">
				<input class="login__write--input" type="text" placeholder="아이디" name="m_id"/>
			</div>
			<div class="join__chklist">
				<input class="login__write--input" type="password" placeholder="비밀번호" name="m_pwd"/>
			</div>
			<div>
				<input type="submit" value="로그인"  class="login_button"/>
			</div>
			<div>
				<a class="login__link" href="/join/JoinBefore">회원가입</a>
				<a class="login__link" href="Find">아이디/비밀번호 찾기</a>
			</div>
		</div>
	</div>
</form>