/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.trabalho2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "criacaouser", urlPatterns = {"/CriacaoUser"})
public class CriacaoUser extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        HttpSession session = request.getSession();
        if (session.getAttribute("email") != null && session.getAttribute("senha") != null) {
            request.getRequestDispatcher("/WEB-INF/criacao_user.jsp").forward(request, response);
        } else {
            response.sendRedirect("http://localhost:8080/Trabalho2/Acesso");
        }
      }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String celular = request.getParameter("celular");
        String data_nascimento = request.getParameter("data_nascimento");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        try {
            Database db = new Database();
            Connection con = db.getCon();
            String sql = "SELECT * FROM user WHERE email = ?";
            PreparedStatement pStatement = con.prepareStatement(sql);
            pStatement.setString(1, email);
            ResultSet rSet = pStatement.executeQuery();
            while (rSet.next()) { // Itera nos seus resultados, enquanto tiver
                if (rSet.getString("email").equals(email)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("error", "Email já existe na base de dados");
                    request.getRequestDispatcher("/WEB-INF/criacao_user.jsp").forward(request, response);
                    return;
                }
            }
            sql = "INSERT INTO user(nome, celular, data_nascimento, email, senha) VALUE (?,?,?,?,?)";
            pStatement = con.prepareStatement(sql);
            pStatement.setString(1, nome);
            pStatement.setString(2, celular);
            pStatement.setString(3, data_nascimento);
            pStatement.setString(4, email);
            pStatement.setString(5, senha);
            pStatement.execute();
            rSet.close(); // Fecha o resultado
            pStatement.close(); // Fecha o statment
            db.close(); // Chama o fechamento do nosso objeto db
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        response.sendRedirect("Acesso");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
