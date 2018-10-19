<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>
<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
	console.log("Context Root: " + window.contextRoot);
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable Theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- DataTables Bootstrap -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/onlineshopping.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->
		<%@ include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<!-- Loading home content -->
			<c:if test="${userClickHome == true}">
				<%@ include file="home.jsp"%>
			</c:if>

			<!-- Load only when user clicks about -->
			<c:if test="${userClickAbout == true}">
				<%@ include file="about.jsp"%>
			</c:if>

			<!-- Load only when user clicks contact -->
			<c:if test="${userClickContact == true}">
				<%@ include file="contact.jsp"%>
			</c:if>
			
			<!-- Load only when user clicks userClickAllProducts or userClickCategoryProducts -->
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@ include file="list-products.jsp"%>
			</c:if>
			
			<!-- userClickShowProduct -->
			<c:if test="${userClickShowProduct == true}">
				<%@ include file="single-product.jsp"%>
			</c:if>
			
			<!-- userClickManageProducts -->
			<c:if test="${userClickManageProducts == true}">
				<%@ include file="manage-products.jsp"%>
			</c:if>

		</div>

		<!-- Footer comes here -->
		<%@ include file="./shared/footer.jsp"%>

		<!-- /.container -->

		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>
		
		<!-- DataTable -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- DataTable Bootstrap JS -->
		<script src="${js}/dataTables.bootstrap.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		
		<script src="${js}/bootbox.min.js"></script>
		
		<script type="text/javascript" src="${js}/onlineshopping.js"></script>
		
	</div>

</body>

</html>
