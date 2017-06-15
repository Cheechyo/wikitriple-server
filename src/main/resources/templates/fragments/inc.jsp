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
		<nav>
			<ul class="nav nav-pills pull-right" style="margin: 10px;">
				<!-- <li role="presentation" class="active"><a th:href="@{/document/index}">Home</a></li> -->
				<li role="presentation">
					<a th:if="${user}" th:text="|사용자 : | + ${user.username} + |.|" id="user_tag" class="text-center">username</a>
					<a th:unless="${user}" href="#login" onclick="$('#login_modal').modal('show');">login</a>
				</li>
			</ul>
		</nav>
		<h3 class="text-muted"><a th:href="@{/document/index}">(Wiki)wikiwiki</a></h3>
		<form action="#" th:action="@{/document/search}" method="GET" class="form-horizontal">
			<div class="form-group container_12">
				<input name="search_query" type="text" placeholder="search" class="form-control grid_12" aria-describedby="basic-search_query_addon" />
				<!-- <button type="submit" class="btn btn-default">Go</button> -->
			</div>
		</form>
		<script th:inline="javascript">
			$(document).ready(function(){$("input[name=search_query]").focus();});
			$("#user_tag").on("mouseenter", function(e){
				e.target._origintext = $(e.target).text();
				e.target._originwidth = $(e.target).width();
				$(e.target).html("logout");
				$(e.target).width(e.target._originwidth);
				$(e.target).on("click", function(){
					/*[+
					window.location.replace([[@{/logout}]]);
					+]*/
				});
			}).on("mouseout", function(e){
				$(e.target).off("click");
				$(e.target).text(e.target._origintext);
			});
		</script>
	</div>
	<div th:fragment="toolkit" class="toolkit pull-right well well-sm">
		<ul>
			<li><a th:href="@{edit/} + ${title}">Edit this document</a></li>
			<li><a th:href="@{history/} + ${title}">History</a></li>
		</ul>
	</div>
	<footer th:fragment="footer" class="footer"><p>&copy; 2017 Cheechyo, kwj9211 -at- gmail -dot- com</p></footer>
	<form th:fragment="login_modal" id="login_modal" class="modal fade" tabindex="-1" role="dialog" th:action="@{/login}" method="POST">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4>Login</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="username">Username</label>
						<input type="text" class="form-control" name="username" placeholder="username"/>
					</div>
					<div class="form-group">
						<label for="password">Password</label>
						<input type="password" class="form-control" name="password" placeholder="password"/>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">OK</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>