<%@page import="com.mycompany.trabalho2.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Chat</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
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

            .chat-container {
                width: 400px;
                margin: 0 auto;
                padding: 20px;
            }

            .chat-messages {
                background-color: #f2f2f2;
                padding: 10px;
                height: 120px;
                overflow-y: auto;
            }

            .message {
                background-color: #fff;
                padding: 10px;
                margin-bottom: 10px;
                border-radius: 5px;
            }

            .message.incoming {
                background-color: #e6e6e6;
            }

            .chat-input {
                margin-top: 10px;
            }

            .chat-input input[type="text"] {
                width: 100%;
                padding: 5px;
                border-radius: 3px;
                border: 1px solid #ccc;
            }

            .chat-input input[type="submit"] {
                padding: 5px 10px;
                background-color: #333;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin-top: 10px;
            }

            .container1 {
                border-radius: 5px;
                text-align: center;
                background-color: #666;
                padding: 10px; /* Adicione um preenchimento para separar o conteúdo do fundo */
            }

            /* Estilo para o link */
            .container1 a {
                color: #000;
                text-decoration: none;
                font-weight: bold;
            }

            /* Estilo para quando o mouse estiver sobre o link */
            .container1 a:hover {
                text-decoration: underline;
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

        <div class="chat-container">
            <div class="chat-messages">
                <div class="message incoming">
                    <p>Escreva sua mensagem aqui a baixo:</p>
                </div>
                <div class="container1">
                    <a href="ChatMensagens">Ver mensagens</a>
                </div>
            </div>
            <form action="<%= request.getContextPath()%>/Chat" method="POST">
                <div class="chat-input">
                    <input type="text" name="user" placeholder="Escreva seu nome..." /> <br>
                    <input type="text" name="mensagem" placeholder="Escreva sua Mensagem..." /> <br>
                    <input type="submit" value="enviar">
                </div>
            </form>


        </div>
    </body>
</html>
