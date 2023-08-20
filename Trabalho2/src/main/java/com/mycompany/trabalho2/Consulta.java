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

/**
 *
 * @author User
 */
@WebServlet(name = "Consulta", urlPatterns = {"/Consulta"})
public class Consulta extends HttpServlet {

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
            List<Notas> notas = new ArrayList<>();
            while (rSet.next()) { // Itera nos seus resultados, enquanto tiver
                Notas nota = new Notas(
                        rSet.getInt("id"),
                        rSet.getString("user"),
                        rSet.getFloat("exercicio1"),
                        rSet.getFloat("exercicio2"),
                        rSet.getFloat("exercicio3"),
                        rSet.getFloat("exercicio4"),
                        rSet.getFloat("trabalho1"),
                        rSet.getFloat("trabalho2")
                );
                notas.add(nota);
            }
            rSet.close(); // Fecha o resultado
            pStatement.close(); // Fecha o statment
            db.close(); // Chama o fechamento do nosso objeto db
            request.setAttribute("notas", notas);
        } catch (Exception e) {
        }
        
        HttpSession session = request.getSession();
        if (session.getAttribute("email") != null && session.getAttribute("senha") != null) {
            request.getRequestDispatcher("/WEB-INF/consultar_nota.jsp").forward(request, response);
        } else {
            response.sendRedirect("http://localhost:8080/Trabalho2/Acesso");
        }
    }

}
