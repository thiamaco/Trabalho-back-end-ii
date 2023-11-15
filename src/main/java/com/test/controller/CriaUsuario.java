package com.test.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.test.model.UsuarioDAO;
import com.test.model.Usuario;

import javax.servlet.annotation.WebServlet;

@WebServlet("/CriaUsuario")
public class CriaUsuario extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String perfil = "novo";
       UsuarioDAO udao = new UsuarioDAO();
       Usuario usuario = new Usuario( nome, email, senha,perfil);
       udao.adicionar(usuario);
       response.sendRedirect("/demo/VerUsuarios");
    }
}

