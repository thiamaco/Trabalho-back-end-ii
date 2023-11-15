package com.test.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.test.persist.ConnectionFactory;

public class JogosDAO {
    public JogosDAO() {
        try {
            ConnectionFactory.getConnection();
        } catch (SQLException e) {
            System.out.println("erro Classe JogosDAO");
            e.printStackTrace();
        }

    }

    public static ArrayList<Jogos> jogos() {
        ArrayList<Jogos> jogos = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()) {
            // String sql = "select * from jogos";
            String sql = "SELECT jogos.id_jogo, jogos.id_usuario, jogos.horario, jogos.mandante, jogos.gol_mandante, jogos.visitante, jogos.gol_visitante,"
                    +
                    "jogos.estadio, jogos.aprovado, usuario.nome as createby FROM jogos INNER JOIN usuario ON jogos.id_usuario = usuario.id where aprovado= true";

            PreparedStatement stmt = connection.prepareStatement(sql);
            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    int idJodo = resultSet.getInt("id_jogo");
                    int id = resultSet.getInt("id_usuario");
                    Date horario = resultSet.getDate("horario");
                    String mandante = resultSet.getString("mandante");
                    int golMandante = resultSet.getInt("gol_mandante");
                    String visitante = resultSet.getString("visitante");
                    int golVisitante = resultSet.getInt("gol_visitante");
                    String estadio = resultSet.getString("estadio");
                    boolean aprovado = resultSet.getBoolean("aprovado");
                    String create = resultSet.getString("createby");
                    Jogos jogo = new Jogos(idJodo, id, horario, mandante, golMandante, visitante, golVisitante, estadio,
                            aprovado);
                    jogo.setCreate(create);
                    jogos.add(jogo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jogos;
    }

    public void adicionar(Jogos jogos) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO jogos (id_jogo, id_usuario, horario, mandante, gol_mandante, visitante, gol_visitante, estadio, aprovado) VALUES (?, ?, ?, ?, ?, ?,?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, jogos.getIdJogo());
            stmt.setInt(2, jogos.getIdUsuario());
            stmt.setDate(3, jogos.getHorario());
            stmt.setString(4, jogos.getMandante());
            stmt.setInt(5, jogos.getGolMandante());
            stmt.setString(6, jogos.getVisitante());
            stmt.setInt(7, jogos.getGolVisitante());
            stmt.setString(8, jogos.getEstadio());
            stmt.setBoolean(9, jogos.isAprovado());
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Nao foi inserir na tabela jogos");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Jogos> aprovar() {
        ArrayList<Jogos> jogos = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()) {
            // String sql = "select * from jogos";
            String sql = "SELECT jogos.id_jogo, jogos.id_usuario, jogos.horario, jogos.mandante, jogos.gol_mandante, jogos.visitante, jogos.gol_visitante,"
                    +
                    "jogos.estadio, jogos.aprovado, usuario.nome as createby FROM jogos INNER JOIN usuario ON jogos.id_usuario = usuario.id where aprovado = false";

            PreparedStatement stmt = connection.prepareStatement(sql);
            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    int idJodo = resultSet.getInt("id_jogo");
                    int id = resultSet.getInt("id_usuario");
                    Date horario = resultSet.getDate("horario");
                    String mandante = resultSet.getString("mandante");
                    int golMandante = resultSet.getInt("gol_mandante");
                    String visitante = resultSet.getString("visitante");
                    int golVisitante = resultSet.getInt("gol_visitante");
                    String estadio = resultSet.getString("estadio");
                    boolean aprovado = resultSet.getBoolean("aprovado");
                    String create = resultSet.getString("createby");
                    Jogos jogo = new Jogos(idJodo, id, horario, mandante, golMandante, visitante, golVisitante, estadio,
                            aprovado);
                    jogo.setCreate(create);
                    jogos.add(jogo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jogos;
    }

    public static void aprovarjogo(int id) {


        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "UPDATE jogos set aprovado = true where id_jogo  = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Nao foi possivel atualziar a tabela jogos");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



            public static ArrayList<Jogos> filtrar(String casa, String fora, String lugar) {
        ArrayList<Jogos> jogos = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT jogos.id_jogo, jogos.id_usuario, jogos.horario, jogos.mandante, jogos.gol_mandante, jogos.visitante,"
            +" jogos.gol_visitante, jogos.estadio, jogos.aprovado, usuario.nome as createby FROM jogos INNER JOIN usuario "
            +"ON jogos.id_usuario = usuario.id where aprovado = true and mandante= ?  or visitante= ? or estadio =? ";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,casa);
            stmt.setString(2,fora);
            stmt.setString(3,lugar);
            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    int idJodo = resultSet.getInt("id_jogo");
                    int id = resultSet.getInt("id_usuario");
                    Date horario = resultSet.getDate("horario");
                    String mandante = resultSet.getString("mandante");
                    int golMandante = resultSet.getInt("gol_mandante");
                    String visitante = resultSet.getString("visitante");
                    int golVisitante = resultSet.getInt("gol_visitante");
                    String estadio = resultSet.getString("estadio");
                    boolean aprovado = resultSet.getBoolean("aprovado");
                    String create = resultSet.getString("createby");
                    Jogos jogo = new Jogos(idJodo, id, horario, mandante, golMandante, visitante, golVisitante, estadio,
                            aprovado);
                    jogo.setCreate(create);
                    jogos.add(jogo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jogos;
    }

            public static void delete(int id) {

                try (Connection connection = ConnectionFactory.getConnection()) {
                    String sql = "delete  from jogos where id_jogo = ?";
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    stmt.setInt(1, id);
                    stmt.execute();
                    stmt.close();
                } catch (SQLException sqle) {
                    System.out.println("Nao foi deletar o jogo");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
          
}
