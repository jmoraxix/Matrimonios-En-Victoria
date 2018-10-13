
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

<!-- ONLINE CDN - I CANT GET THESE ONES TO WORK -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<!--===========================================================================
    END GLOBAL_INCLUDES FILE
============================================================================-->
</head>
<body class="bg-primary">

    <div class="container h-100" ">
        <div class="row justify-content-center align-items-center h-100 ">
            <div class="col-md-4 card ">
                <form action="login" method="post">
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