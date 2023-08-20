/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.trabalho2;

import java.io.IOException;
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


@WebServlet(name = "listauser", urlPatterns = {"/ListaUser"})
public class ListaUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        try {
            Database db = new Database();
            Connection con = db.getCon();
            String sql = "SELECT * FROM user";
            PreparedStatement pStatement = con.prepareStatement(sql);
            ResultSet rSet = pStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (rSet.next()) { // Itera nos seus resultados, enquanto tiver
                User user = new User(
                        rSet.getInt("id"),
                        rSet.getString("nome"),
                        rSet.getString("celular"),
                        rSet.getString("data_nascimento"),
                        rSet.getString("email"),
                        rSet.getString("senha")
                );
                users.add(user);
            }
            rSet.close(); // Fecha o resultado
            pStatement.close(); // Fecha o statment
            db.close(); // Chama o fechamento do nosso objeto db
            request.setAttribute("users", users);
        } catch (Exception e) {
        }
        HttpSession session = request.getSession();
        if (session.getAttribute("email") != null && session.getAttribute("senha") != null) {
            request.getRequestDispatcher("/WEB-INF/lista_user.jsp").forward(request, response);
        } else {
            response.sendRedirect("http://localhost:8080/Trabalho2/Acesso");
        }
    }

}
