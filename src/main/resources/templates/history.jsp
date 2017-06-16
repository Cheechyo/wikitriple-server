<html lang="kr">
<head>
	<title>Wx3 History of <span th:text="${title}" th:remove="tag"/></title>
	<div th:replace="fragments/inc :: resources_head"></div>
</head>
<body>
	<div class="container">
		<div th:replace="fragments/inc :: header"></div>
		<div class="content">
			<h1 id="document_title" th:text="| @  |r + ${title}" />
			<hr/>
			<ul th:each="document : ${revisions}">
				<li>
					<a th:text="${document.title} + | | + ${document.regDate} + | | + |(| + ${document.version} + |)|" th:href="@{/document/} + ${document.title} + |/| + ${document.version}"></a>
					<span th:if="${document.regUser}" th:text="|by | + ${document.regUser.username}"></span>
				</li>
			</ul>
		</div>
		<footer th:replace="fragments/inc :: footer"/>
	</div>
	<div th:replace="fragments/inc :: resources_lazy"></div>

	<script>
$(document).ready(function(){$('#document').html(markdown.toHTML($('#document').text()));});
	</script>
</body>
</html>