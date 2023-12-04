package com.test.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.UsuarioDAO;

@WebServlet("/VerificaLogin")
public class VerificaLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String tipo = UsuarioDAO.Validar(email, senha);
        int id_usuario = UsuarioDAO.user(email, senha);
        String encodedEmail = java.net.URLEncoder.encode(email, "UTF-8");
        Cookie userCookie = new Cookie("user", encodedEmail);
        userCookie.setPath("/");       
        response.addCookie(userCookie);
        if (tipo.contains("usuario")) {
            request.getSession().setAttribute("usuarioAutenticado", "usuario");
            request.getSession().setAttribute("idAutenticado", id_usuario);
            response.sendRedirect("/demo/views/registrodejogos.jsp");
        } else if (tipo.contains("admin")) {
            request.getSession().setAttribute("usuarioAutenticado", "admin");
            response.sendRedirect("VerUsuarios");
        } else {
            response.sendRedirect("views/criarconta.jsp");
        }
    }
}
