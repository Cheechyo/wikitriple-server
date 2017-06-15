<html>
<body>
	<nav th:fragment="topmenu_withuser">
		<ul class="nav nav-pills pull-right" style="margin: 10px;">
			<!-- <li role="presentation" class="active"><a th:href="@{/document/index}">Home</a></li> -->
			<li role="presentation" class="disabled">
				<a th:if="${user}" th:text="|안녕하세요, | + ${user.username} + | 님.|" id="user_tag" class="text-center">username</a>
			</li>
			<li role="presentation">
				<a  href="#login" onclick="$('#userinfo_modal').modal('show');">Info</a>
			</li>
			<li role="presentation">
				<a  href="#login" onclick="logout();">Logout</a>
			</li>
		</ul>
		<script th:inline="javascript">
			function logout(){
				/*[+
					window.location.replace([[@{/logout}]]);
				+]*/
			}
		</script>
		<form th:replace="fragments/header :: userinfo_modal"></form>
	</nav>
	<nav th:fragment="topmenu_withoutuser">
		<ul class="nav nav-pills pull-right" style="margin: 10px;">
			<!-- <li role="presentation" class="active"><a th:href="@{/document/index}">@</a></li> -->
			<li role="presentation">
				<a href="#login" onclick="$('#signup_modal').modal('show');">Sign up</a>
			</li>
			<li role="presentation">
				<a  href="#login" onclick="$('#login_modal').modal('show');">Login</a>
			</li>
		</ul>
		<form th:replace="fragments/header :: login_modal"></form>
		<form th:replace="fragments/header :: signup_modal"></form>
	</nav>
	<div th:fragment="title_and_searchbar" th:remove="tag">
		<h3 class="text-muted"><a th:href="@{/document/index}">(Wiki)wikiwiki</a></h3>
		<form action="#" th:action="@{/document/search}" method="GET" class="form-horizontal">
			<div class="form-group container_12">
				<input name="search_query" type="text" placeholder="search" class="form-control grid_12" aria-describedby="basic-search_query_addon" />
				<!-- <button type="submit" class="btn btn-default">Go</button> -->
			</div>
		</form>
		<script th:inline="javascript">
			$(document).ready(function(){$("input[name=search_query]").focus();});
		</script>
	</div>
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
	<form th:fragment="signup_modal" id="signup_modal" class="modal fade" tabindex="-1" role="dialog" th:action="@{/signup}" method="POST">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4>Sign up</h4>
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
	<form th:fragment="userinfo_modal" id="userinfo_modal" class="modal fade" tabindex="-1" role="dialog" th:action="@{/signup}" method="POST">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4>My info</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="username">Username</label>
						<input type="text" class="form-control" name="username" placeholder="username" th:value="${user.username}" readonly="true"/>
					</div>
					<div class="form-group">
						<label for="password">Password</label>
						<input type="password" class="form-control" name="password" placeholder="password" th:value="${user.password}" readonly="true" />
					</div>
				</div>
				<!-- <div class="modal-footer">
					<button type="submit" class="btn btn-primary">OK</button>
				</div> -->
			</div>
		</div>
	</form>
</body>
</html>