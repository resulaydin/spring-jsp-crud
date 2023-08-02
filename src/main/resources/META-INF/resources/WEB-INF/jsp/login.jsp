


<%@ include file="common/header.jspf"%>
<div class="container">
	<%@ include file="common/navigation.jspf"%>
	<div style="padding: 200px">
		<div class="card m-auto ">
			<div class="card-header text-center">
				<h2>Login Page</h2>
			</div>
			<div class="card-body">
				<form method="post" action="login" class="p-3 rounded">
					<div class="mb-3">
						<label for="username" class="form-label">Username</label> <input
							type="text" name="username" class="form-control">
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password</label> <input
							type="text" name="password" class="form-control">
					</div>
					<div class=" d-grid">
						<button class=" btn btn-primary">Gönder</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>