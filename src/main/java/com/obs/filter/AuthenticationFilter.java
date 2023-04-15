package com.obs.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = "/AuthenticationFilter")
public class AuthenticationFilter implements Filter {
    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        this.context.log("Requested Resource::"+uri);

        HttpSession session = req.getSession(false);

        if(!isValidSession(session) && !uri.equals("/login")){
            this.context.log("Unauthorized access request");
            res.sendRedirect("/login");
        }else if(isValidSession(session) && (uri.equals("/login") || uri.equals("/"))){
            res.sendRedirect("/home");
        }else{
            chain.doFilter(request, response);
        }
    }

    private boolean isValidSession(HttpSession session){
        if(session != null){
            String token = (String) session.getAttribute("token");
            if(token == null) {
                return false;
            }
            this.context.log("token : "+token);
            return true;
        }
        return false;
    }

    public void destroy() {}
}
