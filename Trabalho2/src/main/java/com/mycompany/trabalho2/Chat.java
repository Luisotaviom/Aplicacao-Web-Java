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
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "Chat", urlPatterns = {"/Chat"})
public class Chat extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        HttpSession session = request.getSession();
        if (session.getAttribute("email") != null && session.getAttribute("senha") != null) {
            request.getRequestDispatcher("/WEB-INF/chat.jsp").forward(request, response);
        } else {
            response.sendRedirect("http://localhost:8080/Trabalho2/Acesso");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    //        int id = Integer.parseInt(request.getParameter("id"));     
            String mensagem = request.getParameter("mensagem");
            String user = request.getParameter("user");
        try {
            Database db = new Database();
            Connection con = db.getCon();
            String sql = "INSERT INTO mensagem(user, mensagem) VALUES (?,?)";
            PreparedStatement pStatement = con.prepareStatement(sql);
            pStatement.setString(1, mensagem);
            pStatement.setString(2, user);
            pStatement.executeUpdate();
            
            pStatement.close(); // Fecha o statment
            db.close(); // Chama o fechamento do nosso objeto db
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        response.sendRedirect("ChatMensagens");
    }


}
