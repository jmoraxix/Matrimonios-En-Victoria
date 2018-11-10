<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
	<title>Comunidades</title>
	<jsp:include page="../layout/header.jsp" />
</head>

<body>
    <jsp:include page="../layout/nav.jsp" />

    <!-- Main jumbotron for a primary marketing message or call to action -->

    <div class="container">
        <br>
        <h1>Nueva Comunidad</h1>
        <br>
        <!-- Example row of columns -->
        <div class="row justify-content-center">
            <div class="col-md-9 col sm-12">
            	<form:form method="post" servletRelativeAction="/comunidad/new" modelAttribute="comunidadForm">
                		<div><span class="text-danger">${error}</span><div>
                		<div><span class="text-success">${success}</span><div>
                        <div class="input-group">
						  <div class="input-group-prepend">
						    <span class="input-group-text">Distrito y Nombre</span>
						  </div>
						  <form:select path="distritoId" class="form-control">
							  <form:option value="null" label="--- Distrito ---" />
							  <form:options items="${distritos}" itemLabel="nombre" itemValue="distritoId" />
				       	  </form:select>
						  <form:input path="nombre" placeholder="Nombre" type="text" aria-label="Last name" class="form-control"/>
						</div>
						<div class="form-group">
                            <label>Detalle</label>
                            <form:textarea path="detalle" required="" class="form-control" cols="30" rows="5" item-width="100%"/>
                        </div>
                        <br/>
                        <button type="submit" class="btn btn-primary">Ingresar</button>
                </form:form>
            </div>
        </div>
        
        <hr/>
        <h4>Todas las Comunidades<h4/>
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
                        <c:forEach var="comunidad" items="${comunidades}">
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
</body>

</html>