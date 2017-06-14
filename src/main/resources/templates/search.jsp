<html>
<head>
	<title>WikiWikiWiki : <span th:text="${title}" th:remove="tag"/></title>
	<div th:replace="fragments/inc :: resources_head"></div>
</head>
<body>
	<div class="container">
		<div th:replace="fragments/inc :: header"></div>
		<div class="content">
			<h1 th:text="${title}" />
			<a class="edit" th:href="@{edit/} + ${title}"><span>edit this document</span></a>
			<p th:text="${content}"/>
		</div>
		<footer th:replace="fragments/inc :: footer"/>
	</div>
	<div th:replace="fragments/inc :: resources_lazy"></div>
</body>
</html>