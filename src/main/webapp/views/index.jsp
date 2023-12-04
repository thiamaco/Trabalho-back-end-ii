<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
String currentPage = request.getRequestURL().toString();
                    Cookie cookie = new Cookie("Ultima_pagina_visitada", currentPage);
                    cookie.setPath("/");
                    response.addCookie(cookie); 
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="style.css">
</head>
<body class ="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
                <h2 class="heading-section">Login</h2>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-7 col-lg-5">
                <div class="login-wrap p-4 p-md-5">
                    <div class="icon d-flex align-items-center justify-content-center">
                    <span class="fa fa-user-o"></span>
                    </div>
                    <h3 class="text-center mb-4">Sign In</h3>
                <form method="POST" action="${pageContext.request.contextPath}/VerificaLogin" class="login-form">
                    <div class="form-group">    
                        <input class="form-control rounded-left" type='text' name="email" placeholder ='E-mail'required>
                    </div>
                    <div class="form-group d-flex">
                        <input class="form-control rounded-left" type="password" name="senha" placeholder ='Senha'required data-validate="Enter password">
                    </div>  
                    <div class="form-group">
                        <button type = "submit"value ="Entrar"class="form-control btn btn-primary rounded submit px-3">Entrar
                        </button>
                        <div class="form-group d-md-flex">
                            
                            <div class="w-50 text-md-right">
                                <a href="criarconta.jsp">Criar Conta</a>
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
