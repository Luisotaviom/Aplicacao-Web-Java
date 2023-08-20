<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.trabalho2.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar Usuário!</title>
    </head>
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
        input[type="int"],
        input[type="text"],
        input[type="string"],
        input[type="date"],
        input[type="email"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }


        /* Estilos para o botão Criar */
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }


        /* Estilos para o botão Reset */
        input[type="reset"] {
            background-color: #f44336;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-left: 10px;
        }


        /* Estilos para mensagens de erro */
        .error-message {
            color: red;
            margin-bottom: 10px;
        }


        /* Estilos para o header */
        header {
            background-color: #333;
            padding: 20px;
            display: flex;
            justify-content: center;
        }

        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        nav li {
            display: inline;
            margin-right: 10px;
        }

        nav a {
            text-decoration: none;
            padding: 10px;
            background-color: #666;
            color: #fff;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        nav a:hover {
            background-color: #999;
        }

        /* Estilos para o título */
        h1 {
            font-family: Arial, Helvetica, sans-serif;
            text-align: center;
            margin-top: 20px;
            margin-bottom: 20px;
        }
    </style>

    <body>

        <header>
            <nav>
                <ul>
                    <li><a href="Calculadora">Calculadora</a></li>
                    <li><a href="Chat">Chat</a></li>
                    <li><a href="CriacaoUser">Criação de Usuário</a></li>
                    <li><a href="ListaUser">Lista de Usuários</a></li>
                    <li><a href="/Trabalho2/Sair">Sair</a></li>
                </ul>
            </nav>
        </header>
        <div class="container">
            <%
                Object userObject = request.getAttribute("user");
                if (userObject != null) {
                    User user = (User) userObject;
            %>
            <form action="<%= request.getContextPath()%>/UpdateUser" method="POST">
                Id: <input type="text" name="id" value="<%=user.getId()%>" readonly> <br> 
                nome:  <input type="text" name="nome" value="<%=user.getNome()%>"> <br>
                celular: <input type="string" name="celular" value="<%=user.getCelular()%>"> <br> 
                data de nascimento: <input type="date" name="data_nascimento" value="<%=user.getData_nascimento()%>"> <br> 
                email: <input type="email" name="email" value="<%=user.getEmail()%>"> <br> 
                senha: <input type="text" name="senha" value="<%=user.getSenha()%>"> <br> 
                <br>
                <input type="submit" value="Salvar">
            </form>
            <%
                }
            %>
        </div>
    </body>
</html>
