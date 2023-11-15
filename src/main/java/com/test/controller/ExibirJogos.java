package com.test.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.JogosDAO;

@WebServlet("/Jogos")

public class ExibirJogos extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try{
                    request.setAttribute("Jogos", JogosDAO.jogos());
                    request.getRequestDispatcher("views/ListarJogos.jsp").forward(request, response);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
}