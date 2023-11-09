import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdicionarJogo")
public class AdicionarJogo extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_jogo = Integer.parseInt(request.getParameter("ID"));
        Date horario = Date.valueOf(request.getParameter("horario"));
        String madante = request.getParameter("casa");
        int gol_mandante = Integer.parseInt(request.getParameter("gol_mandante"));
        String visitante = request.getParameter("visitante");
        int gol_visitante = Integer.parseInt(request.getParameter("gol_visitante"));
        String estadio = request.getParameter("estadio");
                        
        try (Connection connection = ConnectionFactory.getConnection()){
            String sql = "INSERT INTO jogos (id_jogo, id_usuario, horario, mandante, gol_mandante, visitante, gol_visitante, estadio) VALUES (?, ?, ?, ?, ?, ?,?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
             stmt.setInt(1, id_jogo);
            stmt.setInt(2, 1);
            stmt.setDate(3, horario);
            stmt.setString(4, madante);
            stmt.setInt(5, gol_mandante);
            stmt.setString(6, visitante);
            stmt.setInt(7,gol_visitante);
            stmt.setString(8, estadio);
            stmt.execute();
            stmt.close();


        } catch ( SQLException e) {
            e.printStackTrace();
        
        }
    }   
}
