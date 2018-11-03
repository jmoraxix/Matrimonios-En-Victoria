<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>Miembros</title>
<jsp:include page="../layout/header.jsp" />

</head>

<body>

    <jsp:include page="../layout/nav.jsp" />

    <!-- Main jumbotron for a primary marketing message or call to action -->

    <div class="container">
        <br>
        <h1>Miembros</h1>
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
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="miembro" items="${miembros}">
                            <tr>
                                <th scope="row">${miembro.cedula}</th>
                                <td>${miembro.nombre}</td>
                                <td>${miembro.apellido}</td>
                                <td>${miembro.sexo}</td>
                                <td>
                                    <a href="edit/${miembro.cedula}" class="btn btn-warning">Editar</a>
                                </td>
                                <td>
                                    <a href="delete/${miembro.cedula}" class="btn btn-danger">Eliminar</a>
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