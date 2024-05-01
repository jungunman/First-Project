<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<div class="join__big">
	<form action="InquiryGodModifyReg" method="post" enctype="multipart/form-data">
		<input type="hidden" name="iNo" value="${IModifGodyData.iNo }"/>
		 <div class="event_title">문의사항
	 		<span class="event_subTitle">수정</span>
	 	</div>
	 	<div class="eventListWrap">	
	 		<c:if test='${NovelMember.mId == "GodNovel" }'>			
				<div class="eventWrite_titleWrap">
					<div class="inquiry__write">제목</div>
					<div class="inquiry__write--input"><input type="text" name="iTitle" value="${IModifGodyData.iTitle }" readonly="readonly"/></div>
				</div>
				<div class="eventModify_imgWrap">
		 			<div class="inquiry__write">첨부파일</div> 	
					<div class="eventFile">
						<div><img alt="" src="/images/${IModifGodyData.iImg}" class="noticeImg"></div> 
						<div><input type="file" name="upFile" value="${IModifGodyData.iImg}"/></div> 		
					</div>
				</div>
				<div class="eventWrite_content">
					<div class="inquiry__write">내용</div>
					<div class="inquiry__write--input"><textarea name="iAnswer" readonly="readonly">${IModifGodyData.iContent }</textarea></div>
				</div>	
				<div class="eventWrite_titleWrap">
					<div class="inquiry__write">답변제목</div>
					<div class="inquiry__write--input"><input type="text" name="iTitle" value="${IModifGodyData.aTitle }" /></div>
				</div>
				<div class="eventWrite_content">
					<div class="inquiry__write">답변내용</div>
					<div class="inquiry__write--input"><textarea name="iAnswer">${IModifGodyData.iAnswer }</textarea></div>
				</div>
				<div class="eventWrite_bottom">
		 			<div><input type="button" value="취소" onclick="location.href='InquiryDetail?iNo=${IModifGodyData.iNo }'" class="event_button"></div> 
		 			<div><input type="submit" value="수정" class="event_button"/></div>
		 		</div>
	 		</c:if>			
		</div>
	</form>
</div>	