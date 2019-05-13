<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form id="loginForm" method="post" action="/user/loginPost">
	<input type="hidden" id="RSAModulus" value="${RSAModulus}" /><!-- 서버에서 전달한값을 셋팅한다. -->
	<input type="hidden" id="RSAExponent" value="${RSAExponent}" /><!-- 서버에서 전달한값을 셋팅한다. -->

	ID : <input type="text" name="userId"><br>
	PW : <input type="password" name="password"><br>
	<input type="checkbox" name="useCookie"> Remember Me
	<input type="submit" name="로그인">
	<input type="reset" name="리셋">
</form>

    <a href="/user/signup" class="text-center">Register a new membership</a>

<!-- 순서에 유의 -->
<script type="text/javascript" src="/resources/js/rsa.js"></script>
<script type="text/javascript" src="/resources/js/jsbn.js"></script>
<script type="text/javascript" src="/resources/js/prng4.js"></script>
<script type="text/javascript" src="/resources/js/rng.js"></script>


<script>
      $(function () {
    	
    	$(".btn-login").on("click",function(e){
    		
    		e.preventDefault(); 
    		
    		var rsa = new RSAKey();
    		 rsa.setPublic($('#RSAModulus').val(),$('#RSAExponent').val());

    		console.log($("input[name='userId']").val());
    		console.log($("input[name='password']").val());
    		
    		//사용자 계정정보를 암호화 처리
    	 	var encryptUserId = rsa.encrypt($("input[name='userId']").val());
    		var encryptPassword = rsa.encrypt($("input[name='password']").val()); 

    		$("input[name='userId']").val(encryptUserId);
    		$("input[name='password']").val(encryptPassword);
    		
    		
			$("#loginForm").submit();
     		
    	});  
    	  
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
    </script>