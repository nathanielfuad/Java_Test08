package com.obs.servlet;

import com.obs.utils.Utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private ServletContext context;
    private Utils utils;
    private static String userId = "admin";
    private static String password = "admin";

    public void init() {
        this.utils = new Utils();
        this.context = getServletContext();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        context.log("START - LOGIN GET");
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        context.log("END - LOGIN GET");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        context.log("START - LOGIN POST");
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String error = "";
        if(!userId.equals(LoginServlet.userId) || !password.equals(LoginServlet.password)){
            context.log("LOGIN FAILED");
            error = "Invalid user id or password";
            req.setAttribute("error", error);
            PrintWriter out = resp.getWriter();
            out.println("error:"+error);
        }else{
            context.log("LOGIN SUCCESS");
            HttpSession session = req.getSession();
            session.setAttribute("token", utils.generateSession());
            session.setAttribute("userId", userId);
            context.log("REDIRECTING TO HOME");
            resp.sendRedirect("/home");
        }
        context.log("END - LOGIN POST");
    }

    public void destroy() {
    }
}