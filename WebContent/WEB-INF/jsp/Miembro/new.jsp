<jsp:include page='../layout/taglibs.jsp'/>

<html>

<head>
	<title>Nuevo Miembro</title>
	<jsp:include page="../layout/header.jsp" />
</head>

<body>
    <jsp:include page="../layout/nav.jsp" />


    <div class="container">
        <br>
        <h1>Nuevo Miembro</h1>
        <br>
        <div class="row justify-content-center">
            <div class="col-md-9 col sm-12">
                <form action="new" method="post">
                        <input name="new" type="hidden" id="new">
                		<div><span class="text-danger">${error}</span><div>
                		<div><span class="text-success">${success}</span><div>
                        <div class="form-group">
                            <label for="cedula">Cedula</label>
                            <input min="1" max="9999999999" required name="cedula" type="number" class="form-control" id="cedula" placeholder="Cedula">
                        </div>
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input required name="nombre" type="text" class="form-control" id="nombre" placeholder="Nombre">
                        </div>
                        <div class="form-group">
                            <label for="apellidoUno">Apellido</label>
                            <input required name="apellido" type="text" class="form-control" id="apellido" placeholder="Apellido">
                        </div>
   
                        <div class="form-group">
                            <label for="exampleInputEmail1">Fecha de Nacimiento</label>
                            <input required name="fechaNacimientoString" type="date" class="form-control" id="fechaNacimientoString" placeholder="Fecha de Nacimiento">
                        </div>
                        
                        <div class="form-check">
						  <input class="form-check-input" type="radio" name="sexo" id="rdioMasculino" value="m" checked>
						  <label class="form-check-label" for="rdioMasculino">
						    Masculino
						  </label>
						</div>
						<div class="form-check">
						  <input class="form-check-input" type="radio" name="sexo" id="rdioFemenino" value="f">
						  <label class="form-check-label" for="rdioFemenino">
						    Femenino
						  </label>
						</div>
                        
                        <div class="form-group">
                            <label for="exampleInputEmail1">Detalle de Direccion</label>
                            <textarea required name="detalleDireccion" class="form-control" name="detalleDireccion" cols="30" rows="5" item-width="100%"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Crear</button>
        
                </form>
            </div>
        </div>
        
	<jsp:include page="../layout/footer.jsp" />
	
    </div>
    
</body>

</html>