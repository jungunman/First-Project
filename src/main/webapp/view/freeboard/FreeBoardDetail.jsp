<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="freeboard__box">
	<div class="board__nav">
		<a class="board__selected" href="/freeboard/FreeBoardList">자유게시판</a> <a
			href="/promotionBoard/PromotionBoardList">홍보게시판</a>
	</div>
	<c:set var="dto" value="${dto}" />
	<div class="freeboard__listWrap">
		<div class="freeboard__listinfo">
			<a href="FreeBoardDetail?no=${dto.no}">${dto.title}</a>
		</div>
		<div class="freeboard__info">
			<div>${ dto.mId } <a href="/report/ReportMemberWriteForm" style="margin:0.5rem; color: #4586d4; font-size: .8rem; font-weight:700;">신고하기</a> &nbsp;|&nbsp;</div>
			<div>${ dto.writeDay} &nbsp;|&nbsp;&nbsp;</div>
			<div>조회수:${ dto.cnt } &nbsp;|&nbsp;&nbsp;</div>
			<div>좋아요:${ dto.like}</div>
		</div>
		<hr>

		<div class="freeboard__content">${dto.content}</div>

		<div class="freeboard__menuba">
			<c:if test="${NovelMember != null }">
				<div class="freeboard__status">
					<a href="FreeBoardLike?no=${dto.no}"> 좋아요 </a>
				</div>
			</c:if>	
			<div class="freeboard__status">
				<a href="FreeBoardList">목록으로 </a>
			</div>
			<c:if test="${NovelMember.mId == dto.mId }">
				<div class="freeboard__status">
					<a href="FreeBoardModifyForm?no=${dto.no}"> 수정 </a>
				</div>
				<div class="freeboard__status">
					<a href="FreeBoardDelete?no=${dto.no}"> 삭제 </a>
				</div>
			</c:if>
		</div>

	</div>


</div>
