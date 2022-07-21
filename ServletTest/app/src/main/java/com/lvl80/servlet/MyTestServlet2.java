package com.lvl80.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/second")
public class MyTestServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("path");
        if (path != null) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(path);
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/first");
        }
    }
}
