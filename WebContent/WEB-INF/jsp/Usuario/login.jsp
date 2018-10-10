
<html>
<head>
<title>Ingresar</title>
<!-- JQUERY -->
<script type="text/javascript" src="./js/commons/jquery-3.1.1.js"></script>

<!-- BOOTSTRAP -->
<script type="text/javascript" src= "./js/commons/bootstrap/bootstrap.min.js"></script>
		
<!-- DATATABLES -->		
<script type="text/javascript" src="./js/commons/datatables/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="./js/commons/datatables/jquery.dataTables.min.js"></script>

<!-- <script type="text/javascript" src="../js/commons/datatables/dataTables.tableTools.js"></script>  -->

<!--  LOCAC - JS -->
<!-- <script type="text/javascript" src="../js/general.js"></script> -->

<!-- CSS - GENERAL -->


<!-- CSS - BOOTSTRAP -->
<link rel="stylesheet" href="./css/commons/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="./css/commons/bootstrap/jumbotron.css" />


<!-- CSS - DATATABLES -->
<link rel="stylesheet" href="./css/commons/datatables/jquery.dataTables.css" />
<link rel="stylesheet" href="./css/commons/datatables/jquery.dataTables_themeroller.css" />

<!--===========================================================================
    END GLOBAL_INCLUDES FILE
============================================================================-->
</head>
<body class="bg-primary">

    <div class="container h-100" ">
        <div class="row justify-content-center align-items-center h-100 ">
            <div class="col-md-4 card ">
                <form action="login.do" method="post">
                    <input type="hidden" name="login" value="login">
                        <div class="card-body">
                                <h2 class="card-title">Ingresar</h2>
                                <div class="form-group">
                                    <label for="cedula ">Cédula</label>
                                    <input type="number" class="form-control " name="cedula" id="cedula" placeholder="Cedula" required>
                                </div>
                                <div class="form-group ">
                                    <label for="password ">Contraseña</label>
                                    <input name="password" type="password" name="password" class="form-control " id="password" placeholder="Contraseña" required>
                                </div>
            
                                <button type="submit" class="btn btn-primary ">Submit</button>
                                <div><span class="text-danger">${error}</span><div>
                            </div>
                </form>
            </div>
        </div>
    </div>

 
</body>
</html>