<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
	<title>Reuniones</title>
	<jsp:include page="../layout/header.jsp" />
	
	<!--DATE TIME PICKER-->
	<link rel="stylesheet" href="/MatrimoniosEnVictoria/static/css/commons/datetimepicker/datetimepicker.min.css" />
	<script type="text/javascript" src="/MatrimoniosEnVictoria/static/js/commons/datetimepicker/datetimepicker.min.js"></script>
</head>

<body>
    <jsp:include page="../layout/nav.jsp" />

    <!-- Main jumbotron for a primary marketing message or call to action -->

    <div class="container">
        <br>
        <h1>Nueva Reunion</h1>
        <br>
        <!-- Example row of columns -->
        <div class="row justify-content-center">
            <div class="col-md-9 col sm-12">
            	<form:form method="post" servletRelativeAction="/comunidad/new" modelAttribute="reunionForm">
                		<div><span class="text-danger">${error}</span><div>
                		<div><span class="text-success">${success}</span><div>
                        <div class="input-group">
						  <div class="input-group-prepend">
						    <span class="input-group-text">Grupo</span>
						  </div>
						  <form:select path="grupoId" class="form-control">
							  <form:option value="null" label="--- Grupo ---" />
							  <form:options items="${grupos}" itemLabel="nombre" itemValue="grupoId" />
				       	  </form:select>
						</div>
						</br>
						<div class="input-group">
						  <div class="input-group-prepend">
						    <span class="input-group-text">Comunidad</span>
						  </div>
						  <form:select path="comunidadId" class="form-control">
							  <form:option value="null" label="--- Comunidad ---" />
							  <form:options items="${comunidades}" itemLabel="nombre" itemValue="comunidadId" />
				       	  </form:select>
						</div>
						<div class="form-group">
                            <label for="fechaString">Fecha</label>
                            <form:input id="fechaReunion" type="datetime" path="fechaString" required="required" class="form-control" />
                        </div>
						  
						</div>
                        <br/>
                        <button type="submit" class="btn btn-primary">Ingresar</button>
                </form:form>
            </div>
        </div>
        
        <hr/>
        <h4>Todas las Reuniones<h4/>
        <div class="row justify-content-center">
            <div class="table-responsive-sm">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Distrito</th>
                            <th scope="col">Canton</th>
                            <th scope="col">Provincia</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="comunidad" items="${reuniones}">
                            <tr>
                                <th scope="row">${comunidad.comunidadId}</th>
                                <td>${comunidad.nombre}</td>
                                <td>${comunidad.distrito.nombre}</td>
                                <td>${comunidad.distrito.canton.nombre}</td>
                                <td>${comunidad.distrito.canton.provincia.nombre}</td>
                                <!--
                                <td>
                                    <a href="delete/${comunidad.comunidadId}" class="btn btn-danger">Eliminar</a>
                                </td>
                                -->
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <jsp:include page="../layout/footer.jsp" />
    </div>
    <!-- /container -->
    <script type="text/javascript">
    $("#fechaReunion").datetimepicker({format: 'dd/mm/yyyy hh:ii'});
	</script>            
</body>

</html>