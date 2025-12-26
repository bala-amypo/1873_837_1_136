package com.example.demo.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleStatusServlet extends HttpServlet {

    // ❗ MUST BE PUBLIC (tests call it directly)
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/plain");
        resp.getWriter().write("SimpleStatusServlet is running");
    }
}
