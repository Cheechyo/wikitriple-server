<html lang="kr">
<head>
	<title>WikiWikiWiki : <span th:text="${title}" th:remove="tag"/></title>
	<div th:replace="fragments/inc :: resources_head"></div>
</head>
<body>
	<div class="container">
		<div th:replace="fragments/inc :: header"></div>
		<div class="content">
			<h1 id="document_title" th:text="| @  | + ${title} + | (| + ${version}+ |)|" />
			<hr/>
			<div th:replace="fragments/inc :: toolkit"></div>
			<p id="document" th:text="${content}"/>
		</div>
		<footer th:replace="fragments/inc :: footer"/>
	</div>
	<div th:replace="fragments/inc :: resources_lazy"></div>	
	<script>
$(document).ready(function(){
	$('#document').html(markdown.toHTML($('#document').text()));
});
	</script>
</body>
</html>