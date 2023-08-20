<%@page import="com.mycompany.trabalho2.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Usuários!</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }

            /* Estilos para o container */
            .container {
                width: 800px;
                margin: 0 auto;
                padding: 20px;
            }


            /* Estilos para o título */
            h1 {
                text-align: center;
                margin-top: 20px;
                margin-bottom: 20px;
            }


            /* Estilos para a tabela */
            table {
                width: 100%;
                border-collapse: collapse;
            }


            /* Estilos para as células da tabela */
            td {
                padding: 8px;
            }

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

            /* Estilos para o link de Remover e Editar */
            a {
                color: #4CAF50;
                text-decoration: none;
            }


            /* Estilos para a mensagem de lista vazia */
            h3 {
                text-align: center;
                color: red;
            }


        </style>

    </head>

    <body>
        <header>
            <nav>
                <ul>
                    <li><a href="Calculadora">Calculadora</a></li>
                    <li><a href="Chat">Chat</a></li>
                    <li><a href="CriacaoUser">Criação de Usuário</a></li>
                    <li><a href="ListaUser">Lista de Usuários</a></li>
                    <li><a href="/Trabalho2/Sair">Sair</a></li>
                    <li><a href="Menu">Menu</a></li>
                </ul>
            </nav>
        </header>

        <div class="container"><h1>Lista de Usuários no Sistema</h1></div>
        <div class="container">


            <%
                Object userObject = request.getAttribute("users");
                if (userObject != null) {
                    List<User> users = (List) userObject;
            %>
            <table border="1"> 
                <tr>
                    <td>Id</td>
                    <td>Nome</td>
                    <td>Email</td>
                    <td>Celular</td>
                    <td>Data de Nascimento</td>
                </tr>
                <% for (User u : users) {%>
                <tr>
                    <td><%= u.getId()%></td>
                    <td><%= u.getNome()%></td>
                    <td><%= u.getEmail()%></td>
                    <td><%= u.getCelular()%></td>
                    <td><%= u.getData_nascimento()%></td>
                    <td><a href="RemoveUser?id=<%= u.getId()%>">Remover</a></td>
                    <td><a href="UpdateUser?id=<%= u.getId()%>">Editar</a></td>
                </tr>
                <%}
                %>
            </table>
            <%   } else {%>
            <h3>A lista esta vazia</h3>
            <%    }
            %>
        </div>
    </body>
</html>
