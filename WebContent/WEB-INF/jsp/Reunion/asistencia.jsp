<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
	<title>Reuniones</title>
	<jsp:include page="../layout/header.jsp" />
	
</head>

<body>
    <jsp:include page="../layout/nav.jsp" />

    <!-- Main jumbotron for a primary marketing message or call to action -->

    <div class="container">
        <br>
        <h1>${reunion.grupo.nombre}</h1>
        <h3>${reunion.comunidad.nombre} - ${reunion.fechaFormateada()}</h3>
        <br>
        <!-- Example row of columns -->
        <div class="row justify-content-center">
            <div class="col-md-9 col sm-12">

                <span class="text-danger">${error}</span>
                <span class="text-success">${success}</span>

                <form action="search" method="post">
                    <input name="new" type="hidden" id="search">

                    <div class="input-group mb-3">
                    	<input name="reunionId" value="${reunion.reunionId}" type="hidden"/>
                        <input name="search" value="${search}" type="text" class="form-control" placeholder="Cedula, Nombre o Apellidos">
                        <div class="input-group-append">
                            <button class="btn btn-outline-secondary" type="submit">Buscar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        
        <hr/>
        
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
                        <c:forEach var="miembro" items="${miembros}">
                            <tr>
                                <th scope="row">${miembro.cedula}</th>
                                <td>${miembro.nombre}</td>
                                <td>${miembro.apellido}</td>
                                <td>${miembro.sexo}</td>
                                <td>
                                    <a href="?add=${miembro.cedula}" class="btn btn-success">Anadir</a>
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