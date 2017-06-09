<html>
<body>
	<div>
		<h1 th:text="${title}" />
		<textarea name="content" id="content" cols="100" rows="30" th:text="${content}"/>
		<input name="submit" id="submit" type="submit" value="submit"/>
	</div>
</body>
</html>