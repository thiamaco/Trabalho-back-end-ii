
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Exibir")
public class ExibirUsuarios extends HttpServlet {
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       

          try (Connection connection = ConnectionFactory.getConnection()){
            String sql = "select * from usuario";
            PreparedStatement stmt = connection.prepareStatement(sql);
            try (ResultSet resultSet = stmt.executeQuery()) {
              while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String perfil = resultSet.getString("perfil");
                System.out.println("ID: " + id + ", Nome: " + nome +"Login: "+login+"senha: "+senha +"perfil: "+perfil) ;
               
                }   
            }catch( Exception e){
                e.printStackTrace();
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        }

   
    
      }
}
