
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<script>
	function fileDelete() {
		if(confirm("사진을 삭제하시겠습니까?")){
			var eventFileModify = document.querySelector("#eventFileModify");
			eventFileModify.action = "EventFileDelete";
			eventFileModify.submit();
		} // 삭제 - true 면 사진을 지우기 -> 다시 업로드할 수 있도록 삭제 안보이기
	}
</script>
<section id="novelModify" class="novel novelForm">

	<div class="novelFormTitle">	
		<h2>소설</h2>
		<span>소설정보수정</span>
	</div>
	<form action="NovelModifyReg" method="post" enctype="multipart/form-data">
		<input type="hidden" name="novTitle" value="${mainData[0].novTitle }">			
		<div class="formBox">
			<div class="formRow">
				<div class="labelBox">소설 제목</div>
				<div class="inputBox"><input type="text" name="newTitle" value="${mainData[0].novTitle }" required></div>
			</div>
			<div class="formRow">
				<div class="labelBox">작성자</div>
				<div class="inputBox"><input type="hidden" name="mId" value="${mainData[0].mId }">${mNick }</div>
			</div>
			
			<div class="formRow">
				<div class="labelBox">장르</div>
				<div class="inputBox">
					<select name="novGenre">
						<option value="${mainData[0].novGenre }" selected hidden>${mainData[0].novGenre }</option>
						<option value="판타지">판타지</option>
						<option value="로맨스">로맨스</option>
						<option value="무협">무협</option>
					</select>
				</div>
			</div>
			
			<div class="formRow">
				<div class="labelBox">시놉시스</div>
				<div class="inputBox"><textarea name="novIntro" cols="50" rows="5" >${mainData[0].novIntro }</textarea></div>
			</div>
			
			<div class="formRow">
				<div class="labelBox">표지 이미지</div>
				<div class="inputBox">
				
					<img alt="" src="/images/${mainData[0].novImg}" width="200px" height="280px"> 
					<br/>
					<input type="text" name="curFile" value="${mainData[0].novImg}" readonly="readonly"/>
					<input type="file" name="upFile" />
	
				</div>
			</div>
			
			<div class="formRow">
				<div class="labelBox">연재요일</div>
				<div class="inputBox">
					<c:forTokens var="date" items="일,월,화,수,목,금,토" delims="," varStatus="n">
					<c:choose>				
						<c:when test="${fn:contains(mainData[0].serialDate, date) }">
							<label><input type="checkbox" name="serialDate" value="${date }" checked >${date }</label>
						</c:when>
						<c:otherwise>							
							<label><input type="checkbox" name="serialDate" value="${date }">${date }</label>
						</c:otherwise>
					</c:choose>				
					</c:forTokens>
				</div>
			</div>
	
			<div class="btnBox">
				<input type="submit" value="등록">
			</div>	
		</div>
	</form>
</section>