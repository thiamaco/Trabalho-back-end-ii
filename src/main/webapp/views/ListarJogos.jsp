<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ page import="com.test.model.Jogos" %>
    <%@ page import="java.util.ArrayList" %>

      

<% if (session.getAttribute("usuarioAutenticado") !="usuario" && session.getAttribute("usuarioAutenticado")
!="admin" ) { response.sendRedirect("views/index.jsp"); } %>
        <html>

        <head>
          <title>Lista de Jogos</title>
          <link rel="stylesheet" href="style.css">
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
 
        </head>

        <body>
          <div class="container">
            <div class="row justify-content-center">
              <div class="col-md-6 text-center mb-5">
                <h3 class="heading-section">Filtro de pesquisa</h3>
              </div>
            </div>
            <div class="row justify-content-center">
              <div class="col-md-7 col-lg-8">
                <div class="login-wrap p-4 p-md-5">
                  <form class="filtro login-form" action="Filtrar" method="POST">
                    <div class="form-group">
                      <label>Time da casa:</label>
                      <input class="form-control rounded-left" type="text" name='mandante'>
                    </div>
                    <div class="form-group">
                      <label>Time de fora:</label>
                      <input class="form-control rounded-left" type='text' name='visitante'>
                    </div>
                    <div class="form-group">
                      <label>Estadio:</label>
                      <input class="form-control rounded-left" type="text" name='estadio'>
                    </div>
                    <div class="form-group ">
                      <input type='submit' value='Filtrar' class="form-control btn btn-primary rounded submit px-3">
                    </div>
                  </form>
                </div>
              </div>
            <div>
            <div class="row justify-content-center">
                <div class="modal-body">
                    <h2 class="heading-section">Lista de Jogos:</h2>
                </div>
                <table class="">
                  <thead>
                  <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Horário</th>
                    <th scope="col">Time da casa</th>
                    <th scope="col">Gol(s)</th>
                    <th scope="col">Time visitante</th>
                    <th scope="col">Gol(s)</th>
                    <th scope="col">Estádio</th>
                    <th scope="col">CreateBy</th>
                  </tr>
                </thead>
                <tbody>
                  <% for (Jogos jogo : (ArrayList<Jogos>) request.getAttribute("Jogos")) { %>
                    <tr >
                      <th >
                        <%= jogo.getIdJogo() %>
                      </th>
                      <th>
                        <%= jogo.getHorario() %>
                      </th>
                      <th>
                        <%= jogo.getMandante() %>
                      </th>
                      <th>
                        <%= jogo.getGolMandante() %>
                      </th>
                      <th>
                        <%= jogo.getVisitante() %>
                      </th>
                      <th>
                        <%= jogo.getGolVisitante() %>
                      </th>
                      <th>
                        <%= jogo.getEstadio() %>
                      </th>
                      <th>
                        <%= jogo.getCreate() %>
                      </th>
                      <% if (session.getAttribute("usuarioAutenticado")=="admin" ) {%>
                        <td>
                          <form action="DeletarJogo" method="POST">
                            <input type="hidden" name="id_jogo" value="<%= jogo.getIdJogo() %>">
                            <input type="hidden" name="lista" value="5">
                            <button type='submit' value='' class='delete'>
                              <svg style="fill: red;"xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512"><path d="M367.2 412.5L99.5 144.8C77.1 176.1 64 214.5 64 256c0 106 86 192 192 192c41.5 0 79.9-13.1 111.2-35.5zm45.3-45.3C434.9 335.9 448 297.5 448 256c0-106-86-192-192-192c-41.5 0-79.9 13.1-111.2 35.5L412.5 367.2zM0 256a256 256 0 1 1 512 0A256 256 0 1 1 0 256z"/></svg>
          
                          </button>
                          </form>
                        </td>
                        <% } %>

                    </tr>
                    <% } %>
                  </tbody>
                </table>


<div class="buttons" style="margin: 30px; text-align: center;">
                <% if (session.getAttribute("usuarioAutenticado")=="admin" ) {%>
                  <a href="/demo/AprovarJogos"><input type="button" value='Voltar' class='btn'style="margin-right: 20px;"></a>
                  <% }else if (session.getAttribute("usuarioAutenticado")=="usuario" ){ %>
                    <a href="/demo/views/registrodejogos.jsp"><input type="button" value='Voltar' class=' btn btn-primary'></a>
                    <% } %>
                      <a href="/demo/views"><input type="button" value='Sair' class=' btn btn-primary'></a>
              </div>



            </div>
          </div>
          <style>

label,h2,
                h3 {
                    color: #1089ff !important;
                }
                
    .filtro {
    display: flex;
    flex-direction: row;
    align-content: stretch;
    align-items: flex-end;
    gap: 10px;
    flex-wrap: wrap;
}
input.btn.btn-primary {
    min-width: 80px;
}
.submit {
    padding: 0px 20px 0px 20px;
}
.form-group{
  margin: 0px !important;
}
.table-row {
    background-color: #ffffff;
    box-shadow: 0px 0px 9px 0px rgba(0,0,0,0.1);
  }
  .heading-section{
    text-align: center;
    margin-top: 30px;
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
}
.delete,.update {
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
          </style>
        </body>

        </html>