

<%@ include file="common/header.jspf"%>
<div class="container">
	<%@ include file="common/navigation.jspf"%>
	<div style="padding: 200px">
		<h2>Welcome to page ${username}-${password}</h2>
		<hr />
		<h2></h2>
		<a href="list-todos"> Todo list</a>
	</div>
</div>
<%@ include file="common/footer.jspf"%>