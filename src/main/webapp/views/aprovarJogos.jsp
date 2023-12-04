<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="com.test.model.Jogos" %>
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
                <title>Aprovacoes de Jogos</title>
                <link rel="stylesheet" href="style.css">
            </head>
            <body>
              <div class="container">
              <div class="row justify-content-center">
                <div class="col-md-6 text-center mb-5">
                    <h2 class="heading-section">Aprovar Jogos</h2>
                </div>
            </div>  

            
              <table  style="margin:auto;">
                    <tr>
                        <th>ID</th>
                        <th>Horário</th>
                        <th>Time da casa</th>
                        <th>Gol(s)</th>
                        <th>Time visitante</th>
                        <th>Gol(s)</th>
                        <th>Estádio</th>
                        <th>CreateBy</th>
                        <th>Aguardando Aprovação</th>
                    </tr>
        <% for (Jogos jogo : (ArrayList<Jogos>) request.getAttribute("Jogos")) { %>
            <tr>
                <th><%= jogo.getIdJogo() %></th>
                <th><%= jogo.getHorario() %></th>
                <th><%= jogo.getMandante() %></th>
                <th><%= jogo.getGolMandante() %></th>
                <th><%= jogo.getGolVisitante() %></th>
                <th><%= jogo.getGolVisitante() %></th>
                <th><%= jogo.getEstadio() %></th>
                <th><%= jogo.getCreate() %></th>
                <td> <form action="${pageContext.request.contextPath}/AprovarJogos" method="POST">
                  <input type="hidden" name ="id" value="<%= jogo.getIdJogo() %>">
                  <button type='submit' value='' class='aprovar'>
                    <svg style="fill: green;"xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512">
                        <path d="M173.898 439.404l-166.4-166.4c-9.997-9.997-9.997-26.206 0-36.204l36.203-36.204c9.997-9.998 26.207-9.998 36.204 0L192 312.69 432.095 72.596c9.997-9.997 26.207-9.997 36.204 0l36.203 36.204c9.997 9.997 9.997 26.206 0 36.204l-294.4 294.401c-9.998 9.997-26.207 9.997-36.204-.001z"/></svg>
                </button>
              </form></td>
                <td> <form action="${pageContext.request.contextPath}/DeletarJogo" method="POST">
                  <input type="hidden" name ="id_jogo" value="<%= jogo.getIdJogo() %>">
                  <button type='submit' value='' class='delete'>
                    <svg style="fill: red;"xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512"><path d="M367.2 412.5L99.5 144.8C77.1 176.1 64 214.5 64 256c0 106 86 192 192 192c41.5 0 79.9-13.1 111.2-35.5zm45.3-45.3C434.9 335.9 448 297.5 448 256c0-106-86-192-192-192c-41.5 0-79.9 13.1-111.2 35.5L412.5 367.2zM0 256a256 256 0 1 1 512 0A256 256 0 1 1 0 256z"/></svg>

                </button>
              </form></td>
            </tr>

        <% } %>
                </table>
                <div class="buttons">
                  <a href="${pageContext.request.contextPath}/VerUsuarios"><input type="button" value='Voltar' class='form-control btn btn-primary rounded submit px-3'></a>
                  <a href="/"><input type="button" value='Sair' class='form-control btn btn-primary rounded submit px-3'></a>
                  <a href="${pageContext.request.contextPath}/Jogos"><input type="button" value='Ver Jogos' class='form-control btn btn-primary rounded submit px-3'></a>
              </div>
            </body>        
<style>
            th {
              border: none;
          }
          .container {
              display: flex;
              flex-direction: column;
          }
          .buttons {
    display: flex;
    justify-content: center;
}
label,h2,
                h3 {
                    color: #1089ff !important;
                }
                
          a input {
              padding: 5px 15px 5px 15px;
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
          
                          label,
                          h3 {
                              color: #1089ff !important;
                          }
          
                          .delete,.aprovar {
              margin-top: 20px;
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
              button.aprovar::before {
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
          
              th:last-child {
              
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
         </body>
         </html>
 