<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">
		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				<div class="panel-body">
					<!-- Form elements -->
					<form:form class="form-horizontal"
						action="${contextRoot}/manage/products" modelAttribute="product"
						method="POST" enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Product
								Name: </label>
							<div class="col-md-8">
								<form:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<form:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Brand
								Name: </label>
							<div class="col-md-8">
								<form:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<form:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="description">Description:
							</label>
							<div class="col-md-8">
								<form:textarea path="description" id="description" rows="4"
									placeholder="Write a description" class="form-control" />
								<form:errors path="description" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Unit
								Price: </label>
							<div class="col-md-8">
								<form:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Unit Price" class="form-control" />
								<form:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Quantity
								Available: </label>
							<div class="col-md-8">
								<form:input type="number" path="quantity" id="quantity"
									placeholder="Quantity" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select
								Image: </label>
							<div class="col-md-8">
								<form:input type="file" path="file" id="file"
									class="form-control" />
								<form:errors path="file" cssClass="help-block" element="em"></form:errors>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								Category: </label>
							<div class="col-md-8">
								<form:select class="form-control" id="categoryId"
									path="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="brand" value="Submit"
									class="btn btn-primary" />
								<form:hidden path="id" />
								<form:hidden path="code" />
								<form:hidden path="supplierId" />
								<form:hidden path="purchases" />
								<form:hidden path="views" />
								<form:hidden path="isActive" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-12">
			<h3>Available Products</h3>
			<hr>
		</div>
		<div class="col-xs-12">
			<div style="overflow: auto">
				<table id="adminProductsTable" class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</div>