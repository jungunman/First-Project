<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  


<div class="eventWrite">
	<div class="event_title">공지사항</div>
	
	<div class="eventListWrap">
		<c:forEach items="${noticeData }" var="dto">		
			<div class="noticeListWarp_listWrap">
				<a href="NoticeDetail?nNo=${dto.nNo }">	
					<div class="noticeList_info">
						<div class="noticeList_title">${dto.nTitle }</div>
						<div class="noticeList_date">${dto.nTime }</div>
					</div>		
				</a>
			</div>
		</c:forEach>
		<c:if test="${NovelMember.mId=='GodNovel'}">
			<input type="button" value="글쓰기" onclick="location.href='NoticeWrite'" class="event_button">
		</c:if>	
	</div>	
</div>

<jsp:include page="../components/paging.jsp" />