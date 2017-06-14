<html>
<body>
	<div th:fragment="resources_head" th:remove="tag">
		<link rel="stylesheet" th:href="@{/css/960.css}"/>
		<link rel="stylesheet" th:href="@{/bootstrap-960/css/bootstrap.min.css}"/>
		<link rel="stylesheet" th:href="@{/bootstrap-960/css/bootstrap-theme.css}"/>
		<link rel="stylesheet" th:href="@{/css/common.css}"/>
		<script th:src="@{/js/node_modules/jquery/dist/jquery.slim.min.js}"></script>
		<script th:src="@{/bootstrap-960/js/bootstrap.min.js}"></script>
	</div>
	<div th:fragment="resources_lazy" th:remove="tag">
		<script th:src="@{/js/markdown-browser/markdown.min.js}"></script>
		<script th:src="@{/js/common.js}"></script>
	</div>
	<div th:fragment="header" class="header clearfix">
		<h3 class="text-muted"><a th:href="@{/document/index}">(Wiki)wikiwiki</a></h3>
		<form action="#" th:action="@{/document/search}" method="GET" class="form-horizontal">
			<div class="form-group container_12">
				<input name="search_query" type="text" placeholder="search" class="form-control grid_12" aria-describedby="basic-search_query_addon" />
				<!-- <button type="submit" class="btn btn-default">Go</button> -->
			</div>
		</form>
		<script>
			$(document).ready(function(){$("input[name=search_query]").focus();});
		</script>
	</div>
	<div th:fragment="toolkit" class="toolkit pull-right well well-sm">
		<ul>
			<li><a th:href="@{edit/} + ${title}">Edit this document</a></li>
			<li><a th:href="@{edit/} + ${title}">History</a></li>
		</ul>
	</div>
	<footer th:fragment="footer" class="footer"><p>&copy; 2017 Cheechyo, kwj9211 -at- gmail -dot- com</p></footer>
</body>
</html>