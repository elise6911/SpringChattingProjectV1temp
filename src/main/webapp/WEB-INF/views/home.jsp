<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="include/header.jsp" %>

<section class="content">
	<div class="row">
		<div class ="col-md-12">
			<div class="box">
				<div class="box-header with-board">
					<h3 class="box-title">HOME PAGE</h3>
				</div>
			</div>
			
			<input type="button" id="login" value="로그인"><a href="user/login"></a></button>
			<input type="button" id="chat" value="채팅"><a href="chat"></a></button>
			<input type="button" id="signup" value="회원가입" href="user/signup"><a ></a></button>
			<input type="button" id="study" value="스터디"></button>
			
		</div>
	</div>
</section>

<%@ include file="include/footer.jsp" %>
