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
        <h1>Nuevo Usuario</h1>
        <br>
        <!-- Example row of columns -->
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
                            <label for="password">Contraseña</label>
                            <input required name="password" type="password" class="form-control" id="password" aria-describedby="emailHelp" placeholder="Contraseña">
                        </div>
                        <div class="form-group">
                            <label for="password">Confirmar Contraseña</label>
                            <input required name="passwordConfirm" type="password" class="form-control" id="passwordConfirm" placeholder="Confirmar Contraseña">
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



        <hr>

        <footer>
            <p>&copy; 2018 Guess, Inc.</p>
        </footer>
    </div>
    <!-- /container -->
</body>

</html>