<!DOCTYPE html>
<html>
<head>
    <title>Exemplo de Usuários</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h1>Lista de Usuários</h1>
    <ul id="user-list">
    </ul>
    <script>
        // Função para carregar usuários usando jQuery AJAX
        function carregarUsuarios() {
            $.ajax({
                url: 'ExibirUsuarios', // O URL do seu servlet
                method: 'GET',
                success: function (data) {
                    $('#user-list').html(data);
                },
                error: function (xhr, status, error) {
                    console.error('Erro na solicitação AJAX: ' + error);
                }
            });
        }
        // Chama a função para carregar os usuários quando a página carrega
        carregarUsuarios();
    </script>
</body>
</html>
