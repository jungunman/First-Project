<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<form action="FreeBoardModifyReg?no=${dto.no}" method="post">
	<div class="freeboard__modify--box">
		<div class="board__nav">
			<a class="board__selected" href="/freeboard/FreeBoardList">자유게시판</a>
			<a href="/promotionBoard/PromotionBoardList">홍보게시판</a>
		</div>


		<div class="freeboard__title">
			<div class="freeboard__modify--title">제목</div>
			<div>
				<input class="freeboard__modify--input" type="text" name="title"
					value="${dto.title }" />
			</div>
		</div>

		<div class="freeboard__modify--content">
			<div class ="freeboard__modify--content2">내용</div>
			
			<div class="freeboard__modify--textarea">
				<textarea name="content" rows="8" cols="168">"${dto.content }"</textarea>
			</div>
		</div>

		<div class="freeboard__menucen">
		<input type="submit" value="수정" class="freeboard__status"/>	 <a href="FreeBoardList" class="freeboard__status">취소</a>
		</div>
	</div>
</form>




<%-- <form action="FreeBoardModifyReg?no=${dto.no}" method="post">
	<table border="">
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" value="${dto.title }" /></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="mId" value="${dto.mId }"
				readonly="readonly" /></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content" cols="50" rows="10">"${dto.content }"</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="수정" />
				<a href="FreeBoardList">취소</a></td>
		</tr>


	</table>
</form> --%>