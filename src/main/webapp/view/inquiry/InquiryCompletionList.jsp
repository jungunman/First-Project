<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<div class="join__big"> 
	<c:choose>
		<c:when test='${NovelMember.mId != null && NovelMember.mId == "GodNovel" }'>
			<div class="event_title">1:1 고객센터
				<span class="inquiry_subTitle"><a href="Inquiry">문의내역 |</a></span>
				<span class="inquiry_subTitle"><a href="InquiryProcessingList">처리중 |</a></span>
				<span class="inquiry_subTitle active"><a href="InquiryCompletionList">답변완료</a></span>
			</div>  
			<form action="InquiryWrite">
			<input type="hidden" name="iNo" value="${inquiryDetail.iNo }" />
				<div>
					<div>				
						<div class="eventListWrap">
							<c:forEach items="${inquiryGodList }" var="dto">
								<c:if test="${dto.iCategory == '답변완료' }">
									<div class="eventListWrap_listWrap">
										<a class="inquiry__title" href="<c:url value="/inquiry/InquiryDetail?iNo=${dto.iNo }"/>">
											<div class="inquiry_info">
												<div class="inquiry_title">${dto.iTitle }</div>
												<div class="inquiry__time">${dto.iTime }</div>
					 						</div>
					 						<div class="eventList_status">${dto.iCategory }</div>
										</a>
									</div>
							</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
			</form>
		</c:when>
	</c:choose>
</div>
<jsp:include page="../components/paging.jsp" />