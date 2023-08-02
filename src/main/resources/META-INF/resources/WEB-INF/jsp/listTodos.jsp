
<%@ include file="common/header.jspf"%>
<div class="container">
	<%@ include file="common/navigation.jspf"%>
	<form method="post" action="login">
		<h2>${username1}</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th colspan="6">
						<h3 class="pb-1">Your Todo List</h3>
					</th>
				</tr>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Done?</th>
					<th></th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td>
						<a href="delete-todo?id=${todo.id}"
							class="btn btn-warning me-2"> Delete ${todo.id} </a>
							<a href="update-todo?id=${todo.id}" class="btn btn-success">
								Update ${todo.id}</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	<a href="add-todo"> Add Todo</a>
</div>
<%@ include file="common/footer.jspf"%>