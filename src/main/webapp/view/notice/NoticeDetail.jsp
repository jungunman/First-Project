<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<div class="eventWrite">
	<div class="event_title">공지사항</div>
	<div class="noticeDetailWarp">
		<div class="noticeDetail_infoWrap">
			<div class="noticeDetail_info">
				<div>
					<div class="noticeDetail_head_title">${noticeDetail.nTitle }</div>
					<div class="eventList_date">${noticeDetail.nTime }</div>
				</div>			
			</div>
			
			<div class="noticeDetail_contentWrap">
				<div class="noticeDetail_content">${noticeDetail.nContentBr }</div>
				<c:if test="${noticeDetail.mImg != null}">
				<div><img alt="" src="/images/${noticeDetail.mImg }"/></div>
				</c:if>
			</div>
			
			<div class="eventWrite_bottom">	
				<input type="button" value="목록보기" onclick="location.href='Notice'" class="event_button">
			
				<c:if test="${NovelMember.mId=='GodNovel'}">		
					<input type="button" value="수정" onclick="location.href='NoticeModify?nNo=${noticeDetail.nNo }'" class="event_modifyButton event_button"/>
					<input type="button" value="삭제" onclick="location.href='NoticeDelete?nNo=${noticeDetail.nNo }'" class="event_button"/>		
				</c:if>
			</div>	
			
		</div>
 	</div>
</div>
