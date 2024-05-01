<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

	$(function(){		
		
		var change = false
		
		 $(".commentList_button > input[value='수정']").on("click",function(){
			const  modiBox = $(this).parents('.commentList_Box').closest('div').find('#comment_content')
			const text = modiBox.text()
			change = !change
			
			const modifyBtn = $(this)
			if(change){									
				$(this).val("수정완료")					
				$(this).next().next().show()
				console.log($(this).next().next())
				$(this).next().hide()
				modiBox.empty()
				modiBox.append("<input type='text' name = 'c_content' value='"+text+"' />")
			}				
			else{
				$(this).prop("type", "submit")	
			}
			$(this).next().next().on("click",function(){
				console.log("11")
				change = false;
				modifyBtn.val("수정")
				$(this).hide()
				modifyBtn.next().show()			
				modiBox.empty()
				modiBox.append(text)
				modiBox.children("input").remove()
			})
			
			
			
			
		 })
		
		
		
	})

</script>

<form action="/comment/CommentWriteRegNovel" method="post">	
	<c:choose>
		<c:when test="${NovelMember.mId!=null}">
		 <div class="commentWriteWrap">
			<input type="text" placeholder="댓글을 내용을 입력해주세요" class="comment_writeBox" name="c_content"/>
			<input type="submit" value="등록" class="comment_submit"/> 
			<input type="hidden" name="m_id" value="${NovelMember.mId}"> 
	    	<input type="hidden" name="nov_no" value="${dto.novNo }">
	    	<input type="hidden" name="c_regdate"/>
	    </div>
		</c:when>
	    <c:otherwise>
	    <div class="commentWriteWrap">
	    	<input type="text" placeholder="댓글을 작성하려면 로그인을 해주세요" disabled="disabled" class="comment_writeBox"/>
			<input type="submit" value="등록" class="comment_submit" disabled="disabled"/> 
	    </div>

	 	</c:otherwise>
    </c:choose>
</form>


<c:forEach items="${cData }" var="cdto">
<form action="/comment/CommentModifyNovel">
	<input type="hidden" name="c_no" value="${cdto.cNoNovel }"/>
	<input type="hidden" name="nov_no" value="${dto.novNo }">
	<div class="commentListWrap">
		<div class="commentList_Box">
			<div class="commentList_userBox">
				<div class="comment_user_img"><img src="/images/user.jpg"></div>
				<div class="comment_user_info">
					<div class="comment_id">${cdto.mIdNovel }</div>
					<div class="comment_date">${cdto.cRegdateNovel }</div>
					<div class="comment_content" id = "comment_content">${cdto.cContentNovel }</div>
				</div>
			</div>
			<div class="commentList_button" id="commentList_button">
				<c:if test="${NovelMember.mId==cdto.mIdNovel}">
					<input type="button" value="수정" class="comment_button">				
		    		<input type="button" value="삭제" class="comment_button"  onclick="location.href='/comment/CommentDeleteNovel?c_no=${cdto.cNoNovel }&nov_no=${dto.novNo }'"/>	
		    		<input type="button" value="취소" class="comment_button "  style="display:none;" />
				</c:if>	
			</div>
		</div>
	</div>		
</form>
</c:forEach>




  