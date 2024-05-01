<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<jsp:include page="MypageNav.jsp"/>

<h2>내가 신고한 유저</h2>
<table border="1">
	<tbody>
		<tr>
			<td>신고 번호</td>
			<td>신고 대상자</td>
			<td>신고 제목</td>
			<td>신고 내용</td>
			<td>신고 일자</td>
			<td>신고 상태</td>	
		</tr>
		<tr>
			<td>${dto.reportNo}</td>
			<td>${dto.reportedMemberMId}</td>
			<td>${dto.title }</td>
			<td>${dto.content }</td>
			<td>${dto.rDateStr }</td>
			<c:choose>
				<c:when test="${ dto.process == 0 }">
					<td>처리중</td>
				</c:when>
				<c:otherwise>
					<td>답변완료</td>
				</c:otherwise>
			</c:choose>
		</tr>
	</tbody>
	
	<table border="1">
		<tbody>
			<c:choose>
				<c:when test="${ dto.answer == null }">
					<tr>
						<td>신고 처리중입니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td>제목</td>
						<td>${dto.title} 에 대한 답변</td>
					</tr>
					<tr>
						<td>답변</td>
						<td>${dto.answer}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	
	
	
</table>


