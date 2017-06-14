<html lang="kr">
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
			<div class="container_12">
				<textarea class="document_edit grid_6 well" name="content" cols="100" rows="30" oninput="this.editor.update()" th:text="${content}"/>
				<div id="document_preview" class="grid_6"></div>
			</div>
			<button name="submit" id="submit" type="submit" value="submit">OK!</button>
		</form>
		<footer th:replace="fragments/inc :: footer"/>
	</div>
	<div th:replace="fragments/inc :: resources_lazy"></div>
<script>
function Editor(input, preview) {
	this.update = function () {
		preview.innerHTML = markdown.toHTML(input.value);
	};
	input.editor = this;
	this.update();
}
</script>
	<script>
$(document).ready(function(){
	new Editor($("[name=content]")[0], $("#document_preview")[0]);	
});
	</script>
</body>
</html>