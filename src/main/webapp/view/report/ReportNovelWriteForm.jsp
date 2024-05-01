<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<section class="novel novelForm">
    
	<div class="novelFormTitle">	
		<h2>신고</h2>
		<span>소설 신고</span>
	</div>
	
   <form action="ReportNovelReg">
	   <div class="formBox">
   			<input type="hidden" name="target" value="${dto.novNo}"/>

	   		<div class="formRow">
	   			<div class="labelBox">소설 작성자</div>
	   			<div class="inputBox">${dto.mId }</div>	
	   		</div>
	   		<div class="formRow">
	   			<div class="labelBox">소설 제목</div>
	   			<div class="inputBox">${dto.novTitle }</div>	
	   		</div>
	   		<div class="formRow">
	   			<div class="labelBox">소설 회차</div>
	   			<div class="inputBox">${dto.novEpi}</div>	
	   		</div>
	   		
	   		<div class="formRow">
	   			<div class="labelBox">소설 소제목</div>
	   			<div class="inputBox">${dto.novSubtitle }</div>	
	   		</div>

	   		<div class="formRow">
	   			<div class="labelBox">신고 제목</div>
	   			<div class="inputBox"> <input type="text" name="title" placeholder="신고 제목을 입력해주세요."/></div>
	   		</div>
	   		<div class="formRow">
	   			<div class="labelBox">신고 내용</div>
	   			<div class="inputBox"><input type="text" name="content" placeholder="신고 내용을 입력해주세요."/></div>
	   		</div>
	   		<div class="btnBox">
	   			<input type="submit" value="신고하기" />	   			
	   		</div>
	   </div>
   	</form>
   	
  </section>