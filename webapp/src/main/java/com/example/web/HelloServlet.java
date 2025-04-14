package com.example;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SimpleServlet extends HttpServlet {
  protected void doGet(HttpServletRequest req, HttpServletResponse res) 
      throws ServletException, IOException {
    System.out.println("REQUEST RECEIVED!");  // Shows in terminal
    res.getWriter().print("IT WORKS!");       // Browser response
  }
}