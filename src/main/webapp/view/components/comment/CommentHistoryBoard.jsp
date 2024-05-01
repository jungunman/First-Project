<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>내 댓글 히스토리</h1>

<table border="1px">
  <tr>
  	<td >제목</td>
    <td>게시글</td>
    <td>게시한사람아이디</td>
    <td>내 댓글내용</td>
    <td>댓글작성일</td>
  </tr>
  <c:forEach items="${cData }" var="cdto">
  	<c:if test="${cdto.mIdBoard==NovelMember.mId }">
		  <tr>	  	
		  	<td><a href="#}">${cdto.boardType }</a><br/>해당게시판내용으로 이동</td>
		  	<td><a href="#}">${cdto.boardTitle }</a><br/>해당게시판으로 이동</td>
		    <td>${cdto.boardWriter }</td>
		    <td>${cdto.cContentBoard }</td>
		    <td>${cdto.cRegdateBoard }</td>
		  </tr>
	  </c:if>
  </c:forEach>
</table>
