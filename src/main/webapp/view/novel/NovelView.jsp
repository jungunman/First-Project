<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function goLogin(){
		alert("로그인이 필요한 서비스입니다.")
		location.href="/login/Login"
	}
</script>
<section class="viewer">
	<div class="viewerTop">
		<div class="goBack">
			<a href="<c:url value="/novel/NovelDetail?novTitle=${dto.novTitle }&novMid=${dto.mId }" />">
				<img src="/images/back_light.svg">
			</a>
		</div>
		<div class="viewerTitle">
			<b>${dto.novTitle }</b>
			<h2>${dto.novSubtitle }</h2>
			<%-- <c:if test="${NovelMember.mId != dto.mId && NovelMember.mId != null }">
				<a href="/report/ReportNovelWriteForm?target=${dto.novNo}">신고하기</a>
			</c:if> --%>
		</div>
		<div id="epiBtn">
			<img src="/images/burger_light.svg">
		</div>
	</div>
	<ul class="epiList">
		<c:forEach items="${mainData }" var="li" varStatus="no" >
		<c:choose>
			<c:when test="${li.novEpi == now }">
			<li class="now">
				<b>${li.novEpi}화 | ${li.novSubtitle }</b><br/>
				<em>${li.novRegdateStr }</em>
			</li>
			</c:when>
			<c:when test="${li.novOpen == 0}">
				<c:choose>
	 				<c:when test="${NovelMember.mId == dto.mId || NovelMember.mId =='GodNovel' }">
	 					<li class="on">		
							<a href="<c:url value="/novel/NovelView?novTitle=${li.novTitle }&novMid=${li.mId }&novEpi=${li.novEpi }"/>">
								<span>${li.novEpi}화 | ${li.novSubtitle }</span><br/>
								<em>${li.novRegdateStr }</em>
							</a>
						</li>					
	 				</c:when>
	 				<c:otherwise>
						<li class="off">
							<span>${li.novEpi}화 | ${li.novSubtitle }</span><br/>
							<em>${li.novRegdateStr } (비공개)</em>
						</li>
	 				</c:otherwise>
	 			</c:choose>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${li.novEpi > 5 && NovelMember.mId == null }">
						<li class="on">		
							<a href="javascript:goLogin();">
								<span>${li.novEpi}화 | ${li.novSubtitle }</span><br/>
								<em>${li.novRegdateStr }</em>
							</a>
						</li>
				 	</c:when>
					<c:otherwise>
						<li class="on">		
							<a href="<c:url value="/novel/NovelView?novTitle=${li.novTitle }&novMid=${li.mId }&novEpi=${li.novEpi }"/>">
								<span>${li.novEpi}화 | ${li.novSubtitle }</span><br/>
								<em>${li.novRegdateStr }</em>
							</a>
						</li>
					</c:otherwise>		
				</c:choose>
			 
			</c:otherwise>
		</c:choose>
		
	
		</c:forEach>
	</ul>
	<div class="viewerMain">
		<div class="textarea">
		
			<b>${dto.novSubtitle }</b>
			<br/>
			<br/>
			<br/>
			${dto.novContBr }
			<br/>
			<br/>
			<br/>
			<p>===================================================================================</p>
			<br/>
			<p>&#8251;  Novel101에 게시된 모든 작품은 저작권법에 의거 보호받고 있습니다.  &#8251; </p>
			<p>&#8251;  저작권자의 승인 없이 작품의 일부, 또는 전부를 복제, 전송, 배포 및 기타의 방법으로 이용할 경우,<br/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;손해배상 청구를 포함해 강력한 민/형사상 처벌대상이 됩니다. (5년 이하의 징역, 5천만원 이하의 벌금부과)  &#8251; </p>
				 
		</div>
	</div>
	<div class="viewerBottom">
		<div class="prev">
		<c:choose>
			<c:when test="${now == 1 }">
				<span>첫화 입니다.</span>
			</c:when>
			<c:otherwise>
				<a href="<c:url value="/novel/NovelView?novTitle=${dto.novTitle }&novMid=${dto.mId }&novEpi=${now-1 }"/>">이전화</a>
			</c:otherwise>
		</c:choose>
		</div>
		
		<div class="btnWrap">
			<div class="viewCnt">
				<span>조회수 : ${dto.novCnt }</span>
			</div>
			
			<div class="novLike">
				<span>좋아요 : ${dto.novLike }</span>
				<!--세션에 아이디가 null이 아니면   -->
				<c:if test="${NovelMember.mId != null && NovelMember.mId != dto.mId && NovelMember.mId != 'GodNovel'}">			
					<button id="likeBtn" onclick="location.href='<c:url value="/novel/NovelLike?novTitle=${dto.novTitle }&novMid=${dto.mId }&novEpi=${now }&novLike=${dto.novLike }&novNo=${dto.novNo }"/>'">&#9829;</button>	
				</c:if>
			</div>
		</div>
		
		<div class="next">
		<c:choose>
			<c:when test="${now == mainData[0].novTotEpi }">
				<span>다음화 없음</span>
			</c:when>
	 		<c:when test="${now > 5 && dto.novLike < 10 }">
	 			<c:choose>
	 				<c:when test="${NovelMember.mId == dto.mId || NovelMember.mId =='GodNovel' }">
	 					<a href="<c:url value="/novel/NovelView?novTitle=${dto.novTitle }&novMid=${dto.mId }&novEpi=${now+1 }"/>">다음화</a>					
	 				</c:when>
	 				<c:otherwise>
						<span>다음화(비공개)</span>
	 				</c:otherwise>
	 			</c:choose>
			</c:when>
			<c:when test="${now >= 5 && NovelMember.mId == null }">
				<a href="javascript:goLogin();">다음화</a>
			</c:when>
			<c:otherwise>
				<a href="<c:url value="/novel/NovelView?novTitle=${dto.novTitle }&novMid=${dto.mId }&novEpi=${now+1 }"/>">다음화</a>					
			</c:otherwise>
		</c:choose>
		</div>
	</div>
	<div id="viewerComment">
		<jsp:include page="../components/comment/CommentListNovel.jsp"/>
	</div>
</section>

