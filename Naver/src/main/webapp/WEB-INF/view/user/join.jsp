<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			alert("서버에 문제가 발생하였습니다.");
		}
		if (error == 2) {
			alert("아이디 혹은 이름을 입력해주세요.");
		}
		if (error == 3) {
			alert("비밀번호를 입력해주세요.");
		}
		if (error == 4) {
			alert("중복되는 아이디입니다.");
		}
		if (error == 5) {
			alert("비밀번호를 다시 입력해주세요.");
		}

		$("#joinBtn").click(function() {
			$("#joinForm").attr({
				"method" : "post",
				"action" : "./doJoin"
			}).submit();
		});

	});
</script>
<title>네이버 : 로그인</title>
</head>
<body>

	<!-- 중앙 -->
	<div id="wrapper2">
		<div id="home_margin2">
			<a href="./login"><img style="height: 55%; width: 55%;" src="/Naver/img/naver.png" /></a>
		</div>
		<!-- 정보 입력란 -->
		<form id="joinForm">
			<div style="border: 1px solid #dadada; margin-bottom: 10px;">
				<div style="padding-bottom: 5px; background: white;">
					<div>
						<input id="id" name="id" class="input3" type="text"
							placeholder="&nbsp;&nbsp;아이디" />
					</div>
					<div style="text-align: left; font-size: 10px; color: red">&nbsp;&nbsp;필수
						정보 입니다.</div>
				</div>
				<div class="join_input">
					<div>
						<input id="password1" name="password1" class="input3" type="text"
							placeholder="&nbsp;&nbsp;비밀번호" />
					</div>
					<div style="text-align: left; font-size: 10px; color: red">&nbsp;&nbsp;필수
						정보 입니다.</div>
				</div>
				<div class="join_input">
					<div>
						<input id="password2" name="password2" class="input3" type="text"
							placeholder="&nbsp;&nbsp;비밀번호 재확인" />
					</div>
					<div style="text-align: left; font-size: 10px; color: red">&nbsp;&nbsp;필수
						정보 입니다.</div>
				</div>
			</div>

			<div style="border: 1px solid #dadada">
				<div style="padding-bottom: 5px; background: white;">
					<div>
						<input id="name" name="name" class="input3" type="text"
							placeholder="&nbsp;&nbsp;이름" />
					</div>
					<div style="text-align: left; font-size: 10px; color: red">&nbsp;&nbsp;필수
						정보 입니다.</div>
				</div>
			</div>

			<div>
				<input id="joinBtn" type="button" value="가입하기" />
			</div>
		</form>
		<!-- 기타목록 -->
		<div style="margin-bottom: 10px;">
			<div class="block">이용약관</div>
			&nbsp;&nbsp;|&nbsp;
			<div class="block">개인정보취급방침</div>
			&nbsp;&nbsp;|&nbsp;
			<div class="block">책임의 한계와 법적고지</div>
			&nbsp;&nbsp;|&nbsp;
			<div class="block">회원정보 고객센터</div>
		</div>
		<div style="font-size: 9px;">
			<div class="block">
				<img style="vertical-align: middle; height: 16%; width: 16%;"
					src="/Naver/img/naver.png" /> Copyright ⓒ <span
					style="font-weight: bold;">NAVER Corp.</span> All Rights Reserved.
			</div>
		</div>
	</div>
</body>
</html>