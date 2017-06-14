<html>
<head>
	<title>WikiWikiWiki : <span th:text="${title}" th:remove="tag"/></title>
	<div th:replace="fragments/inc :: resources_head"></div>
</head>
<body>
	<div class="container">
		<div th:replace="fragments/inc :: header"></div>
		<h1 th:text="${title}" />
		<a th:href="@{edit/} + ${title}"><span>edit this document!</span></a>
		<p th:text="${content}"/>
		<footer th:replace="fragments/inc :: footer"/>
	</div>
	<div th:replace="fragments/inc :: resources_lazy"></div>
</body>
</html>