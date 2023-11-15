package com.test.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.UsuarioDAO;
@WebServlet("/AprovarUsuario")
public class AprovarUsuario extends HttpServlet {

      protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String id = request.getParameter("id");
            try{
                UsuarioDAO.mudarperfil(Integer.parseInt(id));

                response.sendRedirect("/demo/VerUsuarios");
        } catch ( Exception e) {
            e.printStackTrace();
        }
      }
}
