<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	window.onload = function(){
		var paramUri = location.search.split('genre=')[1];
		var genMenu  = decodeURI(paramUri);
		console.log(genMenu  );
		
		var menuLi =  document.querySelectorAll('#mainGenreMenu > li');
			console.log(menuLi)
		if(paramUri == null){
			menuLi[0].classList.add('active')
		}else {
			
			for (var i = 0; i < menuLi.length; i++) {
				if(menuLi[i].textContent.toLowerCase() == genMenu){
					menuLi[i].classList.add('active');
				}
			}
		}
		
	}
</script>


    <!-- 메인 주간랭킹 시작  -->
    <section id="weeklyMain" class="mainSection">  
    	<div class="bgBox"></div> 
   		<h3>일주일 랭킹 소설</h3>
 		<div class="mainContent">
	    	<c:choose>
	    		<c:when test="${weekTopTen.size() == 0 }">
	    			<p>일주일 랭킹 소설이 없습니다.</p>
	    		</c:when>
	    		<c:otherwise>
	    			<c:forEach items="${weekTopTen}" var="todayRank">
	    			<div class="mainItem">
	    				<a href='<c:url value ="/novel/NovelDetail?novTitle=${todayRank.novTitle}&novMid=${todayRank.mId}" />'>
	    				<div class="mainItemImg">
	    					<img src='<c:url value="/images/${todayRank.novImg }"/>' />
						    <div class="mainItemInfo">
	    						<div class="mainItemCnt">
	    							<img src='<c:url value="/images/person_light.svg"/>'/>
	    							<span>${todayRank.novCnt}</span>
	    						</div>
	    						<div class="mainItemLike">
	    							<img src='<c:url value="/images/heart_light.svg"/>'/>
	    							<span>${todayRank.novLike}</span>
	    						</div>
	    					</div>
	    				</div>
	    				<div class="mainItemTitle">
	    					<h5>${todayRank.novTitle}</h5>
	    					<span class="nick">${todayRank.mNickname}</span>

	    				</div>
	    				</a>
	    			</div>
	    			</c:forEach>
	    		</c:otherwise>
	    	</c:choose>
	    </div>
	      
    </section>
    <!-- 메인 주간랭킹 끝 -->
    
    <!-- 메인 최신소설 시작 -->
    <section id="recentlyMain" class="mainSection">    
	    <h3>최신소설</h3>
	    <div class="mainContent">
	    	<c:choose>
	    		<c:when test="${recentUploadNovel.size() == 0 }">
	    			<p>최신 소설이 없습니다.</p>
	    		</c:when>
	    		<c:otherwise>
	    			<c:forEach items="${recentUploadNovel}" var="recentNovel">
	    			<div class="mainItem">
	    				<a href='<c:url value ="/novel/NovelDetail?novTitle=${recentNovel.novTitle}&novMid=${recentNovel.mId}" />'>
	    				<div class="mainItemImg">
	    					<img src='<c:url value="/images/${recentNovel.novImg }"/>' />
						    <div class="mainItemInfo">
	    						<div class="mainItemCnt">
	    							<img src='<c:url value="/images/person_light.svg"/>'/>
	    							<span>${recentNovel.novCnt}</span>
	    						</div>
	    						<div class="mainItemLike">
	    							<img src='<c:url value="/images/heart_light.svg"/>'/>
	    							<span>${recentNovel.novLike}</span>
	    						</div>
	    					</div>
	    				</div>
	    				<div class="mainItemTitle">
	    					<h5>${recentNovel.novTitle}</h5>
	    					<span class="nick">${recentNovel.mNickname}</span>

	    				</div>
	    				</a>
	    			</div>
	    			</c:forEach>
	    		</c:otherwise>
	    	</c:choose>
	    </div>

    </section>
    <!-- 메인 최신소설 끝 -->
    
    <!-- 메인 새소식 시작 -->
    <section class="mainSection">
		<h3>새소식</h3>
		
		<div class="mainTableWrap">	
			<div class="table"> 
		    	<c:choose>
		    		<c:when test="${recentNotice.size() == 0 }">
		    		<h4>공지사항</h4>
		    		<span class="emptyTable">공지사항이 없습니다.</span>	
		    		</table>		    		
		    		</c:when>
		    		
		    		<c:otherwise>
		    		<table>
				    	<caption>공지사항</caption>
			    		<colgroup>
			    			<col style="width: 78%;">
			    			<col style="width: 22%">
			    		</colgroup>
		    			<thead>
		    				<tr>
		    					<th scope="col">제목</th>
		    					<th scope="col">날짜</th>
		    				</tr>
		    			</thead>
		    			<tbody>
			    			<c:forEach items="${recentNotice }" var="rn">
					    	<tr>
					    		<td> <a href="/notice/NoticeDetail?nNo=${rn.nNo}"> ${rn.nTitle}</a></td>
					    		<td>${rn.nTime}</td>
					    	</tr>
					    	</c:forEach>
		    			</tbody>
	    			</table>
		    		<a href="/notice/Notice">More >></a>
		    		</c:otherwise>
		    	</c:choose>			
			    
			</div>	
			
		    <div class="table">

		    	<c:choose>
		    		<c:when test="${recentEvent.size() == 0 }">
		    		<h4>이벤트</h4>
		    		<span class="emptyTable">이벤트가 없습니다.</span>
		    		
		    		</c:when>
		    		<c:otherwise>
		    		<table border="1">
			    		<caption>이벤트</caption>
			    		<colgroup>
			    			<col style="width: 65%;">
			    			<col style="width: 35%">
			    		</colgroup>
		    			<thead>
		    				<tr>
		    					<th scope="col">제목</th>
		    					<th scope="col">기간</th>
		    				</tr>
		    			</thead>
		    			<tbody>
			    			<c:forEach items="${recentEvent }" var="re">
					    	<tr>  	
					    		<td>
					    			<a href='<c:url value ="/event/EventDetail?e_no=${re.eveNo }"/>'>
					    				${re.eveTitle}
					    			</a>
					    		</td>
					    		<td style="font-size: .8em">${re.eveStartDate } ~ ${re.eveEndDate}</td>
					    		<%-- <td>${re.eveRegdate}</td> --%>
					    	</tr>
				    		</c:forEach>
		    			</tbody>
		    		</table>
	    			<a href="/event/EventList">More >></a>	
		    		</c:otherwise>
		    	</c:choose>	
		    </div>	
		</div>
	
	</section>
    <!-- 메인 새소식 끝 -->

	<div id="genreTop" style="width:100%; height:100px;"></div>
	<!-- 메인 장르별 시작 -->
	<section id="genreMain" class="mainSection">
		<div class="bgBox"></div>	
	    <h3>장르별</h3>
	    <ul id="mainGenreMenu" class="novelMenu">
	    	<li><a href="/main?genre=판타지#genreTop">판타지</a></li>
	    	<li><a href="/main?genre=무협#genreTop">무협</a></li>
	    	<li><a href="/main?genre=로맨스#genreTop">로맨스</a></li>
	    </ul>
		<div class="mainContent">
	    	<c:choose>
	    		<c:when test="${genreNovel.size() == 0 }">
	    			<p>해당 장르의 소설이 없습니다.</p>
	    		</c:when>
	    		<c:otherwise>
	    			<c:forEach items="${genreNovel}" var="genre">
	    			<div class="mainItem">
	    				<a href='<c:url value ="/novel/NovelDetail?novTitle=${genre.novTitle}&novMid=${genre.mId}" />'>
	    				<div class="mainItemImg">
	    					<img src='<c:url value="/images/${genre.novImg }"/>' />
						    <div class="mainItemInfo">
	    						<div class="mainItemCnt">
	    							<img src='<c:url value="/images/person_light.svg"/>'/>
	    							<span>${genre.novCnt}</span>
	    						</div>
	    						<div class="mainItemLike">
	    							<img src='<c:url value="/images/heart_light.svg"/>'/>
	    							<span>${genre.novLike}</span>
	    						</div>
	    					</div>
	    				</div>
	    				<div class="mainItemDesc">
	    					<span>${genre.novGenre} | ${genre.novEpi} 화</span>
	    					<span>${genre.novRegdate}</span>
	    				</div>
	    				<div class="mainItemTitle">
	    					<h5>${genre.novTitle}</h5>
	    					<span class="nick">${genre.mNickname}</span>
	    				</div>
	    				
	    				</a>
	    			</div>
	    			</c:forEach>
	    		</c:otherwise>
	    	</c:choose>
	    </div>
	</section>
	<!-- 메인 장르별 끝 -->
	
	<!-- 메인 게시판 시작 -->
	<section class="mainSection">
		<h3>게시판</h3>
		
		<div class="mainTableWrap">	
			<div class="table">
		    
			    <c:choose>
		    		<c:when test="${popularPromotionBoard.size() == 0 }">
				    <h4>홍보게시판</h4>
		    		<span class="emptyTable">일주일 간 인기 홍보 게시글이 없습니다.</span>
		    		
		    		</c:when>
		    		<c:otherwise>
		    		<table>
			    		<caption>홍보게시판</caption>
			    		<colgroup>
			    			<col style="width: 78%;">
			    			<col style="width: 22%">
			    		</colgroup>
		    			<thead>
		    				<tr>
		    					<th scope="col">제목</th>
		    					<th scope="col">날짜</th>
		    				</tr>
		    			</thead>
		    			<tbody>
			    			<c:forEach items="${popularPromotionBoard }" var="ppb">
						   	<tr>
					   			<td>${ppb.title}</td>
					    		<td>${ppb.writeDay }</td>
					   			<td>${ppb.cnt }</td>
					    	</tr>
					    	</c:forEach>
		    			</tbody>
			    	</table>
			    	<a href="/promotionBoard/PromotionBoardList">More >></a>
		    		</c:otherwise>
		    	</c:choose>
			   						    
			</div>	
			
		    <div class="table">				
		    	<c:choose>
		    		<c:when test="${popularFreeBoard.size() == 0 }">
		    		<h4>자유게시판</h4>
		    		<span class="emptyTable">일주일 간 인기 자유 게시글이 없습니다.</span>
		    		</c:when>
		    		
		    		<c:otherwise>
  					    <table>
			    		<caption>자유게시판</caption>
			    		<colgroup>
			    			<col style="width: 68%;">
			    			<col style="width: 22%">
			    			<col style="width: 10%">
			    		</colgroup>
		    			<thead>
		    				<tr>
		    					<th scope="col">제목</th>
		    					<th scope="col">날짜</th>
		    					<th scope="col">조회</th>
		    				</tr>
		    			</thead>
		    			<tbody>
			    			<c:forEach items="${popularFreeBoard }" var="pfb">
						    <tr>
						   		<td>
							   		<a href='<c:url value ="/freeboard/FreeBoardDetail?no=${pfb.no}"/>'>
							   			${pfb.title}
							   		</a>
						   		</td>
						   		<td>${pfb.writeDay }</td>
						 		<td>${pfb.cnt }</td>
					    	</tr>
			    			</c:forEach>
		    			</tbody>
	    			</table>
	    			<a href="/freeboard/FreeBoardList">More >></a>
		    		</c:otherwise>
		    	</c:choose>		
			    
		    </div>	
		</div>
	
	</section>
	<!-- 메인 게시판 끝 -->


<!--     메인 페이지에서 다른 페이지로 이동하려할 때 필요한 no 및 primary Key 얻기 위해 DAO 수정 필요할 수도 있을 거 같구요!<br/>
    일단 공지사항과 이벤트는 확정이구욘^^ -->

