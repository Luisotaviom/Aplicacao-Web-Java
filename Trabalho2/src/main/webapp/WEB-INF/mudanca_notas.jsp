<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.trabalho2.Notas"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar Nota!</title>
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
                Object NotaObject = request.getAttribute("nota2");
                if (NotaObject != null) {
                    Notas nota = (Notas) NotaObject;
            %>
            <form action="<%= request.getContextPath()%>/UpdateNota" method="POST">
                Id : <input type="text" name="id" value="<%=nota.getId()%>" readonly> <br> 
                Exercicio 1 : <input type="number" name="ex1" value="<%=nota.getEx1()%>"> <br>
                Exercicio 2 : <input type="number" name="ex2" value="<%=nota.getEx2()%>"> <br>
                Exercicio 3 : <input type="number" name="ex3" value="<%=nota.getEx3()%>"> <br> 
                Exercicio 4 : <input type="number" name="ex4" value="<%=nota.getEx4()%>"> <br> 
                Trabalho 1 : <input type="number" name="t1" value="<%=nota.getT1()%>"> <br> 
                Trabalho 2 : <input type="number" name="t2" value="<%=nota.getT2()%>"> <br> 
                <br>
                <input type="submit" value="Salvar">
            </form>
            <%
                }
            %>
        </div>
    </body>
</html>
