<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>방명록</title>
</head>
<body>
	<h1>방명록</h1>
	<br> 방명록 전체 수 : ${count } 방문한 수 : ${cookieCount }
	<br>
	<br>

	<c:forEach items="${list}" var="guestbook">
		${guestbook.id }<br>
		${guestbook.name }<br>
		${guestbook.content }<br>
		${guestbook.regdate }<br>
		<c:if test="${sessionScope.isAdmin == 'true' }">
			<a href="delete?id=${guestbook.id }">삭제</a>
			<br>
			<br>
		</c:if>
	</c:forEach>

	<br>
	<c:forEach items="${pageStartList}" var="pageIndex" varStatus="status">
		<a href="list?start=${pageIndex}">${status.index +1 }</a>&nbsp; &nbsp;
	</c:forEach>

	<br>
	<br>

	<form method="post" action="write">
		name : <input type="text" name="name"><br>
		<textarea name="content" cols="60" rows="6"></textarea>
		<br> <input type="submit" value="등록">
	</form>

</body>
</html>