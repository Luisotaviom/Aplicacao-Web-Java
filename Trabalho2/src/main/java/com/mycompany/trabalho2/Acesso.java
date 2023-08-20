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

/**
 *
 * @author User
 */
@WebServlet(name = "Acesso", urlPatterns = {"/Acesso"})
public class Acesso extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/acesso.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        try {
            Database db = new Database();
            Connection con = db.getCon();
            String sql = "SELECT * FROM user WHERE email = ? and senha = ?";
            PreparedStatement pStatement = con.prepareStatement(sql);
            pStatement.setString(1, email);
            pStatement.setString(2, senha);
            ResultSet rSet = pStatement.executeQuery();
            while (rSet.next()) { 
                if (email.equals(rSet.getString("email")) && senha.equals(rSet.getString("senha"))) {
                    session.setAttribute("email", email);
              session.setAttribute("senha", senha);
                    response.sendRedirect("Menu");
                    return;
                }
            }
            rSet.close(); // Fecha o resultado
            pStatement.close(); // Fecha o statment
            db.close(); // Chama o fechamento do nosso objeto db
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        session.setAttribute("error", "Usuário ou senha incorretos :(");
        request.getRequestDispatcher("/WEB-INF/acesso.jsp").forward(request, response);
    }



}
