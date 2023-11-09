<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style.css">
</head>

<body class ="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
                <h2 class="heading-section">Criação de Login</h2>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-7 col-lg-5">
                <div class="login-wrap p-4 p-md-5">
                    
                    <h3 class="text-center mb-4">Criar Conta</h3>
                <form method="POST" action="criarlogin.php" class="login-form">
                    <div class="form-group">
                        <input class="form-control rounded-left" type='text' name="nome" placeholder ='Nome'required>
                    </div>
                    <div class="form-group">
                        <input class="form-control rounded-left" type='text' name="email" placeholder ='E-mail'required>
                    </div>
                    <div class="form-group d-flex">
                        <input class="form-control rounded-left" type="password" name="senha" placeholder ='Senha'required data-validate="Enter password">
                    </div>  
                    <div class="form-group">
                        <button type = "submit"class="form-control btn btn-primary rounded submit px-3">Criar Conta
                        </button>
                        <div class="form-group d-md-flex">
                            
                            <div class="w-50 text-md-right">  
                                <a href="login.html">Voltar</a>
                            </div>
                        </div>
                    </div>
                </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
