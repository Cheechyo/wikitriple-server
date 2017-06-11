<html>
<body>
	<h1 th:text="${title}" />
	<form action="#" th:action="@{/document/save}" method="POST">
		<input name="title" type="hidden" th:value="${title}"/>
		<textarea name="content" cols="100" rows="30" th:text="${content}"/>
		<input name="submit" id="submit" type="submit" value="submit"/>
	</form>
</body>
</html>