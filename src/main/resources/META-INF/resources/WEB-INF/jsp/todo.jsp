



<%@ include file="common/header.jspf"%>
<div class="container">
	<%@ include file="common/navigation.jspf"%>
	<h2>${errorMessage}</h2>
	<div class="w-100 h-100">
		<myForm:form method="post" modelAttribute="todo" class=" p-3 rounded ">
			<div class="row mb-3">
				<div class="col-sm-5">
					<fieldset>
						<label for="username" class="col-sm-2 col-form-label">Description</label>
						<myForm:input type="text" path="description" name="description"
							required="required" class="form-control" id="description" />
						<myForm:errors path="description" cssClass="text-danger" />
					</fieldset>
					<fieldset>
						<label for="targetDate" class="col-sm-2 col-form-label">Date:
						</label>
						<myForm:input type="date" path="targetDate" name="targetDate"
							required="required" class="form-control" id="targetDate" />
						<myForm:errors path="targetDate" cssClass="text-danger" />
					</fieldset>
					<fieldset>
						<label for="done" class="col-sm-2 col-form-label">Is Done:
						</label>
						<myForm:input type="text" path="done" name="done"
							required="required" class="form-control" id="description" />
						<myForm:errors path="done" cssClass="text-danger" />
					</fieldset>
					<myForm:input type="hidden" path="id" />
					<button class=" btn btn-primary mt-3">Submit</button>
				</div>
			</div>
		</myForm:form>
	</div>
</div>
<%@ include file="common/footer.jspf"%>