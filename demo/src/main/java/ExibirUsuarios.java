
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ExibirUsuarios")
public class ExibirUsuarios extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
                 List<Usuario> usuarios = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()){
            String sql = "select * from usuario";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
             while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                //String perfil = resultSet.getString("perfil");
                Usuario usuario = new Usuario( id,  "nome", login,  senha,  "a");
                usuarios.add(usuario);
            }
            request.setAttribute("dados", usuarios);
           
            request.getRequestDispatcher("/usuarios.jsp").forward(request, response);
        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }

     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
                List<Usuario> usuarios = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()){
            String sql = "select * from usuario";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

             while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String perfil = resultSet.getString("perfil");
                Usuario usuario = new Usuario( id,  nome, login,  senha,  perfil);
                usuarios.add(usuario);
            }
            request.setAttribute("dados", usuarios);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html>teste<html>");
            request.getRequestDispatcher("/usuarios.jsp").forward(request, response);
        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }
}

