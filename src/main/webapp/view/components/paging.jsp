<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="paging">
	<c:if test="${paging.currentPage > 10 }"> <a href="${pagingUrl}${paging.prevBlock}"> 이전 </a> </c:if>
	<c:forEach var="page" begin="${ paging.minPage}" end="${paging.maxPage}">		
		<c:choose>
			<c:when test="${paging.currentPage == page }">
				<p class="current">${page}</p>
			</c:when>
			<c:otherwise>
				<a href="${pagingUrl}${page }">${page}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${paging.isNextBtn == true }"> <a href="${pagingUrl}${paging.nextBlock}"> 다음 </a> </c:if>
</div>

