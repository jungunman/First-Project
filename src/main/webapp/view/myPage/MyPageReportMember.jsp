<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	window.onload = function(){
		var menuLi = document.querySelector('.myPageMenu > li:nth-of-type(2)')
		console.log(menuLi)
		menuLi.classList.add('active');
	}
</script>

<jsp:include page="MypageNav.jsp"/>

<h2>내가 신고한 유저</h2>
<table border="1" class="unCssTable">
	<tbody>
		<tr>
			<td>신고 대상자</td>
			<td>신고 제목</td>			
			<td>신고 내용</td>			
			<td>신고 일자</td>			
		</tr>
	<c:forEach items="${reportMembers }" var= "dto" >
		<tr>
			<td>${dto.reportedMemberMId }</td>
			<td><a href="/myPage/MyPageReportMemberDetail?no=${dto.reportNo}">${dto.title }</a></td>
			<td>${dto.content }</td>
			<td>${dto.rDateStr }</td>
		</tr> 
	</c:forEach>
	</tbody>
</table>


