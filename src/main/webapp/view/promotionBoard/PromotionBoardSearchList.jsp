<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="promotionBoard">

	<div class="board__nav">
		<a href="/freeboard/FreeBoardList">자유게시판</a> <a
			class="board__selected" href="PromotionBoardList">홍보게시판</a>
	</div>
</div>

	<div class="board__search--title">
		<div class="board__search--title">작품제목</div>
		<div class="board__search--title">작가명</div>
	</div>
	
	
	<div class="board__search--title">
	<c:forEach items="${mainData}" var="dto" >
		<div>
			<a	href="PromotionBoardWriteForm?title=${dto.nTitle}&artist=${dto.mId}">${dto.nTitle }</a>
		</div>
		<div>${dto.mId}</div>
	</c:forEach>
	</div>
