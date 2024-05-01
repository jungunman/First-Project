
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!-- <script>
	function dateChk(){
		var checked = document.querySelectorAll('input[name="serialDate"]:checked').length;
		if(checked == 0 ){
			alert('연재요일을 하나 이상 선택해주세요.')
			return false;
		}
	}
</script> -->
<section id="novelWrite" class="novel novelForm">

	<c:choose>
		<c:when test="${mainData == null }">
			<div class="novelFormTitle">	
				<h2>소설</h2>
				<span>소설 등록</span>
			</div>
			<form action="NovelWriteReg" method="post" enctype="multipart/form-data">
				<input type="hidden" name="novOpen" value="1">
				<div class="formBox">
					<div class="formRow">
						<div class="labelBox">소설 제목</div>
						<div class="inputBox"><input type="text" name="novTitle"  placeholder="소설제목 입력" required></div>
					</div>
					<div class="formRow">
						<div class="labelBox">작성자</div>
						<div class="inputBox"><input type="hidden" name="mId" value="${param.novMid }"><span class="nick">${mNick }</span></div>
					</div>
					
					<div class="formRow">
						<div class="labelBox">장르</div>
						<div class="inputBox">
							<select name="novGenre">
								<option value="판타지">판타지</option>
								<option value="로맨스">로맨스</option>
								<option value="무협">무협</option>
							</select>
						</div>
					</div>
					<div class="formRow">
						<div class="labelBox">시놉시스</div>
						<div class="inputBox"><textarea name="novIntro" cols="50" rows="5" placeholder="시놉시스 내용 입력"></textarea></div>
					</div>		
					<div class="formRow">
						<div class="labelBox">표지 이미지</div>
						<div class="inputBox"><input type="file" name="upFile"></div>
					</div>
					<div class="formRow">
						<div class="labelBox">연재요일</div>
						<div class="inputBox serialDateBox">
						<c:forTokens var="date" items="일,월,화,수,목,금,토" delims="," varStatus="no">
							<label><input type="checkbox" name="serialDate" value="${date }">${date }</label>
						</c:forTokens>
						</div>
					</div>

					<div class="formRow">
						<div class="labelBox">회차</div>
						<div class="inputBox"><input type="hidden" name="novEpi" value="1">1</div>
					</div>	
					
					<div class="formRow">
						<div class="labelBox">에피소드 제목</div>
						<div class="inputBox"><input type="text" name="novSubtitle" placeholder="에피소드 제목 입력" required></div>
					</div>	
					<div class="formRow">
						<div class="labelBox">내용</div>
						<div class="inputBox"><textarea name="novCont" cols="50" rows="10" placeholder="에피소드 내용 입력" required></textarea></div>
					</div>	
					<div class="btnBox">
						<input type="submit" value="등록">
					</div>
				</div>
			</form>
		</c:when>
		<c:otherwise>
	
		<c:choose>
			<c:when test="${mainData[0].novEpi < 5 }"><input type="hidden" name="novOpen" value="1"></c:when>
			<c:when test="${mainData[0].novEpi >= 5 && mainData[0].novLike >= 15 }"><input type="hidden" name="novOpen" value="1"></c:when>
			<c:otherwise>
				<input type="hidden" name="novOpen" value="0">
			</c:otherwise>
		</c:choose>
			<div class="novelFormTitle">	
				<h2>소설</h2>
				<span>연재등록</span>
			</div>
			<form action="NovelWriteReg" method="post" enctype="multipart/form-data">
				
				<input type="hidden" name="novOpen" value="1">
				<div class="formBox" >
					<div class="formRow">
						<div class="labelBox">소설 제목</div>
						<div class="inputBox"><input type="hidden" name="novTitle" value="${mainData[0].novTitle }">${mainData[0].novTitle }</div>
					</div>
					<div class="formRow">
						<div class="labelBox">작성자</div>
						<div class="inputBox"><input type="hidden" name="mId" value="${mainData[0].mId }"><span class="nick">${mNick }</span></div>
					</div>
					<div class="formRow">
						<div class="labelBox">장르</div>
						<div class="inputBox"><input type="hidden" name="novGenre" value="${mainData[0].novGenre }" >${mainData[0].novGenre }</div>
					</div>
					<div class="formRow">
						<div class="labelBox">시놉시스</div>
						<div class="inputBox"><textarea name="novIntro" cols="50" rows="5" readonly>${mainData[0].novIntro }</textarea></div>
					</div>			
					<div class="formRow">
						<div class="labelBox">표지 이미지</div>
						<div class="inputBox">
							<input type="hidden" name="novImg" value="${cover }" >
							<img alt="" src="/images/${cover }" width="200px" height="280px">
							<br/>
							${cover }
						</div>
					</div>
					<div class="formRow">
						<div class="labelBox">연재요일</div>
						<div class="inputBox"><input type="hidden" name="serialDate" value="${mainData[0].serialDate }">${mainData[0].serialDate }</div>
					</div>
					
					<div class="formRow">
						<div class="labelBox">회차</div>
						<div class="inputBox"><input type="number" name="novEpi" value="${mainData[0].novEpi +1 }"></div>
					</div>	
					
					<div class="formRow">
						<div class="labelBox">에피소드 제목</div>
						<div class="inputBox"><input type="text" name="novSubtitle" placeholder="에피소드 제목 입력" required></div>
					</div>	
					<div class="formRow">
						<div class="labelBox">내용</div>
						<div class="inputBox"><textarea name="novCont" cols="50" rows="10" placeholder="에피소드 내용" required></textarea></div>
					</div>	
					<div class="btnBox">
						<input type="submit" value="등록">
					</div>	
				</div>
			</form>
		</c:otherwise>
	</c:choose>

</section>
