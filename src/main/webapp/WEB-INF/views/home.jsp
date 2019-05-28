<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<h1> ${user.name }님 환영합니다.</h1>
<section class="content">
	<div class="row">
		<div class ="col-md-12">
			<div class="box">
				<div class="box-header with-board">
					<h3 class="box-title">HOME PAGE</h3>
				</div>
			</div> 
			
			<c:if test="${empty user}">
                <div class="pull-left image">
                    
                </div>
                <div class="pull-left info">
                    <p>Guest</p>
                        <%-- Status --%>
                    <a href="#"><i class="fa fa-circle text-danger"></i> OFFLINE</a>
                </div>
            </c:if>
            <c:if test="${not empty user}">
                <div class="pull-left image">
                    
                </div>
                <div class="pull-left info">
                    <p>${user.name}</p>
                        <%-- Status --%>
                    <a href="#"><i class="fa fa-circle text-success"></i> ONLINE</a>
                </div>
            </c:if>
<c:if test="${user ne null}">
	<input type="button" id="login" value="로그아웃" OnClick="window.location='user/logout">
</c:if>
<c:if test="${user eq null}">
			<input type="button" id="login" value="로그인" OnClick="window.location='user/login'">
</c:if>
			<input type="button" id="chat" value="채팅" OnClick="window.location='chat/chatRoomList'">
			<input type="button" id="signup" value="회원가입" OnClick="window.location='user/signup'">
			<input type="button" id="study" value="게시판"  OnClick="window.location='board/listAll'">
			
		</div>
	</div>
</section>
