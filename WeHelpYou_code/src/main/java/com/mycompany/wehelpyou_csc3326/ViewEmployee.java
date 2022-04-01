/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.wehelpyou_csc3326;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author hp
 */
@WebServlet(name = "ViewEmployee", urlPatterns = {"/ViewEmployee"})
public class ViewEmployee extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
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
            
            out.println("<title> Searching Employee</title>"); 
            out.println("<link rel=\"stylesheet\" href=\"assets/css/main.css\" />");
            out.println("<noscript>\n" + "<link rel=\"stylesheet\" href=\"assets/css/noscript.css\" />\n" + "</noscript>");
            
            out.println("</head>");
            out.println("<body>");
             out.println("<h1><center>Employee found</center></h1>");
            String user_id_emp = request.getParameter("user_id_emp");
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

if (conn != null ) {
String qry = String.format("SELECT user_id, user_fname,user_lname, user_email, user_phone"
+ " FROM Cashier WHERE user_id = '%s'", user_id_emp);

Statement stmt = conn.createStatement();
// Result set get the result of the SQL query
ResultSet rs = stmt.executeQuery(qry);
ResultSetMetaData rsmd = rs.getMetaData();
int c = rsmd.getColumnCount();
out.println("<table border=4 width=70% height=70%>");
out.println("<tr><th>emp ID</th><th>emp fname</th><th>emp lname</th><th>emp email</th><th>emp phone</th>");
while (rs.next())                  
{
String n = rs.getString("user_id");
String nm = rs.getString("user_fname");
String d = rs.getString("user_lname");
String o = rs.getString("user_email");
String s = rs.getString("user_phone");
out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + d + "</td><td>" + o + 
"</td><td>" + s + "</td></tr>");
}
out.println("</table>");

//stmt.execute();
} // end of try
}
}
catch (SQLException ex) {
out.println("SQLException: " + ex);
}
catch (Exception e) {
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
            out.println("</htm}\n" +"l>");
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
