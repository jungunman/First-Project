<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="eventWrite">
	<div class="event_title">이벤트
		<span class="event_subTitle">이벤트</span>
	</div>
	<div class="eventListWrap">
		<c:forEach items="${eData }" var="edto" varStatus="no">
			<div class="eventListWrap_listWrap">
				<a href="EventDetail?e_no=${edto.eveNo }">	
					<div class="eventList_info">
						<div class="eventList_title">${edto.eveTitle }</div>
						<div class="eventList_date">${ edto.eveStartDate}~${edto.eveEndDate }</div>
					</div>		
					<div class="eventList_status">진행중</div>
				</a>
			</div>
		</c:forEach>
		<c:if test="${NovelMember.mId=='GodNovel'}">
			<input type="button" value="글쓰기" onclick="location.href='EventWriteForm'" class="event_button">
		</c:if>	
	</div>	
</div>
