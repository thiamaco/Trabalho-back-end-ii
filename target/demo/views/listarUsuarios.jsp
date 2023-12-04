<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="com.test.model.Usuario" %>
        <%@ page import="java.util.ArrayList" %>

        <% if (session.getAttribute("usuarioAutenticado") != "admin" ) {
            response.sendRedirect("views/index.jsp");
        }
        %>
        <%
        String currentPage = request.getRequestURL().toString();
                            Cookie cookie = new Cookie("Ultima_pagina_visitada", currentPage);
                            cookie.setPath("/");
                            response.addCookie(cookie); 
        %>
            <html>
                <head>
                    <title>Usuários</title>
                    <link rel="stylesheet" href="style.css">
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <link rel="stylesheet" href="style.css">
                </head>
                <body>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-md-6 text-center mb-5">
                                <h2 class="heading-section">Adicionar Usuario</h2>
                            </div>
                        </div>
                    
                        <div class="row justify-content-center">
                            <div class="col-md-7 col-lg-10">
                                <div class="login-wrap p-4 p-md-5">
                                <form action="${pageContext.request.contextPath}/CriaUsuario" method="POST" class="cadastrar login-form">
                                    <div class="form-group">
                                    <label>Nome:</label>
                                    <input type='text' name='nome'class="form-control rounded-left">
                                </div>
                                    <div class="form-group">
                                    <label>Login:</label>
                                    <input type="text" name='email'class="form-control rounded-left">
                                </div>
                                    <div class="form-group">
                                    <label>Senha</label>
                                    <input type="text" name='senha'class="form-control rounded-left">
                                </div>
                                <div class="form-group">
                                    <input type='submit' value='Adicionar' class='form-control btn btn-primary rounded submit px-3'>
                                </div>
                                    
                                </form>
                            </div>
                            </div>
                        
                        
                        </div>
                        <div class="list-user">
                            <h3 style="margin-top:20px">Lista de Usuarios</h3>
                                <table>
                                    <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Nome</th>
                                        <th scope="col">Login</th>
                                        <th scope="col">Perfil</th>
                                    
                                    </tr>
                                </thead>
                                <tbody>
                                <% for (Usuario usuario : (ArrayList<Usuario>) request.getAttribute("Usuarios")) { %>
                                    
                                    
                                    
                                    <tr>
                                        <th><%= usuario.getId() %></th>
                                        <th> <%= usuario.getNome() %></th>
                                        <th> <%= usuario.getLogin() %></th>
                                        <th><%= usuario.getPerfil() %></th>
                                        <% if (usuario.getPerfil().contains("novo")) { %>
                                        <td> <form action="${pageContext.request.contextPath}/AprovarUsuario" method="POST">
                                            <input type="hidden" name ="id" value="<%= usuario.getId() %>">
                                            <button type='submit' value='' class='update'>
                                                <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512"><path d="M362.7 19.3L314.3 67.7 444.3 197.7l48.4-48.4c25-25 25-65.5 0-90.5L453.3 19.3c-25-25-65.5-25-90.5 0zm-71 71L58.6 323.5c-10.4 10.4-18 23.3-22.2 37.4L1 481.2C-1.5 489.7 .8 498.8 7 505s15.3 8.5 23.7 6.1l120.3-35.4c14.1-4.2 27-11.8 37.4-22.2L421.7 220.3 291.7 90.3z"/></svg>
        
                                            </button>
                                        </form></td>
                                        <% } else if (usuario.getPerfil().contains("usuario")) { %>
                                       <!--     <td>Aprovado</td>-->
                                        <% }else { %>
                                        <!--    <td>Admin</td>-->
                                        <% } %>
                                        <% if (usuario.getPerfil().contains("novo") || usuario.getPerfil().contains("usuario") ) { %>
                                        <td> <form action="${pageContext.request.contextPath}/DeletarUsuario" method="POST">
                                            <input type="hidden" name ="id" value="<%= usuario.getId() %>">
                                            <button type='submit' value='' class='delete'>
                                                <svg style="fill: red;"xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512"><path d="M367.2 412.5L99.5 144.8C77.1 176.1 64 214.5 64 256c0 106 86 192 192 192c41.5 0 79.9-13.1 111.2-35.5zm45.3-45.3C434.9 335.9 448 297.5 448 256c0-106-86-192-192-192c-41.5 0-79.9 13.1-111.2 35.5L412.5 367.2zM0 256a256 256 0 1 1 512 0A256 256 0 1 1 0 256z"/></svg>
    
                                            </button>

                                        </form></td>
                                        <% }else { %>
                                        <!--    <td>Admin</td>-->
                                            <% } %>
                                    </tr>
                                <% } %>
                            </tbody>
                            </table>
                        </div>

                        <div class="buttons">
                            <a href="/demo/views">Voltar</a>
                            <a href="/">Sair</a>
                            <a href="${pageContext.request.contextPath}/AprovarJogos">Jogos para Aprovar</a>
                            <a href="${pageContext.request.contextPath}/Jogos">Ver Jogos</a>
                        </div>
                </div>
            </body>
        </html>
            <style>
