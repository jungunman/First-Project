<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="NoticeWriteReg" method="post" enctype="multipart/form-data"> 
<div class="eventWrite">
 	<div class="event_title">공지사항
 		<span class="event_subTitle">글쓰기</span>
 	</div>
 	<div class="eventWriteWrap">
 		<div class="eventWrite_titleWrap">
			<div class="eventWrite_title">제목</div> 	
			<div><input type="text" name="nTitle" class="eventContent_width"/></div>
 		</div>

 		<div class="eventWrite_imgWrap">
 			<div class="eventWrite_title">첨부파일</div> 	
 			<div><input type="file" name="upFile" /></div>
 		</div>
 		<div class="eventWrite_content">
 			<div class="eventWrite_title">내용</div> 	
 			<div><textarea name="nContent" cols="50" rows="20" class="eventContent_width"></textarea></div>
 		</div>
 		<div class="eventWrite_bottom">
 			<div><input type="button" value="목록보기" onclick="location.href='Notice'" class="event_button"></div> 
 			<div><input type="submit" value="작성" class="event_button"/></div>
 		</div>
 	</div>
</div> 
</form>
