<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div class="Question">
	<p class="Question__reported-Member">${dto.reportedMemberMId }</p>
	<p class="Question__reporting-Member">${dto.mId }</p>
	<p class="Question__date">${dto.rDateStr }</p>
	<p class="Question__title">${dto.title }</p>
	<p class="Question__content">${dto.content }</p>
</div>

<form action="ReportMemberAnswerModifyReg">
	<input type="hidden" name="no" value="${dto.reportNo}" />
	<input type="text" name="answer" value="${dto.answer}" />
	<input type="submit" value="답변 완료" />
</form>    