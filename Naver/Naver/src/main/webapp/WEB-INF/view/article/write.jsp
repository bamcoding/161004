<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/Naver/css/layout.css">
<script type="text/javascript" src="/Naver/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		var error = "${error}";
		if (error == 1) {
			alert("제목을 입력하세요.");
		}
		if (error == 2) {
			alert("내용을 입력하세요.");
		}

		$("#writeBtn2").click(function() {
			$("#writeForm").attr({
				"method" : "post",
				"action" : "./doWrite"
			}).submit();
		});

		$("#logout").click(function() {
			if (confirm("로그아웃 하시겠습니까?")) {
				location.href = "/Naver/doLogout";
			}
		});

	});
</script>
<title>카페 글쓰기</title>
</head>
<body style="background: white">
	<div>
		<!-- body -->
		<div id="wrapper">
			<!-- menu_top -->
			<div id="menu_top" style="text-align: right; margin-right: 5px">
				<!-- right -->
				<div>
					<div class="block">
						<a href="http://www.naver.com">네이버</a>
					</div>
					<img style="height: 13px" src="/Naver/img/menu_top2.png">
					<div class="block">
						<a href="http://cafe.naver.com">카페</a> <img style="height: 13px"
							src="/Naver/img/menu_top1.png">
					</div>
					<img style="height: 13px" src="/Naver/img/menu_top2.png">
					<div class="block">
						<a href="http://www.naver.com">가입카페</a> <img style="height: 13px"
							src="/Naver/img/menu_top1.png">
					</div>
					<img style="height: 13px" src="/Naver/img/menu_top2.png">
					<div class="block">
						<c:if test="${not empty user }">
							<div class="block">${user.name }
								: <span id="point">${user.point }</span>pt
							</div>
							<div class="block">
								<input id="logout" type="button" value="로그아웃">
							</div>
						</c:if>
					</div>
				</div>
			</div>

			<!-- title image -->
			<div style="text-align: center;">
				<a href="/Naver/article/viewList"><img
					src="/Naver/img/title.png"></a>
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
							style="width: 100%; height: 40px; border: 1px solid black; border-radius: 5px; font-size: 15px; background: #666; color: white; font-weight: bold;"
							onclick="location.href='./write'" value="카페 글쓰기" />
					</div>
					<div id="left_side3">메뉴목록</div>
					<div id="left_side4">광고</div>
					<div id="left_side5">최근댓글</div>
				</div>
				<!-- article side -->
				<div id="detail">
					<form id="writeForm">
						<div style="margin-top: 5px; width: 100%; border: 1px solid #ccc;">
							<div style="margin: 20px;">
								<div class="block" style="font-weight: bold">SmartEditor™</div>
								<div class="block" style="float: right">언제, 어디서나 간편하세 사진,
									글을 등록하세요.</div>
								<div style="clear: right;"></div>
								<br />
								<div>
									<div class="block" style="width: 75px;">카테고리</div>
									<div class="block">
										<select>
											<option>과제 게시판</option>
											<option>없음</option>
										</select>
									</div>
									<div class="block">
										<select>
											<option>말머리선택</option>
											<option>없음</option>
										</select>
									</div>
								</div>
								<div>
									<div class="block" style="width: 75px;">제목</div>
									<input id="title" name="title" type="text" style="width: 60%"
										placholder="게시판 제목을 입력하세요" />
								</div>
								<div>
									<div class="block" style="width: 75px;">파일첨부</div>
									<div class="block">사진 | 동영상 | 지도 | GPS | 일정 | 링크 | 파일 |
										투표 | 음악</div>
								</div>
								<div>
									<div class="block" style="width: 75px;">정보첨부</div>
									<div class="block">책DB | 영화DB | 드라마DB | 음악DB | 상품DB |
										인물DB | 날씨DB | 지식백과DB</div>
								</div>
								<textarea id="content" name="content"
									style="height: 400px; width: 100%; margin-top: 30px"></textarea>
							</div>
							<div style="text-align: center">
								<input type="button" id="writeBtn2"
									style="font-weight: bold; border-radius: 3px; border: 2px solid #ccc; background: white; margin-bottom: 30px; width: 80px; height: 30px;"
									value="확인" />
							</div>
						</div>
					</form>
				</div>
				<div class="clear"></div>
			</div>
			<hr />
			<div style="text-align: center; margin: 20px;">네이버 카페 HuCloud</div>
		</div>
	</div>
</body>
</html>