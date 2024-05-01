<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<div class="join__big">   
 	<div class="event_title">1:1 고객센터
 		<span class="inquiry_subTitle active"><a href="InquiryWrite">문의하기 |</a></span>
 		<span class="inquiry_subTitle"><a href="Inquiry">문의내역</a></span>
 	</div>
 <div class="eventListWrap">
	<c:if test='${NovelMember.mId == "GodNovel" }'>
		<form action="InquiryGodWriteReg" method="post" enctype="multipart/form-data">
			<input type="hidden" name="iNo" value="${inquiryGodDetail.iNo }" /> 
			<input type="hidden" name="iCategory" value="${inquiryGodDetail.iCategory }" /> 
				<div class="eventWrite_titleWrap">
					<div class="inquiry__write">제목</div>
					<div class="inquiry__write--input"><input type="text" name="iTitle" value="${inquiryGodDetail.iTitle }" readonly="readonly"/></div>
				</div>
				<div class="eventWrite_titleWrap">
					<div class="inquiry__write">내용</div>
					<div class="inquiry__write--input"><input type="text" name="iContent" value="${inquiryGodDetail.iContentBr }" readonly="readonly"/></div>
				</div>
						<div class="eventModify_imgWrap">
				 			<div class="inquiry__write">첨부파일</div> 	
				 			<div class="eventFile">
								<div><img alt="" src="/images/${inquiryGodDetail.iImg}" class="noticeImg"></div> 	
				 			</div>
				 		</div>			 
				<div class="eventWrite_titleWrap">
					<div class="inquiry__write">답변제목</div>
					<div class="inquiry__write--input"><input type="text" name="aTitle" placeholder="답변제목을 입력하세요."/></div>
				</div>	
				<div class="eventWrite_content">
					<div class="inquiry__write">답변내용</div>
					<div class="inquiry__write--input"><textarea name="iAnswer"></textarea></div>
				</div>		
				 <div class="eventWrite_bottom">
			 		<div><input type="button" value="뒤로가기" onclick="location.href='InquiryDetail?iNo=${param.iNo }'" class="join_button"></div> 
			 		<div><input type="button" value="목록보기" onclick="location.href='Inquiry'" class="join_button"></div> 
			 		<div><input type="submit" value="작성" class="join_button"/></div>
				</div>
			</form>
		</c:if>
	</div> 
</div>