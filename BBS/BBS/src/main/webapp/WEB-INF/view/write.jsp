<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>작성하기</title>
</head>
<body>
	<h1>Write</h1>
	<hr />
<form name="write" method="post" action="./doWrite">
	<table border=1
		style="width: 400px; height: 400px; border-collaps: collaps; border: 1px solid black;">
		<tr>
			<th style="width:15%">제목</th>
			<td><input name="title" type="text" placeholder="제목을 입력하세요." style="width:98%" /></td>
		</tr>
		<tr style="height:85%">
			<th style="width:15%">내용</th>
			<td>
			<textarea name="content" placeholder="내용을 입력하세요." style="width:98%;height:340px"></textarea></td>
		</tr>
		<tr>
			<th style="width:15%">작성자</th>
			<td><input name="creater" type="text" placeholder="작성자를 입력하세요." style="width:98%" /></td>
		</tr>		
	</table>
	<hr/>
	<input type="submit" value="작성하기"/>
	<input type="button" value="돌아가기" onclick="location.href='./bbs'"/>
</form>
</body>
</html>