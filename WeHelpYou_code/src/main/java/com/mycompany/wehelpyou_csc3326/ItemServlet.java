/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.wehelpyou_csc3326;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.*;
import javax.sql.*;
import java.sql.*;

/**
 *
 * @author hp
 */
@WebServlet(name = "ItemServlet", urlPatterns = {"/Item"})
public class ItemServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @throws ServletException if a servlet-specific
     * @param request servlet request
     * @param response servlet response error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");

            out.println("<title>List of Items</title>"); 
            out.println("<link rel=\"stylesheet\" href=\"assets/css/main.css\" />");
            out.println("<noscript>\n" + "<link rel=\"stylesheet\" href=\"assets/css/noscript.css\" />\n" + "</noscript>");
           
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><center>Items</center></h1>");
try {
Context ctx = new InitialContext();
if (ctx == null) {
throw new Exception("Error - No Context");
}

// /jdbc/postgres is the name of the resource in
DataSource ds = (DataSource)
ctx.lookup("java:/comp/env/jdbc/postgres");
if (ds != null) {
Connection conn = ds.getConnection();
if (conn != null) {
Statement stmt = conn.createStatement();
out.println("<table border=4 width=70% height=70%>");
ResultSet rst = stmt.executeQuery("SELECT item_code, description, in_date, qoh, price, discount_rate from Item;");
out.println("<tr><th>Item code</th><th>Description</th><th>In Date</th><th>QOH</th><th>Price</th><th>Discount Rate</th>");
while (rst.next()) {
out.print("<tr>");
out.print("<td>" + rst.getString(1) + "</td>");
out.print("<td>" + rst.getString(2) + "</td>");
out.print("<td>" + rst.getDate(3) + "</td>");
out.print("<td>" + rst.getInt(4) + "</td>");
out.print("<td>" + rst.getFloat(5) + "</td>");
out.print("<td>" + rst.getFloat(6) + "</td>");
out.print("</tr>");
}
conn.close();
out.println("</table>");
} else {
out.println("Error: conn is null ");
}
}
} catch (Exception e) {
//e.printStackTrace();
out.println("Exception caught");
out.println(e.toString());
}
            
            out.println("<script src=\"assets/js/jquery.min.js\"></script>");
            out.println("<script src=\"assets/js/browser.min.js\"></script>");
            out.println("<script src=\"assets/js/breakpoints.min.js\"></script>");
            out.println("<script src=\"assets/js/util.js\"></script>");
            out.println("<script src=\"assets/js/main.js\"></script>");
            out.println("</body>");
            out.println("</html>");

        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}