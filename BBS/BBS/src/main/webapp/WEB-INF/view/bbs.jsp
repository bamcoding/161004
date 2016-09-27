<%@page import="java.util.List"%>
<%@page import="net.gondor.bbs.vo.BbsVO"%>
<%@page import="net.gondor.bbs.dao.BbsDao"%>
<%@page import="net.gondor.bbs.dao.BbsDaoImpl"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BBS</title>
</head>
<body>
	<h1>BBS TABLE</h1>
	<hr />
	<table style="border-collaps:collaps;border:1px solid black; width:100%">
		<tr style="background-color:orange">
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>추천수</th>
			<th>작성일</th>
		</tr>
		
		<c:forEach items="${bbsVOs}" var="bbs">
			<tr>
				<td style="text-align:center">${bbs.id}</td>
				<td><a href="./detail?id=${bbs.id}">${bbs.title}</a></td>
				<td style="text-align:center">${bbs.creater}</td>
				<td style="text-align:center">${bbs.hitCount}</td>
				<td style="text-align:center">${bbs.recommandCount}</td>
				<td style="text-align:center">${bbs.creatDate}</td>
			</tr>
		</c:forEach>
	</table>
	
	<hr/>
	<form>
	<input type="button" value="작성하기" onclick="location.href='write'" />	
	</form>
</body>
</html>