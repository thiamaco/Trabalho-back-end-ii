package com.test.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.JogosDAO;

@WebServlet("/AprovarJogos")

public class AprovarJogos extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try{
            
            request.setAttribute("Jogos", JogosDAO.aprovar());
            request.getRequestDispatcher("views/aprovarJogos.jsp").forward(request, response);

        } catch ( Exception e) {
            e.printStackTrace();
        }
      }


      protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String id = request.getParameter("id");
            try{
                JogosDAO.aprovarjogo(Integer.parseInt(id));
                response.sendRedirect("/demo/AprovarJogos");
        } catch ( Exception e) {
            e.printStackTrace();
        }
      }

}
