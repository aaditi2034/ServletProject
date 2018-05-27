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
@WebServlet(urlPatterns = {"/register"})
public class register extends HttpServlet {

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
                if(request.getParameter("b1")!=null)
                {
                    stmt=con.prepareStatement("Insert into members values(?,?,?,?,?,?,?,?,?)");
                    stmt.setString(1,request.getParameter("t1"));
                    stmt.setString(2,request.getParameter("t3"));
                    stmt.setString(3,request.getParameter("t4"));
                    stmt.setString(4,request.getParameter("t5"));
                    stmt.setString(5,request.getParameter("t6"));
                    stmt.setString(6,request.getParameter("t7"));
                    stmt.setString(7,request.getParameter("t8"));
                    stmt.setString(8,request.getParameter("t9"));
                    stmt.setString(9,request.getParameter("t10"));
                    stmt.executeUpdate();
                    stmt=con.prepareStatement("Insert into users values(?,?,?)");
                    stmt.setString(1,request.getParameter("t1"));
                    stmt.setString(2,request.getParameter("t2"));
                    stmt.setString(3,"member");
                    stmt.executeUpdate();
                    response.sendRedirect("index");
                }
                PrintWriter out=response.getWriter();
                response.setContentType("text/html");
                String links="<td><a href='register'>REGISTER</a></td><td><a href='login'>LOGIN</a></td>";
                HttpSession hs=request.getSession(false);
                if(hs!=null)
                {
                    links="<td><a href='profile'>MY PROFILE</a></td><td><a href='logout'>LOGOUT</a></td>";
                }
                out.write("<html><body>");
                out.write("<img src='1.jpg' height='50%' width='100%'><hr>");
                out.write("<table border='0' width='100%'>");
                out.write("<tr><td><a href='index'>HOME</a></td>"+links+"<td><a href='basket'>BASKET</a></td><td><a href='bestdeals'>BEST DEALS</a></td><td><a href='contact'>CONTACT US</a></td><td><a href='aboutwebsite'>ABOUT WEBSITE</a></td></tr>");
                out.write("</table><hr>");
                out.write("<form method='post'>");
                out.write("<table align='center'>");
                out.write("<tr cellspacing=30><td>Email:</td><td><input type='email' name='t1'></td></tr>");
                out.write("<tr cellspacing=30><td>Password:</td><td><input type='password' name='t2'></td></tr>");
                out.write("<tr cellspacing=30><td>Name:</td><td><input type='text' name='t3'></td></tr>");
                out.write("<tr cellspacing=30><td>Mobile:</td><td><input type='text' name='t4'></td></tr>");
                out.write("<tr cellspacing=30><td>Address:</td><td><textarea name='t5'></textarea></td></tr>");
                out.write("<tr cellspacing=30><td>State:</td><td><input type='text' name='t6'></td></tr>");
                out.write("<tr cellspacing=30><td>City:</td><td><input type='text' name='t7'></td></tr>");
                out.write("<tr cellspacing=30><td>Pin Code:</td><td><input type='text' name='t8'></td></tr>");
                out.write("<tr cellspacing=30><td>Secret Question:</td><td><select name='t9'>");
                out.write("<option>First School?</option>");
                out.write("<option>Prefered Vacation</option>");
                out.write("<option>Dream Job</option>");
                out.write("<option>First Pet Name?</option>");
                out.write("</select></td></tr>");
                out.write("<tr cellspacing=30><td>Answer:</td><td><input type='text' name='t10'></td></tr>");
                out.write("<tr cellspacing=30><td></td><td><input type='submit' value='Register' name='b1'></td></tr>");
                out.write("</table></form>");
                out.write("<hr><img src='2.jpg' height='50%' width='100%'>");
                out.write("</body></html>");
        }catch(Exception ee){}
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
