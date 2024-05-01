<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="freeboard__box">
<div class="board__nav">
	<a class="board__selected" href="/freeboard/FreeBoardList">자유게시판</a> <a
		href="/promotionBoard/PromotionBoardList">홍보게시판</a>
</div>

	<c:forEach items="${mainData}" var="dto">
		<div class="freeboard__listWrap">

			<div class="freeboard__listinfo">
			
					<a href="FreeBoardDetail?no=${dto.no}">${dto.title}</a>
			

			</div>
			<div class="freeboard__info">
				<div>  ${ dto.mId } &nbsp;| &nbsp;</div> 
				<div>  ${ dto.writeDay}&nbsp; |&nbsp; </div> 
				<div> &nbsp; 조회수:${ dto.cnt }&nbsp; |&nbsp; </div>
				<div> 좋아요:${dto.like}</div>
			</div>

		</div>
			<%-- <div>${dto.like }</div> --%>
	</c:forEach>
</div>

<c:if test="${NovelMember != null }">

	<a href="FreeBoardWriteForm?no=${dto.no}" class="freeboard__status">글쓰기</a>
	
</c:if>



<jsp:include page="../components/paging.jsp" />





