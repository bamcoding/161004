<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/Naver/css/layout.css">
<script type="text/javascript" src="/Naver/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
</script>

<title>${article.title }</title>
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
				<a href="/Naver/article/viewList"><img src="/Naver/img/title.png"></a>
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
				<div id="detail">
					<div>
						<div class="block" style="margin-left: 10px;">
						<input type="button" style="background:white; border:1px solid #ccc" value="다음글"/></div>
						<div class="block" style="float: right; margin-right: 10px;">
						<input type="button" style="background:white; border:1px solid #ccc" value="목록"/></div>
						<div style="clear: right;"></div>
						<div style="margin-top:5px;width:100%;border:1px solid #ccc;">
						<div style="margin: 20px 15px 10px 15px">
						<div class="block">${article.title }</div>&nbsp;&nbsp;|&nbsp;
						<div class="block">${article.menuId }</div>
						<div class="block" style="float: right;">
							<div class="block">${article.createdDate }</div>&nbsp;&nbsp;|&nbsp;
							<div class="block">수정</div>&nbsp;&nbsp;|&nbsp;
							<div class="block"><a href="./doDelete?id=${article.id }">삭제</a></div>							
						</div>
						<div style="clear:right;"></div>
						</div>
						<div style="margin: 5px 15px 5px 15px">
						<div style="border-top:1px dashed #ccc;padding-top:10px;">${article.userId }</div>
						<div style="margin: 40px 0px 30px 0px">${article.content }</div>
						
						</div>
						
						</div>
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