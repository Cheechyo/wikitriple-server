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
	<div th:fragment="header" th:remove="tag">
		<div th:if="${user}" th:remove="tag">
			<nav th:replace="fragments/header :: topmenu_withuser"></nav>
			<div th:replace="fragments/header :: title_and_searchbar"></div>
		</div>
		<div th:unless="${user}" th:remove="tag">
			<nav th:replace="fragments/header :: topmenu_withoutuser"></nav>
			<div th:replace="fragments/header :: title_and_searchbar"></div>
		</div>
	</div>
	<div th:fragment="toolkit" class="toolkit pull-right well well-sm">
		<ul>
			<li><a th:href="@{/document/edit/} + ${title}">Edit this document</a></li>
			<li><a th:href="@{/document/history/} + ${title}">History</a></li>
		</ul>
	</div>
	<footer th:fragment="footer" class="footer"><p>&copy; 2017 Cheechyo, kwj9211 -at- gmail -dot- com</p></footer>
	
</body>
</html>