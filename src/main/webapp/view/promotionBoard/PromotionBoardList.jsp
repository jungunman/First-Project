<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<div class="promotionBoard">

	<div class="board__nav">
		<a href="/freeboard/FreeBoardList">자유게시판</a>
		<a class="board__selected" href="PromotionBoardList">홍보게시판</a>
	</div>


	<c:forEach items="${mainData}" var="dto"> 
	
	
	<div class="board__box">
		<a href="PromotionBoardDetail?no=${dto.no}">  
			<div class="board__book-info">
				<div class="board__book-img">
					<img src="<c:url value="/images/${dto.nImg }"/> " alt="" />
				</div>
			</div>
			<div class="board__contents">
				<div class="board__wrapper">
					<div class="board__first">
						<p class="board__book-title">${dto.nTitle }</p>
						<p>${dto.writeDayStr }</p>
					</div>
					<div class="board__middle">
						<p>${dto.title }</p>
						<p>${dto.content }</p>
					</div>
				</div>
				<div class="board__last">
					<p class="board__writer">${dto.mNickname} ( ${dto.mId } )</p>
					<p class="board__counter">조회수 : ${dto.cnt }</p>
					<p class="board__counter">좋아요 : ${dto.like }</p>
					
				</div>
			</div>	
		</a>
	</div>
	</c:forEach>
	
	<c:if test="${NovelMember != null }">
		<a href="PromotionBoardSearch?no=${dto.no}" class="board__status">홍보글쓰기</a>
	</c:if>

	<jsp:include page="../components/paging.jsp" />


</div>

	