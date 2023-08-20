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

@WebServlet(name = "updateuser", urlPatterns = {"/UpdateUser"})
public class UpdateUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Database db = new Database();
            Connection con = db.getCon();
            String sql = "SELECT * FROM user WHERE id = ?";
            PreparedStatement pStatement = con.prepareStatement(sql);
            pStatement.setInt(1, id);
            ResultSet rSet = pStatement.executeQuery();
            while (rSet.next()) {
                User user = new User(
                        rSet.getInt("id"),
                        rSet.getString("nome"),
                        rSet.getString("celular"),
                        rSet.getString("data_nascimento"),
                        rSet.getString("email"),
                        rSet.getString("senha")
                );
                request.setAttribute("user", user);
            }
            rSet.close(); // Fecha o resultado
            pStatement.close(); // Fecha o statment
            db.close(); // Chama o fechamento do nosso objeto db
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        HttpSession session = request.getSession();
        if (session.getAttribute("email") != null && session.getAttribute("senha") != null) {
            request.getRequestDispatcher("/WEB-INF/mundaca_user.jsp").forward(request, response);
        } else {
            response.sendRedirect("http://localhost:8080/Trabalho2/Acesso");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String celular = request.getParameter("celular");
        String data_nascimento = request.getParameter("data_nascimento");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        try {
            Database db = new Database();
            Connection con = db.getCon();
            String sql = "SELECT * FROM user WHERE id != ?";
            PreparedStatement pStatement = con.prepareStatement(sql);
            pStatement.setInt(1, id);
            ResultSet rSet = pStatement.executeQuery();
            while (rSet.next()) { // Itera nos seus resultados, enquanto tiver
                if (rSet.getString("email").equals(email)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("error", "Email já existe na base de dados");
                    response.sendRedirect("user_update?id=" + id);
                    return;
                }
            }
            sql = "UPDATE user SET nome=?, celular=?, data_nascimento=?, email=?, senha=? WHERE id = ?";
            pStatement = con.prepareStatement(sql);
            pStatement.setString(1, nome);
            pStatement.setString(2, celular);
            pStatement.setString(3, data_nascimento);
            pStatement.setString(4, email);
            pStatement.setString(5, senha);
            pStatement.setInt(6, id);
            pStatement.execute();
            rSet.close(); // Fecha o resultado
            pStatement.close(); // Fecha o statment
            db.close(); // Chama o fechamento do nosso objeto db
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        response.sendRedirect("ListaUser");
    }
}
