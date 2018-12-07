<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
	<title>Usuarios</title>
	<jsp:include page="../layout/header.jsp" />
</head>

<body>
    <jsp:include page="../layout/nav.jsp" />

    <!-- Main jumbotron for a primary marketing message or call to action -->

    <div class="container">
        <br>
        <h1>Usuarios</h1>
        <br>
        <!-- Example row of columns -->
        <div class="row justify-content-center">
            <div class="col-md-9 col sm-12">

                <span class="text-danger">${error}</span>
                <span class="text-success">${success}</span>

                <form action="list" method="post">
                    <input name="new" type="hidden" id="search">

                    <div class="input-group mb-3">
                        <input name="search" value="${search}" type="text" class="form-control" placeholder="Cedula, Nombre o Apellidos">
                        <div class="input-group-append">
                            <button class="btn btn-outline-secondary" type="submit">Buscar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="table-responsive-sm">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Cédula</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellidos</th>
                            <th scope="col">Sexo</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="usuario" items="${usuarios}">
                            <tr>
                                <th scope="row">${usuario.cedula}</th>
                                <td>${usuario.miembro.nombre}</td>
                                <td>${usuario.miembro.apellido}</td>
                                <td>${usuario.miembro.sexo}</td>
                                <td>
                                    <a href="edit/${usuario.cedula}" class="btn btn-warning">Editar</a>
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
</body>

</html>