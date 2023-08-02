



<%@ include file="common/header.jspf"%>
<div class="container">
	<%@ include file="common/navigation.jspf"%>
	<h2>${errorMessage}</h2>
	<div class="w-100 h-100">
		<myForm:form method="post" modelAttribute="todo"
			class="border border-1 p-3 rounded ">
			<div class="row mb-3">
				<div class="col-sm-10">
					<label for="description" class="col-sm-2 col-form-label">Description</label>
					<myForm:input type="text" path="description" name="description"
						required="required" class="form-control d-inline-block"
						id="description" />
					<myForm:errors path="description" cssClass="text-danger" />

					<label for="targetDate" class="col-sm-2 col-form-label">Target
						Date: </label>
					<myForm:input type="text" path="targetDate" name="targetDate"
						required="required" class="form-control" id="targetDate" />
					<myForm:errors path="targetDate" cssClass="text-danger" />

					<label for="done" class="col-sm-2 col-form-label">Is Done:
					</label>
					<myForm:input type="text" path="done" name="done"
						required="required" class="form-control" id="done" />
					<myForm:errors path="done" cssClass="text-danger" />
				</div>
			</div>
			<div class=" d-grid">
				<button class=" btn btn-primary">Add</button>
			</div>
		</myForm:form>
	</div>
</div>
<%@ include file="common/footer.jspf"%>