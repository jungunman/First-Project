<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	window.onload = function(){
		var paramUri = location.search.split('novMenu=')[1];
		var novMenu  = decodeURI(paramUri);
		console.log(novMenu);
		
			console.log(paramUri == null)
		var menuLi =  document.querySelectorAll('.novelMenu > li');
			
		if(paramUri == null){
			menuLi[0].classList.add('active')
		}else {
			
			for (var i = 1; i < menuLi.length; i++) {
				if(menuLi[i].textContent.toLowerCase() == novMenu){
					menuLi[i].classList.add('active');
				}
			}
		}
		
	}
</script>

<section id="novelList" class="novel">
	<ul class="novelMenu">
		<li><a href="NovelList">전체</a></li>	
		<li><a href="NovelList?novMenu=new">NEW</a></li>
		<li><a href="NovelList?novMenu=best">BEST</a></li>
		<li><a href="NovelList?novMenu=판타지">판타지</a></li>
		<li><a href="NovelList?novMenu=무협">무협</a></li>
		<li><a href="NovelList?novMenu=로맨스">로맨스</a></li>
	</ul>
	
	<div class="novelListCont">
		<c:forEach items="${mainData }" var="dto" varStatus="no" >
		<a href="/novel/NovelDetail?novTitle=${dto.novTitle }&novMid=${dto.mId }">
		<div class=novelItem>
			<div class="novelCover">
				<img src="<c:url value="/images/${dto.novImg }"/> " alt="" />
			</div>
			<div class="novelInfo">
				<div class="novelInfoTop">
					<h3>${dto.novTitle }</h3>
					
					<div class="novelDesc">
						<span>${dto.novGenre } </span>
						|
						<span>${dto.novTotEpi }편 </span>
					</div>
					
					<b class="nick">${dto.mNickname }</b>
					<p>${dto.novIntro }</p>
				</div>
				<div class="novelInfoBottom">
					<div class="novelIconWrap">
						<div class="novelIcon">
							<img src="/images/person_main.svg">
							<span> ${dto.novTotCnt } </span>
						</div>
						<div class="novelIcon">
							<img src="/images/heart_main.svg">	
							<span> ${dto.novTotLike } </span>
						</div>
					</div>			
					<div class="btn">보러가기</div>
				</div>
				<%-- <button onclick="location.href='NovelDetail?novTitle=${dto.novTitle }&novMid=${dto.mId }'">보러가기</button> --%>
			</div>
		</div>	
		</c:forEach>
		</a>
	</div>
</section>