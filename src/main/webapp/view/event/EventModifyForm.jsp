<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function fileDelete() {
		if(confirm("파일을 삭제하시겠습니까?")){
			var eventFileModify = document.querySelector("#eventFileModify");
			eventFileModify.action = "EventFileDelete";
			eventFileModify.submit();
		} // 삭제 - true 면 사진을 지우기 -> 다시 업로드할 수 있도록 삭제 안보이기
	}
</script>

<form action="EventModifyReg" method="post" enctype="multipart/form-data" id="eventFileModify">  
<input type="hidden" name="e_no" value="${eData.eveNo }"/>
<div class="eventWrite">
 	<div class="event_title">이벤트
 		<span class="event_subTitle">수정</span>
 	</div>
 	<div class="eventWriteWrap">
 		<div class="eventWrite_titleWrap">
			<div class="eventWrite_title">제목</div> 	
			<div><input type="text" name="e_title" value="${eData.eveTitle }" class="eventContent_width"/></div>
 		</div>
 		<div class="eventWrite_dayWrap">
 			<div>
 				<div class="eventWrite_title">시작일</div> 	
				<div class="eventWrite_day_content">
					<input type="date" name="e_startDate" value="${eData.eveStartDate }"/>
				</div>
 			</div>
			<div>
 				<div class="eventWrite_title">마감일</div> 	
				<div class="eventWrite_day_content">
					<input type="date" name="e_endDate" value="${eData.eveEndDate }" min="2015-01-01"/>
				</div>
 			</div>			
 		</div>
 		<div class="eventWrite_imgWrap">
 			<div class="eventWrite_title">첨부파일</div> 			
	 			<c:choose>
					<c:when test="${eData.eveImg !=null}">
						<div><img alt="" src="/images/${eData.eveImg}" class="noticeImg"></div> 
						<div><input type="button" value="삭제" onclick="fileDelete()" class="event_imgButton"/></div> 				
						<input type="hidden" name="upFile" value="${eData.eveImg}"/>
					</c:when>
					<c:otherwise>
						<div><input type="file" name="upFile"/></div>
					</c:otherwise>
				</c:choose>
 			
 		</div>
 		<div class="eventWrite_content">
 			<div class="eventWrite_title">내용</div> 	
 			<div><textarea name="e_content" cols="50" rows="15" class="eventContent_width">${eData.eveContent }</textarea></div>
 		</div>
 		<div class="eventWrite_bottom">
 			<div><input type="button" value="목록보기" onclick="location.href='EventList'" class="event_button"></div> 
 			<div><input type="submit" value="수정" class="event_button"/></div>
 		</div>
 	</div>
</div> 
 </form>
