<html>
<body>
	<div th:fragment="header">
		header fragment
		<a th:href="@{edit/} + ${title}"><span>edit this document!</span></a>
	</div>
</body>
</html>