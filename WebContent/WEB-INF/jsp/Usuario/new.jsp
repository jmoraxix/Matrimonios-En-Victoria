<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
<title>Nuevo Usuario</title>
<jsp:include page="../layout/header.jsp" />

</head>

<body>
    <jsp:include page="../layout/nav.jsp" />

    <!-- Main jumbotron for a primary marketing message or call to action -->

    <div class="container">
        <br>
        <h1>Nuevo Usuario</h1>
        <br>
        <!-- Example row of columns -->
        <div class="row justify-content-center">
            <div class="col-md-9 col sm-12">
                <form:form method="post" servletRelativeAction="/usuario/new" modelAttribute="usuario">
                        <input name="edit" type="hidden" id="edit">
                		<div><span class="text-danger">${error}</span><div>
                		<div><span class="text-success">${success}</span><div>
                		<form:input type="hidden" path="upgrade"/>
                		
                        <div class="form-group">
                            <label for="cedula">Cedula</label>
                        	<form:input type="number" path="cedula" min="1" max="9999999999" required="required" class="form-control" id="cedula" placeholder="Cedula"/>
                        </div>
                        <div class="form-group">
                            <label for="password">Contraseña</label>
                            <form:input type="password" path="contrasena" required="required" class="form-control" id="contrasena" placeholder="Contraseña"/>
                        </div>
                        <div class="form-group">
                            <label for="password">Confirmar Contraseña</label>
                            <form:input type="password" path="confirmarContrasena" required="required" class="form-control" id="contrasena" placeholder="Confirmar Contraseña"/>
						</div>
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <form:input type="text" path="nombre" required="required" class="form-control" id="nombre" placeholder="Nombre"/>
                        </div>
                        <div class="form-group">
                            <label for="apellidoUno">Apellido</label>
                            <form:input type="text" path="apellido" required="required" class="form-control" id="apellido" placeholder="Apellido"/>
                        </div>
   
                        <div class="form-group">
                            <label for="fechaNacimientoString">Fecha de Nacimiento</label>
                            <form:input type="date" path="fechaNacimiento" required="required" class="form-control" />
                        </div>
                        
                        <div class="form-check">
						  <form:radiobutton path="sexo" value="m" />
						  <label class="form-check-label" for="rdioMasculino">
						    Masculino
						  </label>
						</div>
						<div class="form-check">
						<form:radiobutton path="sexo" value="f" />
						  <label class="form-check-label" for="rdioFemenino">
						    Femenino
						  </label>
						</div>
                        
                        <div class="form-group">
                            <label for="exampleInputEmail1">Detalle de Direccion</label>
                            <form:textarea path="detalleDireccion" required="required" class="form-control" name="detalleDireccion" cols="30" rows="5" item-width="100%"/>
                        </div>
                        <button type="submit" class="btn btn-primary">Guardar</button>
        
                </form:form>
            </div>
        </div>

		<jsp:include page="../layout/footer.jsp" />
    </div>
    <!-- /container -->
</body>

</html>