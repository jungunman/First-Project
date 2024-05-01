<%@page import="org.apache.tomcat.jakartaee.bcel.Const"%>
<%@page import="java.util.function.Function"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="join__big">    
	<form action="JoinReg" method="post">
		<div class="join__top">
		<h1>회원가입</h1>
			<div class="join__chklist">
				<div class="join__write">이름</div>
				<div class="join__write--input"><input type="text" name="m_name" size="15" id="name" placeholder="한글로 입력해주세요." /></div>
			</div>
			<div class="join__chklist">
				<div class="join__write">아이디</div>
				<div class="join__write--input"><input type="text" name="m_id" size="20" id="userid" placeholder="아이디를 입력하세요"/></div>
			</div>
			<div class="join__chklist">
				<div class="join__write">닉네임</div>
				<div class="join__write--input"><input type="text" name="m_nickname" size="30"  id="nickname" placeholder="닉네임을 입력하세요"/></div>
			</div>
			<div class="join__chklist">
				<div class="join__write">비밀번호</div>
				<div class="join__write--input"><input type="password" name="m_pwd" size="20" id="userpw" placeholder="비밀번호를 입력하세요" /></div>
			</div>
			<div class="join__chklist">
				<div class="join__write">비밀번호 확인</div>
				<div class="join__write--input"><input type="password" name="m_pwdChk" id="userpw_chk" placeholder="비밀번호를 한번 더 입력하세요" /></div>
			</div>
			<div class="join__chklist">
				<div class="join__write">주민등록번호</div>
				<div class="join__write--input"><input type="text" name="front_num" min="6" maxlength="6" id="front" placeholder="앞 6자리 입력해주세요."/> ㅡ 
				<input type="text" name="back_num" min="7" maxlength="7" id="back" placeholder="뒤 7자리 입력해주세요."/></div>
			</div>
			<div class="join__chklist">
				<div class="join__write">이메일</div>
				<div class="join__write--input"><input type="text" name="email" size="40"  id="email" placeholder="이메일"/></div>
			</div>
			<div class="join__chklist">
				<div class="join__write">연락처</div>
				<div class="join__write--input"><input type="text" name="m_tel"  id="hp" placeholder=" - 제외하여 입력해주세요."/></div>
			</div>
			<div>
				<div>
				<input type="button" value="메인페이지" onclick="location.href='/main'" class="join_button"/>
				<input type="submit" value="회원가입" class="join_button"/>
				</div>
			</div>
		</div>
	</form>
</div>
