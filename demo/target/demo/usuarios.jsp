<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resultado da Consulta</title>
</head>
<body>
    <h1>Resultado da Consulta</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Nome</th>
            <th>Email</th>
            <!-- Adicione outras colunas, se necessário -->
        </tr>
        <c:forEach var="row" items="${dados}">
            <tr>
                <td>${row.id}</td>
                <td>${row.nome}</td>
                <td>${row.login}</td>
                <td>${row.senha}</td>
                <td>${row.perfil}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
