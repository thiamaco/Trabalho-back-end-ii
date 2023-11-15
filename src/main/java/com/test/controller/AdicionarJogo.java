
package com.test.controller;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.Jogos;
import com.test.model.JogosDAO;

@WebServlet("/AdicionarJogo")

public class AdicionarJogo extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_jogo = Integer.parseInt(request.getParameter("ID"));
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        Date horario = Date.valueOf(request.getParameter("horario"));
        String madante = request.getParameter("casa");
        int gol_mandante = Integer.parseInt(request.getParameter("gol_mandante"));
        String visitante = request.getParameter("visitante");
        int gol_visitante = Integer.parseInt(request.getParameter("gol_visitante"));
        String estadio = request.getParameter("estadio");
        JogosDAO jdao = new JogosDAO();
        Jogos jogo = new Jogos(id_jogo,id_usuario, horario, madante, gol_mandante, visitante, gol_visitante, estadio, false);
        jdao.adicionar(jogo);
        response.sendRedirect("views/registrodejogos.jsp");
    }   
}