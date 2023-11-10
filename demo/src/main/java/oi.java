

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/oi")
public class oi extends HttpServlet {
   ArrayList<Usuario2> Usuarios = new ArrayList<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
            
          try (Connection connection = ConnectionFactory.getConnection()){
            //Map<String, Object> model = new HashMap<>();
            
            String sql = "select * from usuario";
            PreparedStatement stmt = connection.prepareStatement(sql);
            try (ResultSet resultSet = stmt.executeQuery()) {
               
              
               while (resultSet.next()) {  
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String perfil = resultSet.getString("perfil");
                Usuario2 usuario = new Usuario2();
                usuario.setId(id);
                usuario.setLogin(login);
                usuario.setNome(nome);
                usuario.setPerfil(perfil);
                usuario.setSenha(senha);
                Usuarios.add(usuario);
                System.out.println("teste"+usuario.getNome());
                }   
            }catch( Exception e){
                e.printStackTrace();
            }
            request.setAttribute("usuarios", Usuarios);
            request.getRequestDispatcher("/listarUsuarios.jsp").forward(request, response);
            //model.put("usuarios", Usuarios);
for (int i = 0; i < Usuarios.size(); i++) {
            //Usuario2 usuarioAtual = Usuarios.get(i);
            System.out.println(i);
        }
            
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Pessoa no índice 0: " + Usuarios.get(0));

        for (Usuario2 usuario2 : Usuarios) {
            System.out.println(usuario2);
        }
        

    
      }

public class Usuario2 {
    private int id;
    private String nome;
    private String login;
    private String senha;
    private String perfil;

/* 
    public Usuario2(int id, String nome,String login, String senha, String perfil){
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
        

    }

   */ 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
}