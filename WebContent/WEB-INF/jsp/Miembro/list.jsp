<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>

    <!-- JQUERY -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>

    <!-- BOOTSTRAP -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>



    <!--===========================================================================
    END GLOBAL_INCLUDES FILE
============================================================================-->
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Scrum en Victoria</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>

            </ul>
        </div>
    </nav>

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

        <hr>

        <footer>
            <p>&copy; 2018 Guess, Inc.</p>
        </footer>
    </div>
    <!-- /container -->
</body>

</html>