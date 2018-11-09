<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
	<title>Cantons</title>
	<jsp:include page="../layout/header.jsp" />
</head>

<body>
    <jsp:include page="../layout/nav.jsp" />

    <!-- Main jumbotron for a primary marketing message or call to action -->

    <div class="container">
        <br>
        <h1>Nuevo Canton</h1>
        <br>
        <!-- Example row of columns -->
        <div class="row justify-content-center">
            <div class="col-md-9 col sm-12">
            	<form:form method="post" servletRelativeAction="/canton/new" modelAttribute="cantonForm">
                		<div><span class="text-danger">${error}</span><div>
                		<div><span class="text-success">${success}</span><div>
                        <div class="input-group">
						  <div class="input-group-prepend">
						    <span class="input-group-text">País y Nombre</span>
						  </div>
						  <form:select path="provinciaId" class="form-control">
							  <form:option value="null" label="--- Provincia ---" />
							  <form:options items="${provincias}" itemLabel="nombre" itemValue="provinciaId" />
				       	  </form:select>
						  <form:input path="nombre" placeholder="Nombre" type="text" aria-label="Last name" class="form-control"/>
						</div>
                        <br/>
                        <button type="submit" class="btn btn-primary">Ingresar</button>
                </form:form>
            </div>
        </div>
        
        <hr/>
        <h4>Todos los Cantones<h4/>
        <div class="row justify-content-center">
            <div class="table-responsive-sm">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Provincia</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="canton" items="${cantones}">
                            <tr>
                                <th scope="row">${canton.cantonId}</th>
                                <td>${canton.nombre}</td>
                                <td>${canton.provincia.nombre}</td>
                                <!--
                                <td>
                                    <a href="delete/${canton.cantonId}" class="btn btn-danger">Eliminar</a>
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