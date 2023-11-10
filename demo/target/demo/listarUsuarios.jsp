<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Usuario.java" %>

<html>
<head>
    <title>Lista de Usuários</title>
</head>
<body>
    <h1>Lista de Usuários:</h1>
    <ul>
        <% for (Usuario usuario : (ArrayList<Usuario>) request.getAttribute("Usuarios")) { %>
            <li>Nome: <%= usuario.getNome() %>, Email: <%= usuario.getEmail() %></li>
        <% } %>
    </ul>
</body>
</html>
