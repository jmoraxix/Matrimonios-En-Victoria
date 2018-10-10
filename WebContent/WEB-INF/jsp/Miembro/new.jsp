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
        <h1>Nuevo Miembro</h1>
        <br>
        <!-- Example row of columns -->
        <div class="row justify-content-center">
            <div class="col-md-9 col sm-12">
                <form action="new" method="post">
                    <form>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Cedula</label>
                            <input name="cedula" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Cedula">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Nombre</label>
                            <input name="nombre" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Cedula">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Apellido</label>
                            <input nombre="apellido" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Cedula">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Fecha de Nacimiento</label>
                            <input name="fechaNacimiento" type="date" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Cedula">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Detalle de Direccion</label>
                            <textarea name="detalleDireccion" class="form-control" name="detalleDireccion" cols="30" rows="5" item-width="100%"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
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