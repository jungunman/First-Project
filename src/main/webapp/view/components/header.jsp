<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

	<div class="super_top">
		<ul>
		<c:choose>
			<c:when test="${NovelMember==null}">
				<li><a href="/login/Login">로그인</a></li>
				<li><a href="/join/JoinBefore">회원가입</a></li>
				<li><a href="/notice/Notice">공지사항</a></li>
			</c:when>
			<c:when test='${NovelMember.mId != null && NovelMember.mId == "GodNovel" }'>
				<span><b>${NovelMember.mNickname}</b> 님 어서오세요.</span>
				<li><a href="/notice/Notice">공지사항</a></li>
				<li><a href="/inquiry/Inquiry">문의</a></li>
				<li><a href="/logout/Logout">로그아웃</a></li>
			</c:when>
			<c:otherwise>
				<span><b>${NovelMember.mNickname}</b> 님 어서오세요.</span>
				<li><a href="/logout/Logout">로그아웃</a></li>
				<li><a href="/notice/Notice">공지사항</a></li>
				<li><a href="/inquiry/InquiryWrite">문의</a></li>
				<li><a href="/novel/NovelWriteForm?novMid=${NovelMember.mId }">새소설등록</a></li>
			</c:otherwise>
		</c:choose>
		</ul>
	</div>
	
    <header>
    	<ul>
	    	<li id="logo"><a href="/"><img src="/images/logo.png"></a></li>
	    	<li><a href="/novel/NovelList">소설</a></li>
	    	<li><a href="/freeboard/FreeBoardList">게시판</a></li>
	    	<li><a href="/event/EventList">이벤트</a></li>
	    	<c:if test="${NovelMember.mId!=null}">	
	    		<li><a href="/myPage/MyPageDetail">마이페이지</a></li>
	    	</c:if>
	    	<c:if test='${NovelMember.mId != null && NovelMember.mId == "GodNovel" }'>
	    		<li><a href="/admin/MemberList">관리자 페이지</a></li>
	    	</c:if>    
    	</ul>
    </header>