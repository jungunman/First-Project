<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<h1>회원가입정보 리스트</h1>
<form action="#" method="post">
	<table border="">
		<tr>
			<td>NO</td>
			<td>ID</td>
			<td>PW</td>
			<td>닉네임</td>
			<td>이름</td>
			<td>성별</td>
			<td>이메일</td>
			<td>연락처</td>
			<td>가입일</td>
		</tr>
		<c:forEach items="${joinData }" var="dto">
			<tr>
				<td>${dto.mNo }</td>
				<td>${dto.mId }</td>
				<td>${dto.mPwd }</td>
				<td>${dto.mNickname }</td>
				<td>${dto.mName }</td>
				<td>${dto.gender }</td>
				<td>${dto.email }</td>
				<td>${dto.mTel }</td>
				<td>${dto.regDate }</td>
			</tr>
		</c:forEach>
	</table>
</form>
