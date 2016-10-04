<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<<jsp:include page="/WEB-INF/view/common/haeder.jsp"></jsp:include>

<script type="text/javascript">
	$(document).ready(function() {
		$("#deleteBtn").click(function() {
			if(confirm("\"${articles.articleSubject }\"를 삭제하시겠습니까?")) {
			}
		});
		
		$("#recommandBtn").click(function(){
			$.post("/Board/board/recommand",
					{ "id":"${articles.articleId}" }, function(data){
				
				if(data == "true"){
					var count = parseInt($("#recommand").text());
					$("#recommand").text(count+1);
				}
				
			});
		});
	});
</script>

		<div id="article">
			<div id="articleHeader">
				<p>${articles.articleSubject }</p>
				<div id="articleInfo">
					<span>${articles.userVO.userNickname }</span>
					<span>${articles.createdDate }</span>
					<span><img src="/Board/img/eye-icon.png" />	${articles.hitCount }</span>
					<span id="recommand">${articles.recommendCount }</span>
				</div>
				<div id="attachedFile">
					<span><img src="/Board/img/text-file-3-xxl.png" /><a href="./download?articleId=${articles.articleId }">
					${articles.fileName }</a></span>
				</div>
			</div>
			<hr/>
			<div id="articleBody">
				${articles.articleContent}
			</div>
		</div>
		<div id="articleFooter">
		<c:if test="${article.userId eq sessionScope._UDER_INFO_.userId }">
			<a href="javascript:void(0);" id="deleteBtn">삭제</a>
			<a href="/Board/board/modify">수정</a>
			<a href="/Board/board/list">목록보기</a>
			<a href="javascript:void(0);" id="recommandBtn">추천하기</a>
		</c:if>
		</div>
	</div>
</body>
</html>