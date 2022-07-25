package com.lvl80.servlet;

import com.lvl80.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class MainPageServlet extends HttpServlet {
    private User user = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String[] param = {"name","password","login"};
        if (cookies != null){
            user = new User();
            for (Cookie cookie : cookies){
                if (cookie.getName().equals(param[0])){
                    user.setName(cookie.getValue());
                } else if (cookie.getName().equals(param[1])) {
                    user.setPassword(cookie.getValue());
                } else if (cookie.getName().equals(param[2])) {
                    user.setLogin(cookie.getValue());
                }
            }
        }
        String path = (user == null) ? "/login.html" : "/index.jsp";
        if (path.equals("/index.jsp")) {
            getServletContext().setAttribute("user", user);
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user = new User(
                req.getParameter("name"),
                req.getParameter("password"),
                req.getParameter("login")
        );
        Cookie[] cookies = {
                new Cookie("name", URLEncoder.encode( user.getName(), StandardCharsets.UTF_8 )),
                new Cookie("password",URLEncoder.encode( user.getPassword(), StandardCharsets.UTF_8 ) ),
                new Cookie("login",URLEncoder.encode( user.getLogin(), StandardCharsets.UTF_8 ) )
        };
        for (Cookie cookie : cookies){
            resp.addCookie(cookie);
        }
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(user.getName() + user.getPassword() + user.getLogin());
        printWriter.close();
    }
}
