<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	window.onload = function(){
		var menuLi = document.querySelector('.myPageMenu > li:nth-of-type(3)')
		console.log(menuLi)
		menuLi.classList.add('active');
	}
</script>
<jsp:include page="../../myPage/MypageNav.jsp"/>

<h1>내 댓글 히스토리</h1>
<table border="1" class="unCssTable">
	<tbody>
		<tr align="center">
			<td colspan="2">소설</td>
			<td>회차</td>
			<td>내 댓글</td>
			<td>작성일</td>
		</tr>
		<c:forEach  items="${cData }" var="cdto">
			<c:if test="${cdto.mIdNovel==NovelMember.mId }">
		<tr align="center">
			<td><img src="/images/${cdto.novImg }" class="comment_img"></td>
			<td><a href="/novel/NovelDetail?novTitle=${cdto.novTitle}&novMid=${cdto.novMid}">${cdto.novTitle }</a></td>
			<td><a href="/novel/NovelView?novTitle=${cdto.novTitle}&novMid=${cdto.novMid}&novEpi=${cdto.novEpi}&novNo=${cdto.novNo}">${cdto.novEpi }</a></a></td>
			<td>${cdto.cContentNovel }</td>
			<td>${cdto.cRegdateNovel }</td>
		</tr>
		</c:if>
		</c:forEach>
	</tbody>
</table>
