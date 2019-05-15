<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
							<th>UserId</th>
							<th>OpenTime</th>

						</tr>

						<c:forEach items="${chatList}" var="chatRoomVO">

							<tr>
								<td>${chatRoomVO.chatRoomId}</td>
							
								<td>${chatRoomVO.userId}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${chatRoomVO.openTime}" /></td>
								
							</tr>

						</c:forEach>

					</table>
				</div>
</body>
</html>