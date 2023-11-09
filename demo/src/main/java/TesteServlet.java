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
@WebServlet("/TesteServlet")
public class TesteServlet extends HttpServlet {

    private Connection connection;
    public TesteServlet(){
        try{
            connection = ConnectionFactory.getConnection();
        }catch(SQLException e){
            System.out.println("erro Classe TesteServlet");
            e.printStackTrace();
        }
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recupere os parâmetros do formulário
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            // Inserir os dados do formulário no banco de dados
            String query = "INSERT INTO usuarios (username, password) VALUES (?, ?)";
            PreparedStatement stmp = connection.prepareStatement(query);
            stmp.setString(1, username);
            stmp.setString(2, password);
            stmp.executeUpdate();

            connection.close();
        } catch ( SQLException e) {
            e.printStackTrace();
        }

        // Responder ao navegador
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Login realizado com sucesso!</h1>");
        out.println("</body></html>");
    }
}

