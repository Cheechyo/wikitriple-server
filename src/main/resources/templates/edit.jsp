<html>
<head>
	<title>edit : <span th:text="${title}" th:remove="tag"/></title>
	<div th:replace="fragments/inc :: resources_head"></div>
</head>
<body>
	<div class="container">
		<div th:replace="fragments/inc :: header"></div>
		<h1 th:text="|edit  : | + ${title}" />
		<form action="#" th:action="@{/document/save}" method="POST">
			<input name="title" type="hidden" th:value="${title}"/>
			<textarea name="content" cols="100" rows="30" th:text="${content}"/>
			<input name="submit" id="submit" type="submit" value="submit"/>
		</form>
		<footer th:replace="fragments/inc :: footer"/>
	</div>
	<div th:replace="fragments/inc :: resources_lazy"></div>
</body>
</html>