package com.test.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.JogosDAO;

@WebServlet("/Filtrar")
public class Filtrar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String mandante = request.getParameter("mandante");
        String visitante = request.getParameter("visitante");
        String estadio = request.getParameter("estadio");

        try {
            if (mandante.length() > 0 || visitante.length() > 0 || estadio.length() > 0) {
                request.setAttribute("Jogos", JogosDAO.filtrar(mandante, visitante, estadio));
            } else {
                request.setAttribute("Jogos", JogosDAO.jogos());
            }

            request.getRequestDispatcher("views/ListarJogos.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}