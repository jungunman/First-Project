
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<section id="epiModify" class="novel novelForm">
	<div class="novelFormTitle">	
		<h2>소설</h2>
		<span>에피소드 수정</span>
	</div>
	<form action="EpiModifyReg" method="post" enctype="multipart/form-data">
		<input type="hidden" name="novNo" value="${dto.novNo }">			
		<input type="hidden" name="novTitle" value="${dto.novTitle }">			
		<input type="hidden" name="novMid" value="${dto.mId }">			
		<input type="hidden" name="novEpi" value="${dto.novEpi }">			
		<div class="formBox">
			<div class="formRow">
				<div class="labelBox">소설 제목</div>
				<div class="inputBox">${dto.novTitle }</div>
			</div>
			<div class="formRow">
				<div class="labelBox">작성자</div>
				<div class="inputBox"><span class="nick">${mNick }</span></div>
			</div>
			
			<div class="formRow">
				<div class="labelBox">회차</div>
				<div class="inputBox">${dto.novEpi }</div>
			</div>	
			
			<div class="formRow">
				<div class="labelBox">에피소드 제목</div>
				<div class="inputBox"><input type="text" name="novSubtitle" value="${dto.novSubtitle }" required></div>
			</div>	
			<div class="formRow">
				<div class="labelBox">내용</div>
				<div class="inputBox"><textarea name="novCont" cols="50" rows="10" required>${dto.novCont }</textarea></div>
			</div>	
			<div class="btnBox">
				<input type="submit" value="등록">
			</div>		
		</div>
	</form>

</section>