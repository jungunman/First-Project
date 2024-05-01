<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   


<form action="NoticeModifyReg" method="post" enctype="multipart/form-data"> 
<input type="hidden" name="nNo" value="${NModifyData.nNo }"/>
<div class="eventWrite">
 	<div class="event_title">공지사항
 	<span class="event_subTitle">수정</span>
 	</div>
 	<div class="eventWriteWrap">
 		<div class="eventWrite_titleWrap">
			<div class="eventWrite_title">제목</div> 	
			<div><input type="text" name="nTitle" value="${NModifyData.nTitle }" class="eventContent_width"/></div>
 		</div>

 		<div class="eventWrite_imgWrap">
 			<div class="eventWrite_title">첨부파일</div> 
 			<div class="noticeImg"><img alt="" src="/images/${NModifyData.mImg }" class="noticeImg"></div> 
 			<div class="eventFile"><input type="file" name="upFile"/></div>
 		</div>
 		<div class="eventWrite_content">
 			<div class="eventWrite_title">내용</div> 	
 			<div><textarea name="nContent" cols="50" rows="20" class="eventContent_width">${NModifyData.nContent }</textarea></div>
 		</div>
 		<div class="eventWrite_bottom">
 			<div><input type="button" value="취소" onclick="location.href='NoticeDetail?nNo=${NModifyData.nNo }'" class="event_button"></div> 
 			<div><input type="submit" value="수정" class="event_button"/></div>
 		</div>
 	</div>
</div> 
</form>
