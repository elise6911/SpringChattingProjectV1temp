<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<section class="content">
	<div class="row">
		<div class ="col-md-12">
			<div class="box">
				<div class="box-header with-board">
					<h3 class="box-title">HOME PAGE</h3>
				</div>
			</div> 

			
			<input type="button" id="login" value="로그인" OnClick="window.location='user/login'">
			<input type="button" id="chat" value="채팅" OnClick="window.location='chat/chatList'">
			<input type="button" id="signup" value="회원가입" OnClick="window.location='user/signup'">
			<input type="button" id="study" value="게시판"  OnClick="window.location='board/listAll'">
			
		</div>
	</div>
</section>
