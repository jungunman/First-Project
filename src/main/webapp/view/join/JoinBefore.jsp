<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="../js/jquery-3.7.1.js"></script>
<script type="text/javascript">
	$(function (){
		$('#allChk').click(function() {
			
			if($(this).is(':checked')){
				$('.join__chklist input:checkbox').prop('checked',true)	
			}else{				
				$('.join__chklist input:checkbox').prop('checked',false)
			}
		})
		
		$('.join_button').click(function() {
			
			if($(this).is(':checked')){
				$('input:checkbox[name=chkTrue]').prop('checked',true)	
				return
			}else{				
				$('input:checkbox[name=chkTrue]').prop('checked',false)
				alert('필수 항목을 체크해주세요.')
				window.location = "/join/Join"
			}
		})
	})
</script>

<div class="join__big">
	<form action="/join/Join" method="post">
			<div class="join__top">
				<div class="join__title">Nonvel 101 회원 유형을 선택해주세요</div>
				<div class="join__middle">
					<div class="join__check"><input type="radio" name="kind" checked="checked"/><br/>일반회원<br/>(14세 이상)</div>
					<div class="join__check"><input type="radio" name="kind" /><br/>어린이 회원<br/>(14세 미만)</div>
				</div>
	
			<div class="join__totalChk">
				<div><input type="checkbox" name="allChk" id="allChk"  />전체 약관 동의</div>
				<hr/>
				<div class="join__chklist">		
					<div class="join__chk"><input type="checkbox" name="chkTrue" />이용약관 동의(필수)</div>
					<div class="join__chk--input"><input type="button" value="내용보기"/></div>
				</div>
				<div class="join__chklist">			
					<div class="join__chk"><input type="checkbox" name="chkTrue" />개인정보 수집 및 이용 동의(필수)</div>
					<div class="join__chk--input"><input type="button" value="내용보기"/></div>
				</div>
				<div class="join__chklist">		
					<div class="join__chk"><input type="checkbox" name="chkTrue" />유료작품 게시약관 동의(필수)</div>
					<div class="join__chk--input"><input type="button" value="내용보기"/></div>
				</div>
				<div class="join__chklist">		
					<div class="join__chk"><input type="checkbox" name="chkTrue" />유료이용약관 동의(필수)</div>
					<div class="join__chk--input"><input type="button" value="내용보기"/></div>
				</div>
				<div class="join__chklist">		
					<div class="join__chk"><input type="checkbox" name="chkFalse" />개인정보 제3자 제공 동의(선택)</div>
					<div class="join__chk--input"><input type="button" value="내용보기"/></div>
				</div>
				<div class="join__chklist">		
					<div class="join__chk"><input type="checkbox" name="chkFalse" />마케팅 정보 수신 동의(선택)</div>
					<div class="join__chk--input"><input type="button" value="내용보기"/></div>
				</div>
			</div>
			<div>		
				<div class="join_move">
				<a href="/login/Login" class="join_button">취소</a>
				<input type="submit" value="다음" class="join_button" />
				</div>
			</div>
		</div>
	</form>
</div>