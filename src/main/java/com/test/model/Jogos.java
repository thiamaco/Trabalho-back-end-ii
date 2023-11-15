package com.test.model;
import java.sql.Date;

public class Jogos {
    private int idJogo;
    private int idUsuario;
    private Date horario;
    private String mandante;
    private int golMandante;
    private String visitante;
    private int golVisitante;
    private String estadio;
    private boolean aprovado;
    private String create;

    


    public Jogos(int id_jogo, int idUsuario, Date horario, String mandante, int golMandante, String visitante,
                int golVisitante, String estadio, boolean aprovado) {
        this.idJogo = id_jogo;
        this.idUsuario = idUsuario;
        this.horario = horario;
        this.mandante = mandante;
        this.golMandante = golMandante;
        this.visitante = visitante;
        this.golVisitante = golVisitante;
        this.estadio = estadio;
        this.aprovado = aprovado;
    }

   
       public Jogos( int idUsuario, Date horario, String mandante, int golMandante, String visitante,
                int golVisitante, String estadio, boolean aprovado) {
        
        this.idUsuario = idUsuario;
        this.horario = horario;
        this.mandante = mandante;
        this.golMandante = golMandante;
        this.visitante = visitante;
        this.golVisitante = golVisitante;
        this.estadio = estadio;
        this.aprovado = aprovado;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public String getMandante() {
        return mandante;
    }

    public void setMandante(String mandante) {
        this.mandante = mandante;
    }

    public int getGolMandante() {
        return golMandante;
    }

    public void setGolMandante(int golMandante) {
        this.golMandante = golMandante;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public int getGolVisitante() {
        return golVisitante;
    }

    public void setGolVisitante(int golVisitante) {
        this.golVisitante = golVisitante;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public String getCreate() {
        return create;
    }


    public void setCreate(String create) {
        this.create = create;
    }
}
