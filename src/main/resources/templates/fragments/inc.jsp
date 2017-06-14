<html>
<body>
	<div th:fragment="header">
		header fragment
	</div>
	<div th:fragment="resources" th:remove="tag">
		<script th:src="@{/js/node_modules/jquery/dist/jquery.slim.min.js}"></script>
		<script th:src="@{/bootstrap-custom-960gs/js/bootstrap.min.js}"></script>
		<link rel="stylesheet" th:href="@{/bootstrap-custom-960gs/css/bootstrap.min.css}"/>
		<link rel="stylesheet" th:href="@{/bootstrap-custom-960gs/css/bootstrap-theme.css}"/>
		<link rel="stylesheet" th:href="@{/css/common.css}"/>
		<script th:src="@{/js/common.js}"></script>
	</div>
</body>
</html>