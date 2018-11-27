<jsp:include page='../layout/taglibs.jsp'/>

<html>

<head>
	<title>Provincias</title>
	<jsp:include page="../layout/header.jsp" />
</head>

<body>
    <jsp:include page="../layout/nav.jsp" />

    <!-- Main jumbotron for a primary marketing message or call to action -->

    <div class="container">
        <br>
        <h1>Nueva Provincia</h1>
        <br>
        <!-- Example row of columns -->
        <div class="row justify-content-center">
            <div class="col-md-9 col sm-12">
            	<form:form method="post" servletRelativeAction="/provincia/new" modelAttribute="provincia">
                		<div><span class="text-danger">${error}</span><div>
                		<div><span class="text-success">${success}</span><div>
                        <spring:bind path="provincia.nombre">
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <form:input type="text" path="nombre" id="nombre" required="" class="form-control"  placeholder="Nombre"/>
                        </div>
                        
                        <button type="submit" class="btn btn-primary">Ingresar</button>
                </form:form>
            </div>
        </div>
        
        <hr/>
        <h4>Todas las Provincias<h4/>
        <div class="row justify-content-center">
            <div class="table-responsive-sm">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nombre</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="provincia" items="${provincias}">
                            <tr>
                                <th scope="row">${provincia.provinciaId}</th>
                                <td>${provincia.nombre}</td>
                                <!--
                                <td>
                                    <a href="delete/${provincia.provinciaId}" class="btn btn-danger">Eliminar</a>
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