<%@ include file="../shared/flows-header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel panel-heading">
					<h4>Sign Up - Personal</h4>
				</div>
				<div class="panel-body">
					<form:form method="POST" modelAttribute="address" id="billingForm" class="form-horizontal">
						<div class="form-group">
							<label class="control-label col-md-4">Address Line One</label>
							<div class="col-md-8">
								<form:input path="addressLineOne" type="text" class="form-control" placeholder="Room No/Building, Apartment Name" />
								<form:errors path="addressLineOne" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Address Line Two</label>
							<div class="col-md-8">
								<form:input path="addressLineTwo" type="text" class="form-control" placeholder="Nearest Location, Town" />
								<form:errors path="addressLineTwo" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">City</label>
							<div class="col-md-8">
								<form:input path="city" type="text" class="form-control" placeholder="City" />
								<form:errors path="city" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Postal Code</label>
							<div class="col-md-8">
								<form:input path="postalCode" type="text" class="form-control" placeholder="Postal Code" />
								<form:errors path="postalCode" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">State</label>
							<div class="col-md-8">
								<form:input path="state" type="text" class="form-control" placeholder="State" />
								<form:errors path="state" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Country</label>
							<div class="col-md-8">
								<form:input path="country" type="text" class="form-control" placeholder="Country" />
								<form:errors path="country" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-offset-2">
								<button type="submit" class="btn btn-primary" name="_eventId_personal"><span class="glyphicon glyphicon-chevron-left"></span> Previous - Personal</button>
								<button type="submit" class="btn btn-primary" name="_eventId_confirm">Next - Confirm <span class="glyphicon glyphicon-chevron-right"></span></button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../shared/flows-footer.jsp"%>