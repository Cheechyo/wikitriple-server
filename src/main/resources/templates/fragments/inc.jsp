<html>
<body>
	<div th:fragment="header">
		header fragment
	</div>
	<div th:fragment="resources" th:remove="tag">
		<script th:src="@{js/node_modules/jquery/dist/jquery.slim.min.js}"></script>
		<script th:src="@{js/node_modules/bootstrap/dist/js/bootstrap.min.js}"></script>
		<link rel="stylesheet" th:href="@{js/node_modules/bootstrap/dist/css/bootstrap.min.css}"/>
		<script th:src="@{js/common.js}"></script>
	</div>
</body>
</html>