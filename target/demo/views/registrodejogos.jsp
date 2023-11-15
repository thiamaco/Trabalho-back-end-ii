<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <% if (session.getAttribute("usuarioAutenticado") !="usuario" ) { response.sendRedirect("views/index.jsp"); } %>
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Criaçao de Jogos</title>
            <link rel="stylesheet" href="style.css">
        </head>
        <body class="">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <h2 class="heading-section">Formulario para criação de jogos</h2>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-7 col-lg-5">
                        <div class="login-wrap p-4 p-md-5">
                            <form action="${pageContext.request.contextPath}/AdicionarJogo" method="GET" class="login-form">
                                <div class="form-group">
                                    <label>N° do jogo:</label>
                                    <input type='number' min="0" name='ID' required class="form-control rounded-left">
                                    <input type="hidden" name="id_usuario" value="<%= session.getAttribute("idAutenticado") %>">
                                    
                                    <label>Horario:</label>
                                    <input type='date' min="2022-01-08" name='horario' required
                                        class="form-control rounded-left">
                                </div>
                                <div class="form-group">
                                    <label>Time da casa:</label>
                                    <input type='text' name='casa' required class="form-control rounded-left">
                                    <label>Gols:</label>
                                    <input type='number' min="0" style="-moz-appearance: textfield; appearance: textfield;" name='gol_mandante' required
                                        class="form-control rounded-left">
                                </div>
                                <div class="form-group">
                                    <label>Time visitante:</label>
                                    <input type='text' name='visitante' required class="form-control rounded-left">
                                    <label>Gols:</label>
                                    <input type='number' min="0"  style="-moz-appearance: textfield; appearance: textfield;"name='gol_visitante' required
                                        class="form-control rounded-left">
                                </div>
                                <div class="form-group">
                                    <label>Estadio:</label>
                                    <input type="text" name='estadio' required class="form-control rounded-left">
                                </div>
                                <div class="form-group">
                                    <input type='submit' value="Salvar Jogo" name='salvar' class="form-control btn btn-primary rounded submit px-3">
                                </div>
                                <a href="${pageContext.request.contextPath}/Jogos">Ver Jogos</a>
                                <a href="/demo/views">Sair</a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </body>

        </html>

       