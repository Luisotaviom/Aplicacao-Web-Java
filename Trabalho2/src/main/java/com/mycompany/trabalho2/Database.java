
package com.mycompany.trabalho2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Database {

    Connection con = null;

    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Instancia o driver para coneção com o banco
            String url = "jdbc:mysql://localhost:3306/trabalho2"; // Define a url para acessar o banco de dados e também o database
            String username = "root"; // Define o usuário que vai acessar
            String password = ""; // Define a senha a ser utilizada
            this.con = DriverManager.getConnection(url, username, password); // Cria uma conexão para interagir com o banco

        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.toString());
        }
    }

    public Connection getCon() {
        return con;
    }

    public void close() {
        if (this.con != null) {
            try {
                this.con.close();
            } catch (Exception e) {
                System.out.println("Erro ao fechar conexão: " + e.toString());
            }

        }
    }

}
