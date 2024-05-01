<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<div class="join__big">    
	<div class="event_title">회원문의</div>
		<c:choose>
			<c:when test='${NovelMember.mId != null && NovelMember.mId != "GodNovel"}'>
					<div class="noticeDetailWarp">
						<div class="noticeDetail_infoWrap">
							<div class="noticeDetail_info">
								<div>
									<input type="hidden" name="iNo" value="${inquiryDetail.iNo }" />
									<div class="noticeDetail_head_title">${inquiryDetail.iTitle }</div>
									<div class="inquiry__time">${inquiryDetail.iTime }</div>
								</div>
							</div>
						
							<div class=noticeDetail_contentWrap>
								<div class="noticeDetail_content">${inquiryDetail.iContentBr }</div>
								<c:if test='${inquiryDetail.iImg != null}'>
								<div><img alt="" src="/images/${inquiryDetail.iImg }"></div>
								</c:if>
							</div>

							<c:choose>
								<c:when test='${NovelMember.mId != null && NovelMember.mId != "GodNovel" && inquiryDetail.aTitle == null}'>
									<div class="eventWrite_bottom">	
										<input type="button" value="목록보기" onclick="location.href='Inquiry'" class="join_button"/>
										<div>
										<input type="button" value="수정" onclick="location.href='InquiryModify?iNo=${inquiryDetail.iNo }'" class="join_button"/>
										<input type="button" value="삭제" onclick="location.href='InquiryDelete?iNo=${inquiryDetail.iNo }'" class="join_button"/>
										</div>
									</div>
									
								</c:when>
								<c:when test='${NovelMember.mId != null && NovelMember.mId != "GodNovel" && inquiryDetail.aTitle != null}'>
									<div class="inquiry__borad">
										<div>
											<div class="noticeDetail_head_title">운영자 : ${inquiryDetail.aTitle }</div>
											<div class="inquiry__time">${inquiryDetail.answerTime }</div>
										</div>
									</div>
									<div class=inquiryDetail_contentWrap>
										<div class="noticeDetail_content">${inquiryDetail.iAnswerBr }</div>
									</div>
									<div>
										<div>
											<input type="button" value="목록보기" onclick="location.href='Inquiry'" class="join_button"/>
										</div>
									</div>
								</c:when>
							</c:choose>
						</div>
					</div>
			</c:when>		
<%--관리자일때 --%>	
		<c:when test='${NovelMember.mId == "GodNovel"}'>
		<div class="noticeDetailWarp">
			<div class="noticeDetail_infoWrap">
				<div class="noticeDetail_info">
					<div>
						<input type="hidden" name="iNo" value="${inquiryDetail.iNo }" />
						<div class="noticeDetail_head_title">${inquiryDetail.iTitle }</div>
						<div class="inquiry__time">${inquiryDetail.iTime }</div>
					</div>
				</div>
				
				<div class=noticeDetail_contentWrap>
					<div class="noticeDetail_content">${inquiryDetail.iContentBr }</div>
					<c:if test='${inquiryDetail.iImg != null}'></c:if>
					<div><img alt="" src="/images/${inquiryDetail.iImg }"></div>
				</div>

					<c:choose>
						<c:when test='${NovelMember.mId != null && NovelMember.mId == "GodNovel" && inquiryDetail.aTitle != null}'>
							<div class="inquiry__borad">
								<div>
									<div class="noticeDetail_head_title">운영자 : ${inquiryDetail.aTitle }</div>
									<div class="inquiry__time">${inquiryDetail.answerTime }</div>
								</div>
							</div>
							
							<div class="inquiryDetail_contentWrap">
								<div class="noticeDetail_content">${inquiryDetail.iAnswerBr }</div>
							</div>
							
							
							<div class="eventWrite_bottom">	
								<input type="button" value="목록보기" onclick="location.href='Inquiry'" class="join_button"/>	
								<div>
								<input type="button" value="수정" onclick="location.href='InquiryGodModify?iNo=${inquiryDetail.iNo }'" class="join_button"/>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="eventWrite_bottom">	
								<input type="button" value="목록보기" onclick="location.href='Inquiry'" class="join_button"/>
								<div>
								<input type="button" value="답변하기" onclick="location.href='InquiryGodWrite?iNo=${inquiryDetail.iNo }'" class="join_button"/>		
								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</c:when>
	</c:choose>
</div>