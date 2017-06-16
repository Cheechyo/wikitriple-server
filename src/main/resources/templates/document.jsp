<html lang="kr">
<head>
	<title>WikiWikiWiki : <span th:text="${title}" th:remove="tag"/></title>
	<div th:replace="fragments/inc :: resources_head"></div>
</head>
<body>
	<div class="container">
		<div th:replace="fragments/inc :: header"></div>
		<div class="content">
			<h1 id="document_title" th:text="| @  | + ${title}" />
			<hr/>
			<div th:replace="fragments/inc :: toolkit"></div>
			<p id="document" th:text="${content}"/>
			<div th:if="${recentDocuments}" th:remove="tag">
				<hr/>
				<h1>최근 작성되거나 수정된 문서</h1>
				<ul th:each="document : ${recentDocuments}" th:if="${recentDocuments}">
					<li>
						<a th:text="${document.title} + | | + ${document.regDate} + | | + |(| + ${document.version} + |)|" th:href="@{/document/} + ${document.title} + |/| + ${document.version}"></a>
						<span th:if="${document.regUser}" th:text="|by | + ${document.regUser.username}"></span>
					</li>
				</ul>
			</div>
		</div>
		<footer th:replace="fragments/inc :: footer"/>
	</div>
	<div th:replace="fragments/inc :: resources_lazy"></div>	
	<script>
$(document).ready(function(){
	$('#document').html(markdown.toHTML($('#document').text()));
});
	</script>
</body>
</html>