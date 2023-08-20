<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acesso</title>
        <style>
             body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }
    
            /* Estilos para o container */
            .container {
                width: 500px;
                margin: 0 auto;
                padding: 20px;
            }


            /* Estilos para os campos de entrada */
            input[type="email"],
            input[type="password"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }


            /* Estilos para o botão Entrar */
            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }


            /* Estilos para o link Criar Usuário */
            a.button {
                display: inline-block;
                background-color: #f44336;
                color: white;
                padding: 10px 20px;
                text-decoration: none;
                border-radius: 4px;
            }


            /* Estilos para o título */
            h1 {
                text-align: center;
                margin-top: 20px;
                margin-bottom: 20px;
            }
        </style>
    </head>
    
    <body>
        <div class="container">
            <jsp:include page="/WEB-INF/error_message.jsp"></jsp:include>
            <h1>Dados de Acesso</h1>
        </div>
        <div class="container">
            <form action="<%= request.getContextPath()%>/Acesso" method="POST">
                Email : <input type="email" name="email"> <br>
                Senha : <input type="password" name="senha"> <br>
                <br>
                <input type="submit" value="Entrar">
                <a href="CriacaoUser2">Criar Usuário</a>
            </form>
        </div>a
    </body>
</html>
