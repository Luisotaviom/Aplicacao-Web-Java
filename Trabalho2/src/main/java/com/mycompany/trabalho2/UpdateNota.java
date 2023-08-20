package com.mycompany.trabalho2;

import java.io.IOException;
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
@WebServlet(name = "UpdateNota", urlPatterns = {"/UpdateNota"})
public class UpdateNota extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
            
        try {
            Database db = new Database();
            Connection con = db.getCon();
            String sql = "SELECT * FROM notas WHERE id = ?";
            PreparedStatement pStatement = con.prepareStatement(sql);
            ResultSet rSet = pStatement.executeQuery();
            while (rSet.next()) {
                Notas nota2 = new Notas(
                        rSet.getInt("id"),
                        rSet.getString("ex1"),
                        rSet.getString("ex2"),
                        rSet.getString("ex3"),
                        rSet.getString("ex4"),
                        rSet.getString("t1"),
                        rSet.getString("t2")
                );
                request.setAttribute("nota2", nota2);
            }
            rSet.close(); // Fecha o resultado
            pStatement.close(); // Fecha o statment
            db.close(); // Chama o fechamento do nosso objeto db
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        HttpSession session = request.getSession();
        if (session.getAttribute("email") != null && session.getAttribute("senha") != null) {
            request.getRequestDispatcher("/WEB-INF/mudanca_notas.jsp").forward(request, response);
        } else {
            response.sendRedirect("http://localhost:8080/Trabalho2/Acesso");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Double ex1 = Double.parseDouble(request.getParameter("ex1"));
        Float ex2 = Float.parseFloat(request.getParameter("ex2"));
        Float ex3 = Float.parseFloat(request.getParameter("ex3"));
        Float ex4 = Float.parseFloat(request.getParameter("ex4"));
        Float t1 = Float.parseFloat(request.getParameter("t1"));
        Float t2 = Float.parseFloat(request.getParameter("t2"));
        
        try {
            Database db = new Database();
            Connection con = db.getCon();
            String sql = "SELECT * FROM notas WHERE id != ?";
            PreparedStatement pStatement = con.prepareStatement(sql);
            ResultSet rSet = pStatement.executeQuery();
            
            sql = "UPDATE notas SET ex1=?, ex2=?, ex3=?, ex4=?, t1=?, t2=? WHERE id = ?";
            pStatement = con.prepareStatement(sql);
            pStatement.setDouble(1, ex1);
            pStatement.setFloat(2, ex2);
            pStatement.setFloat(3, ex3);
            pStatement.setFloat(4, ex4);
            pStatement.setFloat(5, t1);
            pStatement.setFloat(6, t2);
            pStatement.setInt(7, id);
            pStatement.execute();
            rSet.close(); // Fecha o resultado
            pStatement.close(); // Fecha o statment
            db.close(); // Chama o fechamento do nosso objeto db
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        response.sendRedirect("Consulta");
    }
}
