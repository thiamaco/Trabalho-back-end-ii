package com.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readCookie")
public class ReadCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String Name = null;
        String visitHistory = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    Name = cookie.getValue();
                } else if (cookie.getName().equals("Ultima_pagina_visitada")) {
                    visitHistory = cookie.getValue();
                }
            }
        }
        response.getWriter().println("<h2>Informações dos Cookies:</h2>");
        response.getWriter().println("<p>Nome do Usuário: " + Name + "</p>");
        response.getWriter().println("<p>Última Visita: " + visitHistory + "</p>");
        
    }
}
