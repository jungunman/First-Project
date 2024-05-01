<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>신고 게시판</h2>
<table border="1" class="unCssTable">
	<tr>
		<td>신고 번호</td>
		<td>신고 멤버</td>
		<td>신고 제목</td>
		<td>신고 내용</td>
		<td>신고 일자</td>
		<td>신고 상태</td>
		<td>신고 당한 게시판 번호</td>
		<td>게시판 제목</td>
		<td>게시판 내용</td>
		<td>게시판 일자</td>
		<td>게시판 작성자</td>
	</tr>
	<tr>
		<td>${dto.reportNo }</td>
		<td>${dto.mId }</td>
		<td>${dto.title }</td>
		<td>${dto.content }</td>
		<td>${dto.rDateStr }</td>
		<td>${dto.process }</td>
		<td>${dto.reportedBoard }</td>
		<td>${dto.boardTitle }</td>
		<td>${dto.boardContent }</td>
		<td>${dto.boardWriter }</td>
		<td>${dto.boardRegDateStr }</td>
	</tr>
</table>