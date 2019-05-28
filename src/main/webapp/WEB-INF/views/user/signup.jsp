<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header-dev.jsp" %>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<form id="signup" name="signup" method="post" action="signupPost">
	ID : <input type="text" id="userId" name="userId" oninput="idCheck()">
	<span id="idCheckMsg"></span><br>
	PW : <input type="password" id="password" name="password" onchange="isSame()"><br>
	PW 확인 : <input type="password" id="passwordCheck" name="passwordCheck" oninput="isSame()">
	<span id="same"></span><br>
	이름 : <input type="text" name="name"><br>
	생년월일 : <input type="date" name="datepicker" id="birthday" value=""><br>
	성별 : <input type="radio" name="gender" value="M" checked="checked">남
		<input type="radio" name="gender" value="F">여
		<span id="gender"></span>
	<br>
	이메일<input type="text" id="emailId" name="emailId" onfocus="this.value=''">@
	<input type="text" id="emailDomain" name="emailDomain" value="" disabled placeholder="naver.com">
	<select id="selectmenu" name="select" onchange="emailChanged()">
		<option value="0" selected="selected">선택하세요</option>
	    <option value="naver.com">naver.com</option>
	    <option value="gmail.com">gmail.com</option>
	    <option value="daum.net">daum.net</option>
	    <option value="nate.com">nate.com</option>
   		<option value="9" >직접입력</option>
	</select><br>
	SNS : <input type="text" id="SNS" name="SNS"><br>
	핸드폰번호 : <input type="text" id="phoneNumber" name="phoneNumber" placeholder="010-0000-0000"><br>
	<input type="submit" id="submit" disabled="disabled" value="회원가입">
	<input type="reset" value="취소">
</form>

<script>
$(document).ready(function () {
    
  });
  
	$(function () {
    var radioVal = $('input[name="gender"]:checked').val();
    $("#gender").val(radioVal);
  	});
 function idCheck(){
	var idCheck = false;
	var query = {userId : $("#userId").val()};
	if("#userId"==''){
		$("#idCheckMsg").text("아이디를 입력해주세요.");
		$("#idCheckMsg").attr("style", "color:red");
	}
	$.ajax({ 
		url : '/user/idCheck',
		type : 'post',
		data : query,
		success: function(data){
			if( data ){
				idCheck = true;
				if( idCheck ){
					$("#idCheckMsg").text("사용 가능한 아이디 입니다.");
					$("#idCheckMsg").attr("style", "color:blue");
					$("#submit").prop("disabled", false);
				}
			}
			else{
				$("#idCheckMsg").text("사용 불가한 아이디 입니다.");
				$("#idCheckMsg").attr("style", "color:red");
				$("#submit").attr("disabled", "disabled");
				idCheck = false;
			}
		}
	});
}
 
 
  $(function() {
	    $("#datepicker").datepicker({
	    	showOn:"focus",
	    	dateFormat: "yy-mm-dd",
	    	onSelect: function(dateText){
	    		// alert("selectd date : " + dateText + "input value" + this.value);
	    		document.signup.datepicker.value = dateText;
	    		document.getElementById('birthday').value = dateText;	    		
	    	}
	    });
	  });
  function emailChanged(){
	  if(document.signup.select.options[document.signup.select.selectedIndex].value == '0'){
		  document.signup.emailDomain.disabled = true;
		  document.signup.emailDomain.value = "";
		 }
		 if(document.signup.select.options[document.signup.select.selectedIndex].value == '9'){
		  document.signup.emailDomain.disabled = false;
		  document.signup.emailDomain.value = "";
		  document.signup.emailDomain.focus();
		 } else{
		  document.signup.emailDomain.disabled = false;
		  document.signup.emailDomain.value = document.signup.select.options[document.signup.select.selectedIndex].value;
		  var selectVal = $('#selectmenu option:selected').val();
		  $("#emailDomain").val(selectVal);
		  
		  // alert($("#emailDomain").val());
		 }
  	}
  
  
  function isSame(){
	  var password = document.signup.password.value;
	  var passwordCheck = document.signup.passwordCheck.value;
	  document.getElementById('same').innerHTML='';
	  if( password.length < 6 || password.length > 12){
			document.getElementById('password').value = document.getElementById('passwordCheck').value = '';
			document.getElementById('same').innerHTML='비밀번호는 6자 이상 12자 이하만 이용가능합니다.';
			document.getElementById('same').style.color = 'red';
	}
	  if( document.getElementById('password').value != '' 
			  && document.getElementById('passwordCheck').value != '') {
		  if(document.getElementById('password').value == 
			  document.getElementById('passwordCheck').value){
			  document.getElementById('same').innerHTML='비밀번호가 일치합니다.';
			  document.getElementById('same').style.color = 'blue';
		  }else{
			 document.getElementById('same').innerHTML='비밀번호가 일치하지 않습니다.';
			 document.getElementById('same').style.color = 'red';		  
			}
	  }
  }
  
</script>


<%@include file="../include/footer-dev.jsp" %>