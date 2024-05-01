<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="promotionBoard">

	<div class="board__nav">
		<a href="/freeboard/FreeBoardList">자유게시판</a> <a
			class="board__selected" href="PromotionBoardList">홍보게시판</a>
	</div>

	<div class="board__title">${dto.title}</div>

	<hr />

	<div class="board__detail--nov">
		<a href="/novel/NovelDetail?novTitle=${dto.nTitle}&novMid=${dto.novAuthor}" class="board__detail--nov">
		<div class="board__book-img">
			<img src="<c:url value="/images/${dto.nImg }"/> " alt="" />
		</div>
		
		<div class="board__info">
			
				<p class="board__book-title">${dto.nTitle }</p>
				<p>${dto.novAuthor}</p>
				<p>${dto.writeDayStr }</p>
				<p>${dto.serialDate}</p>
				<p>${dto.novIntro}</p>
				<p>조회수:${dto.novCnt} 좋아요:${dto.novLike}</p>
			
		</div>
		</a>
	</div>
	<hr />
	<div>
		<p>${dto.content}</p>
	</div>
</div>


<div class="board__underbar">
	<c:if test="${NovelMember != null}">
		<a href="PromotionBoardLike?no=${dto.no}" class="board__status">좋아요</a>
	</c:if>
	<c:if test="${NovelMember.mId == dto.mId}">
		<a href="PromotionBoardModifyForm?no=${dto.no}" class="board__status">수정</a>
		<a href="PromotionBoardDelete?no=${dto.no}" class="board__status">삭제</a>
	</c:if>
		<a href="PromotionBoardList" class="board__status">목록으로</a>
</div>
