<%@page import="com.mycompany.trabalho2.Mensagens"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }

            h1 {
                text-align: center;
                margin-top: 20px;
            }

            table {
                width: 400px;
                margin: 0 auto;
                border-collapse: collapse;
            }

            table td, table th {
                padding: 10px;
                border: 1px solid #ccc;
            }

            table th {
                background-color: #f2f2f2;
            }

            h3 {
                text-align: center;
                margin-top: 20px;
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

        <h1>Chat</h1>



        <%
            Object mensgObject = request.getAttribute("mensagem");
            if (mensgObject != null) {
                List<Mensagens> mensagem = (List) mensgObject;
        %>
        <table border="1">
            <tr>
                <td>User</td>
                <td>Mensagem</td>
            </tr>

            <% for (Mensagens m : mensagem) {%>

            <tr>
                <td><%= m.getUser()%></td>
                <td><%= m.getMensagem()%></td>
            </tr>       
            <%}
            %>
        </table>

        <%   } else {%>
        <h3>A lista esta vazia</h3>
        <%    }
        %>
    </body>
</html>
