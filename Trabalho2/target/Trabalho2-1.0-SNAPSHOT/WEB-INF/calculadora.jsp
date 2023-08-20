<!DOCTYPE html>
<html>
    <head>
        <title>Calculadora de Notas</title>


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

            h1 {
                text-align: center;
                margin-top: 20px;
            }

            form {
                width: 300px;
                margin: 0 auto;
            }

            label {
                display: block;
                margin-top: 10px;
            }

            input[type="number"] {
                width: 100%;
                padding: 5px;
                border-radius: 3px;
                border: 1px solid #ccc;
            }

            input[type="submit"] {
                width: 100%;
                padding: 10px;
                background-color: #333;
                color: #fff;
                border-radius: 5px;
                border: none;
                cursor: pointer;
            }

            h2 {
                text-align: center;
                margin-top: 20px;
            }

            #mediaFinal {
                text-align: center;
                font-size: 18px;
                font-weight: bold;
                margin-top: 10px;
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
                    <li><a href="Nota">Consultar nota</a></li>
                </ul>
            </nav>
        </header>



        <h1>Calculadora de Notas</h1>

        <form action="<%= request.getContextPath()%>/Calculadora" method="POST">
            <label for="ex1">Seu nome:</label>
            <input type="text" name="user" placeholder="Escreva seu nome..." /> 
            <br>

            <label for="ex1">Exercício 1:</label>
            <input type="number" name="ex1"id="ex1" value=" <%=request.getAttribute("ex1")%> " step="0.01" min="0" max="10">
            <br>


            <label for="ex2">Exercício 2:</label>
            <input type="number" name="ex2" id="ex2" value=" <%=request.getAttribute("ex2")%> "  step="0.01" min="0" max="10">
            <br>


            <label for="ex3">Exercício 3:</label>
            <input type="number" name="ex3" id="ex3" value=" <%=request.getAttribute("ex3")%> "  step="0.01" min="0" max="10">
            <br>


            <label for="ex4">Exercício 4:</label>
            <input type="number" name="ex4" id="ex4" value=" <%=request.getAttribute("ex4")%> "  step="0.01" min="0" max="10">
            <br>


            <label for="t1">Trabalho 1:</label>
            <input type="number" name="t1" id="t1" value=" <%=request.getAttribute("t1")%> "  step="0.01" min="0" max="10">
            <br>


            <label for="t2">Trabalho 2:</label>
            <input type="number" name="t2" id="t2" value=" <%=request.getAttribute("t2")%> "  step="0.01" min="0" max="10">
            <br>


            <input type="submit" value="Calcular Média">
        </form>


        <h2>Média Final:</h2>
        <p id="mediaFinal"><%= request.getAttribute("mediaFinal")%></p>

        <div style="text-align: center;">
            <nav>
                <ul>
                    <li><a href="Consulta">Consulte suas notas</a></li>
                </ul>
            </nav>
        </div>

    </body>
</html>
