<html>
<body>
	<form action="#" th:action="@{/document/search}" method="GET">
		<input name="search_query" type="text" th:value=""/>
		<input name="submit" id="submit" type="submit" value="submit"/>
	</form>
	<h1 th:text="${title}" />
</body>
</html>