th {
    border: none;
}
.container {
    display: flex;
    flex-direction: column;
}
a input {
    padding: 5px 15px 5px 15px;
}
a {
    padding-right: 20px;
}

.add-user {
    
    text-align: center;
}
.list-user {
    text-align: center;
}
.buttons {
    margin: auto;
    text-align: center;
} 
.buttons .btn:hover {
    background: #000306;
    color: blue;
}
.btn {
    margin-top: 20px;
    background: #1089ff;
    border: 1px solid #1089ff !important;
    color: #fff;
    font-size: 24px;
    cursor: pointer;
}
                .btn:hover,
                .btn:active,
                .btn:focus {
                    outline: none;
                }

                html {
                    font-family: sans-serif;
                    line-height: 1.15;
                    -webkit-text-size-adjust: 100%;
                    -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
                }

                h1 {
                    text-align: center;
                }

 /*               table,
                th,
                td {
                    border: 1px solid black;
                }
*/
th {
    border: 1px solid black;
}
                table {
                    border-collapse: collapse;
                    margin: auto;
                }

                th {
                    min-width: 100px;
                }

                th,
                td {
                    padding: 5px;
                    text-align: left;

                }

                th {
                    font-weight: bold;
                }

                th {
                    background-color: #1089ff ;
                    color: #fff;
                }

             
                .btn:hover,
                .btn:active,
                .btn:focus {
                    outline: none;
                }

                
                .btn:hover {
                    border: 1px solid #1089ff;
                    background: transparent;
                    color: #1089ff;
                }

                a {

                    margin-left: 20px;
                    color: #007bff;
                    text-decoration: none;
                    background-color: transparent;
                }

                a:hover {
                    color: #0056b3;
                    text-decoration: underline;
                }

                label,h2,
                h3 {
                    color: #1089ff !important;
                }

                .delete,.update {
    
    background: transparent;
    border: none;
    color: #fff;
    font-size: 20px;
    cursor: pointer;
    position: relative;
}


    button.delete::before {
        content: 'Delete';
        visibility: hidden;
        background-color: #333;
        color: #fff;
        text-align: center;
        border-radius: 6px;
        padding: 5px;
        position: absolute;
        top: -30px;
        left: 50%;
        margin-left: -30px;
        opacity: 0;
        transition: opacity 0.3s;
    }
    button.update::before {
        content: 'Aprovar';
        visibility: hidden;
        background-color: #333;
        color: #fff;
        text-align: center;
        border-radius: 6px;
        padding: 5px;
        position: absolute;
        top: -30px;
        left: 50%;
        margin-left: -30px;
        opacity: 0;
        transition: opacity 0.3s;
    }

    button.delete:hover::before {
        visibility: visible;
        opacity: 1;
    }
    button.update:hover::before {
        visibility: visible;
        opacity: 1;
    }
    .cadastrar {
    display: flex;
    flex-direction: row;
    align-content: stretch;
    align-items: flex-end;
    gap: 10px;
    flex-wrap: wrap;
    justify-content: center;
}
th {
    border: none;
}
.submit {
    padding: 0px 20px 0px 20px;
}
.form-group{
  margin: 0px !important;
}

input.btn.btn-primary {
    min-width: 80px;
}

  table {
      width: 100%;
      border-collapse: separate;
      border-spacing: 0 10px; /* Adicionando espaçamento vertical de 10 pixels */
      margin-top: 20px;
    }
    th, td {
      /*border: 1px solid #dddddd;*/
      padding: 10px;
      text-align: center;
    }
    th {
      background-color: #f2f2f2;
    }

    th:nth-child(4n) {
    border-bottom-right-radius: 5px;
    border-top-right-radius: 5px;
}

th:first-child {
    
    border-bottom-left-radius: 5px;
    border-top-left-radius: 5px;
}
th:nth-child(even) {
    background: #1089ff;
    font-weight: bolder;
}

th:nth-child(odd) {
    background: #c9c7c7;
    color: black;
}
            </style>