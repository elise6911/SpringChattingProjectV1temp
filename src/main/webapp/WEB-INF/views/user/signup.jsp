<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>

<form id="signup" name="signup" method="post" action="/user/signupProc">
	ID : <input type="text" id="userId" name="userId" oninput="idCheck()">
	<span id="idCheckMsg"></span><br>
	PW : <input type="password" id="password" name="password" onchange="isSame()"><br>
	PW 확인 : <input type="password" id="passwordCheck" name="passwordCheck" oninput="isSame()">
	<span id="same"></span><br>
	이름 : <input type="text" name="name"><br>
	생년월일 : <input type="text" id="datepicker" ><br>
	성별 : <input type="radio" name="gender" value="male" checked = "checked">남
		<input type="radio" name="gender" value="female">여
	<br>
	이메일<input type="text" name="emailAddress" onfocus="this.value=';'">@
	<input type="text" name="emailDomain" value="" disabled placeholder="naver.com">
	<select id="selectmenu" name="select" onchange="emailChanged()">
	    <option value="naver.com" selected="selected">naver.com</option>
	    <option value="gmail.com">gmail.com</option>
	    <option value="daum.net">daum.net</option>
	    <option value="nate.com">nate.com</option>
   		<option value="9" >직접입력</option>
	</select><br>
	SNS : <input type="text" name="sns"><br>
	핸드폰번호 : <input type="text" name="phoneNumber" placeholder="010-0000-0000"><br>
	<input type="submit" id="submit" disabled="disabled" value="회원가입">
	<input type="reset" value="취소">
</form>

<script>

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
	    $( "#datepicker" ).datepicker({
	    	dateFormat: "yy-mm-dd"
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
		  document.signup.emailDomain.disabled = true;
		  document.signup.emailDomain.value = document.signup.select.options[document.signup.select.selectedIndex].value;
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