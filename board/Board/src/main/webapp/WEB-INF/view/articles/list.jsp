<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<jsp:include page="/WEB-INF/view/common/haeder.jsp"></jsp:include>
	
	
	<script type="text/javascript">
		$().ready(function(){
			$("#searchType").change(function(){
				//alert($(this).val()); // value가 나온다
				alert($("#searchType option:selected").text());//선택한 text
				
			});
		});
	
	</script>
	
	
	
	<c:if test="${not empty sessionScope._USER_INFO_ }">
	<div style="text-align: right;">
	${sessionScope._USER_INFO_.userNickname} | 로그아웃</div>
		<div id="list">
	</c:if>
	
	<c:if test="${empty sessionScope._USER_INFO_ }">
	<div style="text-align: right;">로그인</div>
	</c:if>
	
	<!-- sessionScope 세션에 접근할 수 있도록 해준다. 
		경우에 따라서 로그아웃, 로그인을 교체하도록 만든다.
		세션이 없으면 로그인 세션이 있으면 로그아웃-->
			<table class="grid">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
					<th>추천수</th>
				</tr>
				<c:forEach items="${articles}" var="article">
					<tr>
						<td>
						<c:set var="number" value="${fn:split(article.articleId,'-')[2]}"/>
						<fmt:parseNumber var = "number" type="number" value="${number }"/>
						${number }
						</td>
						<td><a href="/Board/board/detail?articleId=${article.articleId}">${article.articleSubject}</a></td>
						<td>${article.userVO.userNickname}</td>
						<td>${article.createdDate}</td>
						<td>${article.hitCount}</td>
						<td>${article.recommendCount}</td>
					</tr>
				</c:forEach>
			</table>
			<div style="padding-top: 5px;">
				<div class="left">
					<a href="/Board/board/write">글쓰기</a>
				</div>
				<div class="right">
					<form id="searchForm" name="searchForm">
						<select id="searchType" name="searchType">
							<option value="1">제목+내용</option>
							<option value="2">제목</option>
							<option value="3">내용</option>
							<option value="4">작성자</option>
						</select>
						<input type="text" id="searchKeyword" name="searchKeyword" />
						<input type="button" id="searchBtn" value="검색" />
					</form>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
</body>
</html>