package com.saturn.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //session
        //HttpSession session = req.getSession();
       //application
       // ServletContext application = req.getServletContext();

        doPut(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        String action = req.getParameter("action");
        if (username.equals("admin")&&pwd.equals("123456")){
           resp.sendRedirect("logins.jsp");
       }else{
           resp.sendRedirect("index.jsp");
       }
       if (action.equals("add")){
           System.out.println("增加");
       }
    }
}
