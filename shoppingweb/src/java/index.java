/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aditi
 */
@WebServlet(urlPatterns = {"/index"})
public class index extends HttpServlet {

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
    {
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/ShoppingWeb","root","");
            PreparedStatement stmt;
            ResultSet rs;
            PrintWriter out=response.getWriter();
                response.setContentType("text/html");
                String links="<td><a href='register'>REGISTER</a></td><td><a href='login'>LOGIN</a></td>";
                HttpSession hs=request.getSession(false);
                if(hs!=null)
                {
                    links="<td><a href='profile'>MY PROFILE</a></td><td><a href='logout'>LOGOUT</a></td>";
                }
                out.write("<html><body>");
                out.write("<img src='1.jpg' width='100%' height='50%'><hr>");
                out.write("<table border='0' width='100%' align='center'>");
                out.write("<tr><td><a href='index'>HOME</a></td>"+links+"<td><a href='basket'>BASKET</a></td><td><a href='bestdeals'>BEST DEALS</a></td><td><a href='contact'>CONTACT US</a></td><td><a href='aboutwebsite'>ABOUT WEBSITE</a></td></tr>");
                out.write("</table><hr>");
                out.write("<table align=center>");
                out.write("<tr>");
                out.write("<td cellpadding='50px' cellspacing='50px'><a href='mobile'><img src='buymobile.jpg' height='100%'></a></td>");
                out.write("<td><a href='tablet'><img src='buytablet.jpg' height='100%'></a></td>");
                out.write("</tr>");
                out.write("<tr>");
                out.write("<td align='center'>BUY MOBILES</td><td align='center'>BUY TABLETS</td>");
                out.write("</tr>");
                out.write("<tr>");
                out.write("<td cellpadding='50px' cellspacing='50px' colspan=2 align='center'><a href='laptop'><img src='buylaptop.jpg' height='100%'></a></td>");
                out.write("</tr>");
                out.write("<tr>");
                out.write("<td align='center' colspan=2>BUY LAPTOPS</td>");
                out.write("</tr>");
                out.write("<tr>");
                out.write("<td cellpadding='50px' cellspacing='50px' align='center'><a href='girlswear'><img src='buygirlcloth.jpg' height='100%'></a></td>");
                out.write("<td cellpadding='50px' cellspacing='50px' align='center'><a href='boyswear'><img src='buymenswear.jpg' height='100%'></a></td>");
                out.write("</tr>");
                out.write("<tr>");
                out.write("<td align='center'>BUY GIRLS WEAR</td><td align='center'>BUY BOYS WEAR</td>");
                out.write("</tr>");
                out.write("</table>");
                out.write("<img src='2.jpg' width='100%' height='50%'><hr>");
        }catch(Exception e){};
     
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
