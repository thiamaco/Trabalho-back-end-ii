
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListarUsuariosServlet")
public class ListarUsuariosServlet extends HttpServlet {
    public class Usuario2 {
        private int id;
        private String nome;
        private String login;
        private String senha;
        private String perfil;
    
    
        public Usuario2(int id, String nome,String login, String senha, String perfil){
            this.id = id;
            this.nome = nome;
            this.login = login;
            this.senha = senha;
            this.perfil = perfil;
            
    
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       

        

        // Encaminha para a página JSP
        request.getRequestDispatcher("/listarUsuarios.jsp").forward(request, response);
    

     
        List<Usuario2> usuarios = new ArrayList<>();

            try (Connection connection = ConnectionFactory.getConnection()) {
                String sql = "SELECT * FROM usuario";
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet resultSet = stmt.executeQuery();
                 while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    String login = resultSet.getString("login");
                    String senha = resultSet.getString("senha");
                    //String perfil = resultSet.getString("perfil");
                    Usuario2 usuario = new Usuario2(1 ,"a","a","a","a");
                    usuarios.add(usuario);
                }

                request.setAttribute("usuarios", usuarios);
                //request.setAttribute("dados", usuarios);
            
        } catch ( SQLException e) {
            e.printStackTrace();
        }

   
    }

}
