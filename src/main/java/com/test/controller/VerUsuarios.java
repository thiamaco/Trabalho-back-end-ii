package com.test.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.test.model.UsuarioDAO;
@WebServlet("/VerUsuarios")

public class VerUsuarios extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try{
            request.setAttribute("Usuarios", UsuarioDAO.usuarios());
            request.getRequestDispatcher("views/listarUsuarios.jsp").forward(request, response);

        } catch ( Exception e) {
            e.printStackTrace();
        }
      }

}


