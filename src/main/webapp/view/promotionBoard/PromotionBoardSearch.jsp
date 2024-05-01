<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form action="PromotionBoardSearchList" method="post">
<div class="promotionBoard">

	<div class="board__nav">
		<a href="/freeboard/FreeBoardList">자유게시판</a>
		<a class="board__selected" href="PromotionBoardList">홍보게시판</a>
	</div>
	
	
	<div class ="board__search">
		<div><input class ="board__search2" type="text" name="title" placeholder="작품검색" /></div>
		<div><input type="submit" value="검색" class="board__status"/></div>
		<div class="board__status"><a href="PromotionBoardList" >취소</a></div>			
	</div>		
</div>

</form>

