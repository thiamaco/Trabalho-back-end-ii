
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/VerificaLogin")
public class VerificaLogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        if (Valida(email)) {
            response.sendRedirect("registrodejogos.html");
        } else {
            response.sendRedirect("criarconta.html");
        }
            }

    private boolean Valida(String email) {
        try (Connection connection = ConnectionFactory.getConnection()) {

            String query = "SELECT *FROM  usuario where login = ?";
            PreparedStatement stmp = connection.prepareStatement(query);
            stmp.setString(1, email);
            ResultSet resultSet = stmp.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
