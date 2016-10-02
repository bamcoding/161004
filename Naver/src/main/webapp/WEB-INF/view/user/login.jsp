<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/Naver/css/layout.css">
<script type="text/javascript" src="/Naver/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var error ="${error}";
		if(error == 1){
			alert("서버에 문제가 발생했습니다.");
		}
		if(error == 2){
			alert("아이디를 입력해주세요.");
		}
		if(error == 3){
			alert("비밀번호를 입력해주세요.");
		}
		if(error == 4){
			alert("존재하지 않는 아이디입니다.");
		}
		
		$("#loginBtn").click(function(){
			$("#loginForm").attr({"method":"post","action":"./doLogin"}).submit();			
		});
		
	});
</script>
<title>네이버 : 로그인</title>
</head>
<body>
	<div id="wrapper1">

		<select
			style="font-size: 10px; width: 80px; height: 20px; float: right; float: right;">
			<option>한국어</option>
			<option>English</option>
		</select>
		<div style="clear: right;"></div>

		<!-- 중앙 -->
		<div id="wrapper2">
			<div id="home_margin">
				<a href="http://www.naver.com"><img id="home" src="/Naver/img/naver.png" /></a>
			</div>
			<div id="align_right">단체 아이디 로그인 방법</div>
			<div style="clear: right;"></div>
			<!-- 입력 부분 -->
			<form id="loginForm">
				<div class="input">
					<input id="id" name="id" class="input2" type="text"
						placeholder="&nbsp;&nbsp;아이디" />
				</div>
				<div class="input">
					<input id="password" name="password" class="input2" type="text"
						placeholder="&nbsp;&nbsp;비밀번호" />
				</div>
				<div>
					<input id="loginBtn" type="button" value="로그인" />
				</div>
			</form>
			<!-- 로그인 상태유지 행 -->
			<div>
				<div class="block" style="float: left; margin-bottom: 25px;">로그인
					상태 유지</div>
				<div style="float: right;">
					<div class="block">IP보안 ON</div>
					&nbsp;|
					<div class="block">일회용 로그인</div>
				</div>
				<div style="clear: both;"></div>
			</div>
			<div style="border-bottom: 1px solid #cccccc; margin-bottom: 10px;"></div>
			<!-- 아이디 찾기 행 -->
			<div style="color: #999999; margin-bottom: 40px;">
				<div class="block"><a href="./join">아이디 찾기</a></div>
				&nbsp;&nbsp;|&nbsp;
				<div class="block"><a href="./join">비밀번호 찾기</a></div>
				&nbsp;&nbsp;|&nbsp;
				<div class="block"><a href="./join">회원가입</a></div>
			</div>
			<div style="margin-bottom: 20px;">
				<a href="http://distribute.tistory.com"><img style="width: 100%; height: 100%;"
					src="/Naver/img/login_ad.PNG" /></a>
			</div>
			<!-- 광고 아래 나머지 -->
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
					<img id="small_home" src="/Naver/img/naver.png" /> Copyright ⓒ <span
						style="font-weight: bold;">NAVER Corp.</span> All Rights Reserved.
				</div>
			</div>
		</div>
	</div>
</body>
</html>