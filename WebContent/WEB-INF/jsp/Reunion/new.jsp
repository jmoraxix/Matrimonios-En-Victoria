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
            	<form:form method="post" servletRelativeAction="/reunion/new" modelAttribute="reunionForm">
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
                            <form:input autocomplete="off" id="fechaReunion" type="datetime" path="fechaString" required="required" class="form-control" />
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
                        	<th scope="col">#</th>
                            <th scope="col">Grupo</th>
                            <th scope="col">Comunidad</th>
                            <th scope="col">Fecha</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="reunion" items="${reuniones}">
                            <tr>
                                <th scope="row">${reunion.reunionId}</th>
                                <td>${reunion.grupo.nombre}</td>
                                <td>${reunion.comunidad.nombre}</td>
                                <td>${reunion.fechaFormateada()}</td>
                                
                                <td>
                                    <a href="asistencia/${reunion.reunionId}" class="btn btn-primary">Pasar Asistencia</a>
                                </td>
                              
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