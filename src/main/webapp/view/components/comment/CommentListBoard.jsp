<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="CommentWriteRegBoard">
	<c:choose>
	<c:when test="${NovelMember.mId!=null}">
		<textarea rows="3" cols="40" placeholder="댓글을 입력해주세요" name="c_content"></textarea>
	    <input type="hidden" name="m_id" value="${NovelMember.mId}"> 
	    <input type="hidden" name="b_no" value="45">
	    <input type="submit" value="입력" /> 
    </c:when>
    <c:otherwise>
    	<textarea rows="3" cols="40" placeholder="댓글을 작성하려면 로그인 해주세요" disabled="disabled"></textarea>
    </c:otherwise>
    </c:choose>
</form>

<form action="CommentModifyBoard">
<c:forEach items="${cData }" var="cdto">
	<input type="hidden" name="c_no" value="${cdto.cNoBoard }"/>
	<table border="1px">
	  <tr>
	    <td>작성자</td>
	    <td>${cdto.mIdBoard }</td>
	  </tr>
	  <tr>
	    <td colspan="2">
	    <c:choose>
	    <c:when test="${NovelMember.mId==cdto.mIdBoard}">
	    <textarea rows="3" cols="40" name="c_content"> ${cdto.cContentBoard }</textarea>
	    </c:when>
	     <c:otherwise>
	     ${cdto.cContentBoard }
	     </c:otherwise>
	     </c:choose>
	   </td>
	  </tr>
	  <tr>
	   	<td colspan="2">
	   	${cdto.cRegdateBoard }
	   	<c:if test="${NovelMember.mId==cdto.mIdBoard}">
	   	 <input type="submit" value="수정"/>
	    <input type="button" value="삭제" onclick="location.href='/comment/CommentDeleteNovel?c_no=${cdto.cNoBoard }'" />
	   	</c:if>
	   	</td>
	  </tr>	
	</table>
</c:forEach>
</form>



  