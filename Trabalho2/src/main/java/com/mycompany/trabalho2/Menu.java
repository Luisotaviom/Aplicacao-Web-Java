/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.trabalho2;

import java.io.IOException;
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
@WebServlet(name = "Menu", urlPatterns = {"/Menu"})
public class Menu extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        HttpSession session = request.getSession();
        if (session.getAttribute("email") != null && session.getAttribute("senha") != null) {
            request.getRequestDispatcher("/WEB-INF/menu.jsp").forward(request, response);
        } else {
            response.sendRedirect("http://localhost:8080/Trabalho2/Acesso");
        }
    }
    
}
