<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<h2>멤버 신고 내용 상세 보기</h2>
<table border="1" class="unCssTable">
	<tr>
		<td>신고번호</td>
		<td colspan="3">${detail.reportNo }</td>
	</tr>
	<tr>
		<td>신고한 유저</td>
		<td>${detail.mId }</td>
		<td>신고 받은 유저</td>
		<td>${detail.reportedMemberMId }</td>
	</tr>
	<tr>
		<td>신고 일자</td>
		<td colspan="3">${detail.rDateStr }</td>
	</tr>
	<tr>
		<td>신고 제목</td>
		<td colspan="3">${detail.title }</td>
	</tr>
	<tr>
		<td>신고 내용</td>
		<td colspan="3">${detail.content }</td>
	</tr>
	
	<c:choose>
		<c:when test="${detail.answer == null}">
			<tr>
				<td>아직 답변을 달지 않았습니다.</td>
			</tr>
		</c:when>
		<c:otherwise>
			<tr>
				<td>답변</td>
				<td>${detail.answer}</td>
			</tr>
		</c:otherwise>
	</c:choose>
	
	<tr>
		<td colspan="4" align="right">
		<c:choose>
		<c:when test="${detail.answer == null}">
			<a href="/admin/ReportMemberAnswerForm?no=${detail.reportNo }">답변하기</a>			
		</c:when>
		<c:otherwise>			
			<a href="/admin/ReportMemberAnswerModifyForm?no=${detail.reportNo }">답변 수정</a>
		</c:otherwise>
	</c:choose>
			<a href="javascript:history.back();">뒤로</a>	
		</td>
	</tr>
</table>