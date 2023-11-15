package com.test.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.test.model.JogosDAO;

@WebServlet("/DeletarJogo")

public class DeletarJogo extends HttpServlet {

      protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String id = request.getParameter("id_jogo");
                String lista = request.getParameter("lista");
                
            try{
                JogosDAO.delete(Integer.parseInt(id));
                if(lista.contains("5")){
                    response.sendRedirect("/demo/Jogos");
                }else{
                response.sendRedirect("/demo/AprovarJogos");
                }
                
        } catch ( Exception e) {
            e.printStackTrace();
        }
      }
    
}
