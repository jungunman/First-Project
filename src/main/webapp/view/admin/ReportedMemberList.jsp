<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../components/adminNav.jsp"/>

<h1>신고 받은 유저 리스트</h1>
<table border="1" class="unCssTable">
	<tbody>
		<tr align="center">
			<td>신고 번호</td>
			<td>신고한 멤버 아이디</td>
			<td>신고 받은 멤버 아이디</td>
			<td>신고 제목</td>
			<td>신고 내용</td>
			<td>신고 일자</td>
		</tr>
		<c:forEach items="${repotedMemberList}" var="rml">
		
		<tr align="center">
			<td>${rml.reportNo }</td>
			<td><a href="/admin/MemberDetail?mNo=${ rml.reportMember}"> ${rml.mId }</a></td>
			<td><a href="/admin/MemberDetail?mNo=${ rml.reportedMember}">${rml.reportedMemberMId }</a></td>
			<td><a href="/admin/BoardDetail?no=${ rml.reportNo}">${rml.title }</a></td>
			<td>${rml.content }</td>
			<td>${rml.rDateStr }</td>
		</tr>
		
		</c:forEach>
	</tbody>
</table>

