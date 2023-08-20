package com.mycompany.trabalho2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "removeuser", urlPatterns = {"/RemoveUser"})
public class RemoveUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
        try {
            Database db = new Database();
            Connection con = db.getCon();
            String sql = "DELETE FROM user WHERE id = ?";
            PreparedStatement pStatement = con.prepareStatement(sql);
            pStatement.setInt(1, id);
            pStatement.execute();
            pStatement.close(); // Fecha o statment
            db.close(); // Chama o fechamento do nosso objeto db
        } catch (Exception e) {
            System.out.println("Erro ao remover usuário: "+e.toString());
        }
        response.sendRedirect("ListaUser");
    }

}
