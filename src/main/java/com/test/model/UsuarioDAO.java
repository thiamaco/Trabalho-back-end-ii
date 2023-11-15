package com.test.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.test.persist.ConnectionFactory;

public class UsuarioDAO {

    public UsuarioDAO() {
        try {
            ConnectionFactory.getConnection();
        } catch (SQLException e) {
            System.out.println("erro Classe UsuarioDAO");
            e.printStackTrace();
        }
    }

    public void adicionar(Usuario usuario) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO usuario (nome,login,senha,perfil) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getPerfil());
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Nao foi inserir na tabela contatos");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Usuario> usuarios() throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "select * from usuario";
            PreparedStatement stmt = connection.prepareStatement(sql);
            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    String login = resultSet.getString("login");
                    String senha = resultSet.getString("senha");
                    String perfil = resultSet.getString("perfil");
                    Usuario usuario = new Usuario(id, nome, login, senha, perfil);
                    usuarios.add(usuario);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usuarios;

    }

    public static String Validar(String email, String senha) {
        String tipo = "";
        try (Connection connection = ConnectionFactory.getConnection()) {
            String query = "SELECT *FROM  usuario where login = ? and senha =?";
            PreparedStatement stmp = connection.prepareStatement(query);
            stmp.setString(1, email);
            stmp.setString(2, senha);
            ResultSet resultSet = stmp.executeQuery();
            if (resultSet.next()) {
                tipo = resultSet.getString("perfil");
            }
            return tipo;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void mudarperfil(int id) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "UPDATE usuario set perfil = ? where id  = ?"; 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "usuario");
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Nao foi atualizar o perfil do usuario");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletar(int id) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "delete  from usuario where id = ?"; 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Nao foi deletar o do usuario");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int user(String email, String senha) {
        int id =0;
        try (Connection connection = ConnectionFactory.getConnection()) {
            String query = "SELECT *FROM  usuario where login = ? and senha =?";
            PreparedStatement stmp = connection.prepareStatement(query);
            stmp.setString(1, email);
            stmp.setString(2, senha);
            ResultSet resultSet = stmp.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return id;
    }
}
