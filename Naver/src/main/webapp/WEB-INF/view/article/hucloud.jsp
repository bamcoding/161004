<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="/Naver/css/layout.css">
<title>HuCloud : 네이버 카페</title>
</head>
<body style="background:white">
	<div>
		<!-- body -->
		<div id="wrapper">
			<!-- menu_top -->
			<div id="menu_top" style="text-align: right; margin-right: 5px">
				<!-- right -->
				<div>
					<div style="display: inline-block;">
						<a href="http://www.naver.com">네이버</a>
					</div>
					<img style="height: 13px" src="/Naver/img/menu_top2.png">
					<div style="display: inline-block;">
						<a href="http://cafe.naver.com">카페</a> <img style="height: 13px"
							src="/Naver/img/menu_top1.png">
					</div>
					<img style="height: 13px" src="/Naver/img/menu_top2.png">
					<div style="display: inline-block;">
						<a href="http://www.naver.com">가입카페</a> <img style="height: 13px"
							src="/Naver/img/menu_top1.png">
					</div>
					<img style="height: 13px" src="/Naver/img/menu_top2.png">
					<div style="display: inline-block;">
						<input id="loginbtn" type="button" value="로그인">
						<div id="etc">
							<img src="/Naver/img/menu_top3.png">
						</div>
					</div>
				</div>
			</div>

			<!-- title image -->
			<div style="text-align: center;" id="title">
				<a href="./viewList"><img src="/Naver/img/title.png"></a>
			</div>
			<!-- menu middle -->
			<div id="middle_menus">
				<div style="margin-left: 16px; margin-right: 16px;">
					<div id="middle_menu">전체글보기</div>
					&nbsp;|
					<div id="middle_menu">우리카페지도</div>
					&nbsp;|
					<div id="middle_menu">이미지모아보기</div>
					&nbsp;|
					<div id="middle_menu">카페태그보기</div>
					&nbsp;|
				</div>
			</div>

			<!-- search -->
			<div style="text-align: right;">
				<div class="block">
					<input style="width: 300px;" type="text" />
				</div>
				<div class="block">
					<input id="searchbtn" type="button" value="검색" />
				</div>
			</div>

			<!-- bottom body -->
			<div id="bottom_body">
				<!-- left side -->
				<div id="left_side">
					<div id="left_side1">카페정보</div>
					<div id="left_side2">
						<input id="writeBtn" type="button" 
						style="width:100%;height:40px;border:1px solid black;border-radius: 5px;
						font-size:15px;background:#666;color:white;font-weight: bold;"
						onclick="location.href='./write'" value="카페 글쓰기" />
					</div>
					<div id="left_side3">메뉴목록</div>
					<div id="left_side4">광고</div>
					<div id="left_side5">최근댓글</div>
				</div>
				<!-- article side -->
				<div id="article_side">
					<div>
						<div class="block" style="margin-left: 10px; font-weight: bold">전체글보기</div>
						<div class="block" style="float: right; margin-right: 10px;">more</div>
						<div style="clear: right;"></div>
						<table>
							<tr>
								<td colspan=2>제목</td>
								<td>작성자</td>
								<td>작성일</td>
								<td>조회</td>
								<td>좋아요</td>
							</tr>
							<tr>
								<th colspan=6><img src="/Naver/img/th.png" ; id="th_icon" /> 이근재가 만든
									게시판 입니다.</th>
							</tr>
							<c:forEach items="${articles}" var="article">
								<tr>
									<td ><img src="/Naver/img/td.png" id="td_icon" /></td>
									<td style="width:40%">
									<a href="./detail?id=${article.id}">${article.title}</a></td>
									<td>${article.userId}</td>
									<td>${article.createdDate }</td>
									<td>${article.hitCount}</td>
									<td>${article.recommendCount}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<!-- right side -->
				<div id="right_side">
					<div id="right_side1">
						날씨날짜
						<div style="display: inline-block;">날씨</div>
						<div style="display: inline-block;">날짜</div>
					</div>
					<div id="right_side2">시간</div>
					<div id="right_side3">
						<div id="right_side3_1">네이버 실시간 검색어</div>
						<div id="right_side3_2">접속멤버</div>
						<div id="right_side3_3">멤버 소식</div>
						<div id="right_side3_4">지난주 멤버 랭킹</div>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<hr />
			<div style="text-align: center; margin: 20px;">네이버 카페 HuCloud</div>
		</div>
	</div>
</body>
</html>