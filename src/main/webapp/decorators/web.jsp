<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link
	href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet" />
<link href="<c:url value='/template/web/css/shop-homepage.css'/>"
	rel="stylesheet" />


</head>
<body>

	<!-- Header -->
	<%@ include file="/common/web/header.jsp"%>

	<!-- Page Content -->
	<dec:body />
	<!-- /.container -->
	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>



	<!-- Bootstrap core JavaScript -->
	<!-- Custom styles for this template -->
	<script type="text/javascript"
		src="<c:url value='/template/web/vendor/jquery/jquery.min.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>
	<script type="text/javascript"
			src="<c:url value="/template/paging/jquery.twbsPagination.js"/>"></script>
	<script type="text/javascript"
			src="<c:url value="/template/paging/Gruntfile.js"/> "></script>

</body>
</html>