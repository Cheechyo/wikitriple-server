<html>
<body>
	<div>
		<h1 th:text="${title}" />
		<a th:href="@{edit/} + ${title}"><span>edit this document!</span></a>
		<p th:text="${content}"/>
	</div>
</body>
</html>