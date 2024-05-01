<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../components/adminNav.jsp"/>

<h1>유저 목록</h1>
<table border="1" class="unCssTable">
	<tbody>
		<tr align="center">
			<td>멤버 번호</td>
			<td>멤버 아이디</td>
			<td>멤버 닉네임</td>
			<td>멤버 이름</td>
			<td>멤버 프로필사진</td>
			<td>멤버 성별</td>
			<td>멤버 이메일</td>
			<td>멤버 전화번호</td>
			<td>멤버 가입일</td>
		</tr>
		<c:forEach items="${MemberList}" var="ml">
		
		<tr align="center">
			<td>${ml.mNo }</td>
			<td><a href="/admin/MemberDetail?mNo=${ml.mNo}">${ml.mId }</a></td>
			<td>${ml.mNickname }</td>
			<td>${ml.mName }</td>
			<td>${ml.mProfile }</td>
			<c:choose>
				<c:when test="${ml.gender == 0}">
					<td>남자</td>
				</c:when>
				<c:otherwise>
					<td>여자</td>				
				</c:otherwise>
			</c:choose>
			<td>${ml.email }</td>
			<td>${ml.mTel }</td>
			<td>${ml.regDateStr }</td>
		</tr>
		
		</c:forEach>
	</tbody>
</table>

