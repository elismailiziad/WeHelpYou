package com.mycompany.wehelpyou_csc3326;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

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
import java.text.SimpleDateFormat; 
/**
 *
 * @author hp
 */
@WebServlet(urlPatterns = {"/addproduct"})
public class AddItem extends HttpServlet {

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
            out.println("<title>Adding Items</title>"); 
            
            out.println("<title>Searching Items</title>"); 
            out.println("<link rel=\"stylesheet\" href=\"assets/css/main.css\" />");
            out.println("<noscript>\n" + "<link rel=\"stylesheet\" href=\"assets/css/noscript.css\" />\n" + "</noscript>");
            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><center>Adding Item</center></h1>");
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
// the insert statement
String qry = "INSERT INTO Item "+ " (item_code,"
        + " description, in_date, qoh, discount_rate, price)"
+ " VALUES (?, ?, ?, ?, ?, ?);";
// create the insert preparedstatement
PreparedStatement prepStmt = conn.prepareStatement(qry);
String Pcode = request.getParameter("item_code2");
String Desc = request.getParameter("desc");
String Ind = request.getParameter("ii");
String QOH = request.getParameter("qq");
String Discountrate = request.getParameter("dd");
String price = request.getParameter("pp");
prepStmt.setString (1, Pcode);
prepStmt.setString (2, Desc);
SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date utilDate = formatdate.parse(Ind);
java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
prepStmt.setDate (3, sqlDate);
prepStmt.setInt (4, Integer.parseInt(QOH));
prepStmt.setFloat (5, Float.parseFloat(Discountrate));
prepStmt.setFloat (6, Float.parseFloat(price));
// execute the preparedstatement
prepStmt.execute();
out.println("<center>Item Added Sucessfully</center>");

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
