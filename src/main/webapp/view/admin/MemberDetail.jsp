<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<table border="1" class="unCssTable">
		<tr>
			<td colspan="2"><img alt="" src="/images/${memberData.mProfile }" width="80px" height="80px"></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${memberData.mId }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${memberData.mName }</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${memberData.email }</td>
		</tr>
		<tr>
			<td>닉네임</td>
			<td>${memberData.mNickname }</td>
		</tr>	
		<tr>
			<td>
				<input type="button" value="탈퇴" onclick="location.href='MemberDelete?m_no=${memberData.mNo}'"/>
			</td>
		</tr>
		<tr>
			<td>
				<a href="/comment/CommentHistory">댓글 히스토리</a>
			</td>
		</tr>
	</table>


