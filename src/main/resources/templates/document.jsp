<html>
<head>
	<div th:replace="fragments/inc :: resources"></div>
</head>
<body>
	<div th:replace="fragments/inc :: header"></div>
	<form action="#" th:action="@{/document/search}" method="GET">
		<input name="search_query" type="text" />
		<input name="submit" id="submit" type="submit" value="submit"/>
	</form>
	<h1 th:text="${title}" />
	<a th:href="@{edit/} + ${title}"><span>edit this document!</span></a>
	<p th:text="${content}"/>
</body>
</html>