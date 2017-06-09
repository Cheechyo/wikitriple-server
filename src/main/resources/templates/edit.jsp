<html>
<body>
	<div>
		<h1 th:text="${title}" />
        <textarea name="content" id="content" cols="30" rows="10" th:value="${content}"></textarea>
	</div>
</body>
</html>