<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

	window.onload= function(){
		var open = document.querySelectorAll('.epiStatus > b')
		
		for (var i = 0; i < open.length; i++) {
	 		if(open[i].textContent == '공개'){	
				open[i].classList.add('active');
			} 
			
		}
		

	}

	function epiDel(novTitle, novMid, novEpi){

		if(novEpi==1){
			alert("첫 화는 수정만 가능합니다.")
		}else{
			
			if(confirm("정말로 삭제 하시겠습니까?")){
				location.href="EpiDelete?novTitle="+novTitle+"&novMid="+novMid+"&novEpi="+novEpi;
			}
		}
	}
	function novDel(novTitle, novMid, novImg ){
		if(confirm("정말로 삭제 하시겠습니까?")){
			location.href="NovelDelete?novTitle="+novTitle+"&novMid="+novMid+"&novImg="+novImg;
		}
	}
	
	function goLogin(){
		alert("로그인이 필요한 서비스입니다.")
		location.href="/login/Login"
	}

</script>


<section id="novelDetail" class="novel">
	<div class="novelDetailCont">
		<div class="novelTitle">
			<h2>${mainData[0].novTitle }</h2>
			<div><span>${mainData[0].novGenre }</span> | <span>${mainData[0].novTotEpi }편</span></div>
			<b class="nick">${mNick }</b>
			<c:if test="${NovelMember.mId == mainData[0].mId  || NovelMember.mId == 'GodNovel'}">
			<div class="novelBtn">
				<a href="<c:url value="/novel/NovelModifyForm?novTitle=${mainData[0].novTitle }&novMid=${mainData[0].mId }"/>">소설정보수정</a>		
				<a href="javascript:novDel('${mainData[0].novTitle }','${mainData[0].mId }','${mainData[0].novImg }' )">소설전체삭제</a>						
			</div>
		</c:if>
		</div>
		<div class="novelItem">
			<div class="novelCover"><img src="<c:url value="/images/${mainData[0].novImg }"/> " alt="" /></div>
			<div class="novelInfo">			
				<p>${mainData[0].novIntro }</p>
				<div class="novelInfoBottom">				
					<div class="novelIconWrap">
						<div class="novelIcon">
							<img src="/images/person_main.svg">
							<span>${mainData[0].novTotCnt }</span>
						</div>
						<div class="novelIcon">
						<img src="/images/heart_main.svg">
							<span>${mainData[0].novTotLike }</span>
						</div>
					</div>
					<a href="<c:url value="/novel/NovelView?novTitle=${mainData[0].novTitle }&novMid=${mainData[0].mId }&novEpi=${mainData[mainData[0].novEpi -1 ].novEpi }&novNo=${mainData[mainData[0].novEpi -1 ].novNo }"/>">1화 보러가기</a>
				</div>
			</div>
		</div>
	</div>
	
	<div class="epiListWrap">
		<h3>연재목록</h3>
		<ul class="epiList">
			<c:forEach items="${mainData }" var="dto" varStatus="no" >
			
			<c:choose>
				<c:when test="${dto.novOpen == 0 }">
					<c:choose>
						<c:when test="${NovelMember.mId == dto.mId || NovelMember.mId == 'GodNovel' }">
							<li class="epiItem">
								<a href="<c:url value="/novel/NovelView?novTitle=${mainData[0].novTitle }&novMid=${mainData[0].mId }&novEpi=${dto.novEpi }"/>">
									<div class="subtitle">
										<h4>${dto.novEpi}화) ${dto.novSubtitle }</h4>	
										<div class="detail">					
											<span>${dto.novRegdateStr }</span>
											<div class="detailIcon">	
												<img src="/images/person_main.svg">										
												<span>${dto.novCnt }</span>					
											</div>					
											<div class="detailIcon">
												<img src="/images/heart_main.svg">											
												<span>${dto.novLike }</span>					
											</div>
										</div>
									</div>
								</a>
								<div class="epiStatus">
									<b>비공개</b>
									<c:if test="${NovelMember.mId == dto.mId || NovelMember.mId == 'GodNovel' }">
										<div class="epiBtn">
											<a href="<c:url value="/novel/EpiModifyForm?novTitle=${dto.novTitle }&novMid=${dto.mId }&novEpi=${dto.novEpi }"/>">수정</a>
											<a href="javascript:epiDel('${dto.novTitle }','${dto.mId }','${dto.novEpi }')">삭제</a>									
										</div>
									</c:if>
								</div>
							</li>
						</c:when>
						<c:otherwise>
							<li class="epiItem">
								<div class="subtitle">
									<h4>${dto.novEpi}화) ${dto.novSubtitle }</h4>	
									<div class="detail">					
											<span>${dto.novRegdateStr }</span>
											<div class="detailIcon">	
												<img src="/images/person_main.svg">										
												<span>${dto.novCnt }</span>					
											</div>					
											<div class="detailIcon">
												<img src="/images/heart_main.svg">											
												<span>${dto.novLike }</span>					
											</div>
										</div>
								</div>
								<div class="epiStatus">
									<b>비공개</b>
								</div>
							</li>
						</c:otherwise>
					</c:choose>
					
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${dto.novEpi > 5 && NovelMember.mId == null }">
							<li class="epiItem">
								<a href="javascript:goLogin();">
									<div class="subtitle">
										<h4>${dto.novEpi}화) ${dto.novSubtitle }</h4>	
										<div class="detail">					
											<span>${dto.novRegdateStr }</span>
											<div class="detailIcon">	
												<img src="/images/person_main.svg">										
												<span>${dto.novCnt }</span>					
											</div>					
											<div class="detailIcon">
												<img src="/images/heart_main.svg">											
												<span>${dto.novLike }</span>					
											</div>
										</div>
									</div>
								</a>
								<div class="epiStatus">
									<b>공개</b>
								</div>
							</li>
						</c:when>
						<c:otherwise>
							<li class="epiItem">
								<a href="<c:url value="/novel/NovelView?novTitle=${mainData[0].novTitle }&novMid=${mainData[0].mId }&novEpi=${dto.novEpi }&novNo=${dto.novNo }"/>">
									<div class="subtitle">
										<h4>${dto.novEpi}화) ${dto.novSubtitle }</h4>	
										<div class="detail">					
											<span>${dto.novRegdateStr }</span>
											<div class="detailIcon">	
												<img src="/images/person_main.svg">										
												<span>${dto.novCnt }</span>					
											</div>					
											<div class="detailIcon">
												<img src="/images/heart_main.svg">											
												<span>${dto.novLike }</span>					
											</div>
										</div>
									</div>
								</a>
								<div class="epiStatus">
									<b>공개</b>
									<c:if test="${NovelMember.mId == dto.mId || NovelMember.mId == 'GodNovel'}">
										<div class="epiBtn">
											<a href="<c:url value="/novel/EpiModifyForm?novTitle=${dto.novTitle }&novMid=${dto.mId }&novEpi=${dto.novEpi }"/>">수정</a>
											<a href="javascript:epiDel('${dto.novTitle }','${dto.mId }','${dto.novEpi }')">삭제</a>								
										</div>
									</c:if>
								</div>
							</li>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
			</c:forEach>
		</ul>
	
		<c:if test="${NovelMember.mId == mainData[0].mId || NovelMember.mId == 'GodNovel'}">
			<a id="writeBtn" href="<c:url value="/novel/NovelWriteForm?novTitle=${mainData[0].novTitle }&novMid=${mainData[0].mId }" />">연재등록</a>
		</c:if>
	
	</div>
</section>