
<html>
<head>
<title>Ingresar</title>
<jsp:include page="../layout/header.jsp" />
</head>
<body class="bg-primary">

    <div class="container h-100" ">
        <div class="row justify-content-center align-items-center h-100 ">
            <div class="col-md-4 col-sm-12 card ">
                <form action="login" method="post">
                    <input type="hidden" name="login" value="login">
                        <div class="card-body">
                                <h2 class="card-title">Cambio Sprint Review 2</h2>
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