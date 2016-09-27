<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내용보기</title>
</head>
<body>
<h1>Detail</h1><hr/>
	<table border=1
		style="width: 400px; height: 400px; border-collaps: collaps; border: 1px solid black;">
		<tr>
			<th style="width:15%">제목</th>
			<td>${bbsVO.title}</td>
		</tr>
		<tr style="height:85%">
			<th style="width:15%">내용</th>
			<td>${bbsVO.content}</td>
		</tr>
		<tr>
			<th style="width:15%">작성자</th>
			<td>${bbsVO.creater}</td>
		</tr>
	</table>
	<h4>
	조회수 ${bbsVO.hitCount}&nbsp;| 
	추천수 ${bbsVO.recommandCount}&nbsp;<input type="button" value="추천!" onclick="location.href='./detail?id=${bbsVO.id}&recommand=press'"/>
	</h4>
	<hr/>	
	<input type="button" value="수정하기" onclick="location.href='./update?id=${bbsVO.id}'"/>
	<input type="button" value="삭제하기" onclick="location.href='./doDelete?id=${bbsVO.id}'"/>
	<input type="button" value="돌아가기" onclick="location.href='./bbs'"/>
</body>
</html>