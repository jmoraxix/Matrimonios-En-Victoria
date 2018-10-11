<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page='./taglibs.jsp'/>
<html>
<head>
<meta charset="UTF-8">
<%String title = request.getParameter("title");%>
<title><%= title %></title>
<!--===========================================================================
    GLOBAL_INCLUDES FILE
============================================================================-->
<spring:url value="/resources" var="resources" />
<!-- JQUERY -->
<script type="text/javascript" src="${resources}/js/commons/jquery-3.1.1.js"></script>

<!-- BOOTSTRAP -->
<script type="text/javascript"
	src="${resources}/js/commons/bootstrap/bootstrap.min.js"></script>

<!-- DATATABLES -->
<script type="text/javascript"
	src="${resources}/js/commons/datatables/dataTables.bootstrap.min.js"></script>
<script type="text/javascript"
	src="${resources}/js/commons/datatables/jquery.dataTables.min.js"></script>

<!-- <script type="text/javascript" src="${resources}/js/commons/datatables/dataTables.tableTools.js"></script>  -->

<!--  LOCAC - JS -->
<!-- <script type="text/javascript" src="${resources}/js/general.js"></script> -->

<!-- CSS - BOOTSTRAP -->
<link rel="stylesheet" href="${resources}/css/commons/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="${resources}/css/commons/bootstrap/jumbotron.css" />

<!-- CSS - DATATABLES -->
<link rel="stylesheet" href="${resources}/css/commons/datatables/jquery.dataTables.css" />
<link rel="stylesheet" href="${resources}/css/commons/datatables/jquery.dataTables_themeroller.css" />
	
<!-- CSS - GENERAL -->
	
	
<!--===========================================================================
    END GLOBAL_INCLUDES FILE
============================================================================-->
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Matrimonios En Victoria</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<form class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" placeholder="Email" class="form-control">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" class="form-control">
					</div>
					<button type="submit" class="btn btn-success">Sign in</button>
				</form>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>