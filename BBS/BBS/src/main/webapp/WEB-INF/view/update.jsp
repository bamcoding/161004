<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정하기</title>
</head>
<body>
	<h1>Rewrite</h1>
	<hr />
<form name="write" method="post" action="./doUpdate?id=${bbsVO.id}">
	<table border=1
		style="width: 400px; height: 400px; border-collaps: collaps; border: 1px solid black;">
		<tr>
			<th style="width:15%">제목</th>
			<td><input name="title" type="text" value="${bbsVO.title}" style="width:98%" /></td>
		</tr>
		<tr style="height:85%">
			<th style="width:15%">내용</th>
			<td>
			<textarea name="content" style="width:98%;height:340px">${bbsVO.content}</textarea></td>
		</tr>
		<tr>
			<th style="width:15%">작성자</th>
			<td>${bbsVO.creater}</td>
		</tr>		
	</table>
	<hr/>
	<input type="submit" value="수정하기"/>
	<input type="button" value="돌아가기" onclick="location.href='./detail?id=${bbsVO.id}'"/>
</form>
</body>
</html>