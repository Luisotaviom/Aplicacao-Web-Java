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

@WebServlet(name = "Calculadora", urlPatterns = {"/Calculadora"})
public class Calculadora extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        try {
            Database db = new Database();
            Connection con = db.getCon();
            String sql = "SELECT * FROM notas";
            PreparedStatement pStatement = con.prepareStatement(sql);
            ResultSet rSet = pStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (rSet.next()) { // Itera nos seus resultados, enquanto tiver
                String user = (rSet.getString("user"));
                float ex1 = Float.parseFloat(rSet.getString("exercicio1"));
                float ex2 = Float.parseFloat(rSet.getString("exercicio2"));
                float ex3 = Float.parseFloat(rSet.getString("exercicio3"));
                float ex4 = Float.parseFloat(rSet.getString("exercicio4"));
                float t1 = Float.parseFloat(rSet.getString("trabalho1"));
                float t2 = Float.parseFloat(rSet.getString("trabalho2"));

                request.setAttribute("user", user);
                request.setAttribute("ex1", ex1);
                request.setAttribute("ex2", ex2);
                request.setAttribute("ex3", ex3);
                request.setAttribute("ex4", ex4);
                request.setAttribute("t1", t1);
                request.setAttribute("t2", t2);
                request.setAttribute("mediaFinal", ((ex1 + ex2 + ex3 + ex4) / 4 * 0.3) + (t1 * 0.35) + (t2 * 0.35));
            }
            rSet.close(); // Fecha o resultado
            pStatement.close(); // Fecha o statment
            db.close(); // Chama o fechamento do nosso objeto db

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        HttpSession session = request.getSession();
        if (session.getAttribute("email") != null && session.getAttribute("senha") != null) {
            request.getRequestDispatcher("/WEB-INF/calculadora.jsp").forward(request, response);
        } else {
            response.sendRedirect("http://localhost:8080/Trabalho2/Acesso");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = (request.getParameter("user"));
        float ex1 = Float.parseFloat(request.getParameter("ex1"));
        float ex2 = Float.parseFloat(request.getParameter("ex2"));
        float ex3 = Float.parseFloat(request.getParameter("ex3"));
        float ex4 = Float.parseFloat(request.getParameter("ex4"));
        float t1 = Float.parseFloat(request.getParameter("t1"));
        float t2 = Float.parseFloat(request.getParameter("t2"));

        try {
            Database db = new Database();
            Connection con = db.getCon();
            String sql = "INSERT INTO notas(user, exercicio1, exercicio2, exercicio3,exercicio4, trabalho1, trabalho2) VALUE (?,?,?,?,?,?,?)";
            PreparedStatement pStatement = con.prepareStatement(sql);
            pStatement.setString(1, user);
            pStatement.setFloat(2, ex1);
            pStatement.setFloat(3, ex2);
            pStatement.setFloat(4, ex3);
            pStatement.setFloat(5, ex4);
            pStatement.setFloat(6, t1);
            pStatement.setFloat(7, t2);
            pStatement.execute();
            pStatement.close(); // Fecha o statment
            db.close(); // Chama o fechamento do nosso objeto db
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        response.sendRedirect("Calculadora");

    }
}
