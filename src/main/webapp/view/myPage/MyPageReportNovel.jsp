<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	window.onload = function(){
		var menuLi = document.querySelector('.myPageMenu > li:nth-of-type(4)')
		console.log(menuLi)
		menuLi.classList.add('active');
	}
</script>

<jsp:include page="MypageNav.jsp"/>

<h2>내가 신고한 유저</h2>
<table border="1" class="unCssTable">
	<tbody>
		<tr>
			<td>소설 번호</td>
			<td>소설 제목</td>			
			<td>소설 소제목</td>			
			<td>소설 회차</td>			
			<td>작가</td>			
			<td>연재 일자</td>		
			<td>신고 제목</td>		
			<td>신고 내용</td>		
			<td>신고 일자</td>		
			<td>신고 상태</td>		
		</tr>
	<c:forEach items="${reportBoard }" var= "dto" >
		<tr>
			<td>${dto.reportedBoard}</td>
			<td>${dto.boardTitle}</td>
			<td>${dto.boardSubtitle}</td>
			<td>${dto.novEpi}</td>
			<td>${dto.boardWriter}</td>
			<td>${dto.boardRegDateStr}</td>
			<td><a href="/myPage/MyPageReportNovelDetail?no=${dto.reportNo}">${dto.title}</a></td>
			<td>${dto.content}</td>
			<td>${dto.rDateStr}</td>
			<c:choose>
				<c:when test="${ dto.process == 0 }">
					<td>처리중</td>
				</c:when>
				<c:otherwise>
					<td>답변완료</td>
				</c:otherwise>
			</c:choose>
		</tr> 
	</c:forEach>
	</tbody>
</table>


