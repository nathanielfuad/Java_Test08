package com.obs.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    private ServletContext context;

    public void init() {
        this.context = getServletContext();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        context.log("START - LOGOUT POST");
        HttpSession session = req.getSession();
        session.invalidate();;

        resp.sendRedirect("/login");
        context.log("END - LOGOUT POST");

    }
}