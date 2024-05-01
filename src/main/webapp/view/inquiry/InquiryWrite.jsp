<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<div class="join__big">   
 	<div class="event_title">1:1 고객센터
 		<span class="inquiry_subTitle active"><a href="InquiryWrite">문의하기 |</a></span>
 		<span class="inquiry_subTitle"><a href="Inquiry">문의내역</a></span>
 	</div>
 	<div class="eventListWrap">
		<c:if test='${NovelMember.mId != null && NovelMember.mId != "GodNovel" }'>
			<form action="InquiryWriteReg" method="post" enctype="multipart/form-data">
				<div class="eventWrite_titleWrap">
					<div class="inquiry__write">제목 (필수)</div>
					<div class="inquiry__write--input"><input type="text" name="iTitle"/></div>
				</div>		
				<div class="eventWrite_content">
					<div class="inquiry__write">내용 (필수)</div>
					<div class="inquiry__write--input"><textarea name="iContent"></textarea></div>		
				</div>						
				<div class="inquiryWrite_titleWrap">
					<div class="inquiry__write">이미지 첨부</div>
					<div><input type="file" name="upFile"/></div>
				</div>		
				 <div class="eventWrite_bottom">
			 		<div><input type="button" value="목록보기" onclick="location.href='Inquiry'" class="join_button"></div> 
			 		<div><input type="submit" value="작성" class="join_button"/></div>
			 	</div>
			</form>
		</c:if>
	</div> 
</div>