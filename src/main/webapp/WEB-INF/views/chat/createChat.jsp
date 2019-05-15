/<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form id="createForm" method="POST" action="/chat/chatList">
	채팅방 이름을 입력하세요 : <input type="text" name="title" id="title"><br>
	<input type="submit" id="OK">확인</button>
	<input type="reset" name="취소">
</form>

</body>
</html>