
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CriaUsuario")
public class CriaUsuario extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        try (Connection connection = ConnectionFactory.getConnection()){
            
            // Inserir os dados do formulário no banco de dados
            String sql = "INSERT INTO usuario (nome,login,senha,perfil) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha);
            stmt.setString(4, "usuario");
            stmt.execute();
            stmt.close();
        } catch ( SQLException e) {
            e.printStackTrace();
        }

        // Responder ao navegador
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Usuario Criado ADA!</h1>");
        out.println("</body></html>");
    }
}

