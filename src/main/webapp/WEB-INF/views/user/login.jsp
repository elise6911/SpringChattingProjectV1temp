<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../include/header-dev.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<form id="loginForm" method="post" action="/user/loginPost" autocomplete="off">

	ID : <input type="text" name="userId" id="userId"><br>
	PW : <input type="password" name="password" id="password"><br>
	<input type="checkbox" name="useCookie" id="useCookie"> Remember Me
	<button type="submit" class="btn btn-primary btn-block btn-flat btn-login">Sign In</button>
	<input type="reset" name="리셋">
	<a href="/user/signup" class="text-center">Register a new membership</a>
</form>

<script>


	$(document).ready(function () {
	  
	});
    $(function () {
   	
	   	$(".btn-login").on("click",function(e){
	   		
	   		e.preventDefault(); 
	   		
	   		var userId = $("#userId").val();
	   		var password = $("#password").val();
	   		
	   		if( userId == ""){
	   			alert("아이디를 입력하세요");
	   			$("#userId").focus();
	   			return;
	   		}
	   		if( password == ""){
	   			alert("비밀번호를 입력하세요");
	   			$("#password").focus();
	   			return;
	   		}
			$("#loginForm").submit();
	   	});  
	});
     
      
</script>

<%@include file="../include/footer-dev.jsp" %>