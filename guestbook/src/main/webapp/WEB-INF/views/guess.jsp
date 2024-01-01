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
<title>숫자 맞추기</title>
</head>
<body>
	<h1>숫자 맞추기 게임</h1>
	<hr>
	<h3>${message }</h3>
	
	<c:if test="${sessionScope.count != null }">
		<form action="guess" method="get">
			1부터 100사이의 숫자를 기입해 주세요.<br>
			<input type="text" name="number"><br>
			<input type="submit" value ="전송">
		</form>
	</c:if>
	
	<a href="guess"> 게임 다시 시작하기 !!</a>
</body>
</html>