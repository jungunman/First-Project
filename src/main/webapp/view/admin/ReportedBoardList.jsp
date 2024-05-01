<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../components/adminNav.jsp"/>

<h1>신고 받은 게시판 리스트</h1>
<table border="1" class="unCssTable">
	<tbody>
		<tr align="center">
			<td>신고 번호</td>
			<td>신고한 멤버 아이디</td>
			<td>신고 받은 게시판 번호</td>
			<td>신고 제목</td>
			<td>신고 내용</td>
			<td>신고 일자</td>
			<td>신고 상태</td>
		</tr>
		<c:forEach items="${dto}" var="dto">
		
		<tr align="center">
			<td>${dto.reportNo }</td>
			<td>${dto.mId }</td>
			<td>${dto.reportedBoard }</td>
			<td><a href="/admin/ReportedBoardDetail?no=${dto.reportNo}">${dto.title }</a></td>
			<td>${dto.content }</td>
			<td>${dto.rDateStr }</td>
			<c:choose>
				<c:when test="${dto.process == 0 }">
					<td>처리 대기</td>
				</c:when>
				<c:otherwise>
					<td>답변 완료</td>
				</c:otherwise>
			</c:choose>
		</tr>
		
		</c:forEach>
	</tbody>
</table>

