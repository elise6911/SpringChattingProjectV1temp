<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@include file="../include/header-dev.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
					<h3>Chatting Room List</h3>
				</div>
<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px">NO</th>
							<th>Title</th>
							<th>UserId</th>
							<th>OpenTime</th>

						</tr>

						<c:forEach items="${chatList}" var="chatRoomVO">

							<tr>
								<td>${chatRoomVO.chatRoomId}</td>
								<td>${chatRoomVO.title}</td>
								<td>${chatRoomVO.userId}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${chatRoomVO.openTime}" /></td>
								
							</tr>

						</c:forEach>

					</table>
					
					<input type="button" id="newChatRoom" value="새로운 채팅방 만들기"  OnClick="window.location='createChat'">
				</div>
</body>
</html>

    <%@include file="../include/footer-dev.jsp" %>