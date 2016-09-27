<%@page import="java.util.List"%>
<%@page import="net.gondor.bbs.vo.BbsVO"%>
<%@page import="net.gondor.bbs.dao.BbsDao"%>
<%@page import="net.gondor.bbs.dao.BbsDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>BBS</title>
</head>
<body>
	<h1>BBS TABLE</h1>
	<hr />
	<table style="border-collaps:collaps;border:1px solid black; width:100%">
		<tr style="background-color:orange">
			<th>글번호</th>
			<th>글제목</th>
			<th>조회수</th>
			<th>추천수</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
<%	BbsDao dao = new BbsDaoImpl();
	List<BbsVO> bbsVOs = dao.getAllBbs();
	for(BbsVO bbsVO : bbsVOs){
	%>
		<tr>
				<td><%=bbsVO.getId()%></td>
				<td><%=bbsVO.getTitle()%></td>
				<td><%=bbsVO.getHitCount()%></td>
				<td><%=bbsVO.getRecommandCount()%></td>
				<td><%=bbsVO.getCreater()%></td>
				<td><%=bbsVO.getCreatDate()%></td>
		</tr>
<%	} %>
	</table>
	
</body>
</html>