<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	table{
		height: 100px;
	}
</style>

<script>
function del(e_no) {
	if(confirm("삭제하시겠습니까?")){
		location.href = "EventDelete?e_no="+e_no;
	}
}
</script>
<div class="eventWrite">
	<div class="event_title">이벤트</div>
	
	<div class="eventDetailWrap">
		<div class="eventDetail_info">
			<div>
				<div>${eData.eveTitle}</div>
				<div class="eventList_date">${eData.eveStartDate}~${eData.eveEndDate}</div>
			</div>			
		</div>
		<c:if test="${eData.eveImg!=null}">
		<div class="event_eventImg"><img alt="" src="/images/${eData.eveImg}"></div>
		</c:if>
		<div class="eventDetail_notice">
			<div>
				<p>유의사항</p>
				<pre>${eData.eveContent}</pre>
			</div>
		</div>
		<div class="eventWrite_bottom">	
			<div><input type="button" value="목록보기" onclick="location.href='EventList'" class="event_button"></div> 	
			<c:if test="${NovelMember.mId=='GodNovel'}">		
				<div><input type="button" value="수정" onclick="location.href='EventModifyForm?e_no=${eData.eveNo}'" class="event_modifyButton event_button"></div> 
				<div><input type="button" value="삭제" onclick="del(${eData.eveNo})" class="event_button"></div> 		
			</c:if>
		</div>
	</div>
</div>

