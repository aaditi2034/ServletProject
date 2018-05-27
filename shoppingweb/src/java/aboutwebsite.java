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
@WebServlet(urlPatterns = {"/aboutwebsite"})
public class aboutwebsite extends HttpServlet {

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
                    out.print("<h1><center><font color='blue'>INFORMATION</font></center></h1>");
                   out.print("<p><font size='5'>Online shopping is a form of electronic commerce which allows consumers to directly buy goods or services from a seller over the Internet using a web browser. Consumers find a product of interest by visiting the website of the retailer directly or by searching among alternative vendors using a shopping search engine, which displays the same product's availability and pricing at different e-retailers. As of 2016, customers can shop online using a range of different computers and devices, including desktop computers, laptops, tablet computers and smartphones.\n" +
"<br>" +
"An online shop evokes the physical analogy of buying products or services at a regular \"bricks-and-mortar\" retailer or shopping center; the process is called business-to-consumer (B2C) online shopping. When an online store is set up to enable businesses to buy from another businesses, the process is called business-to-business (B2B) online shopping. A typical online store enables the customer to browse the firm's range of products and services, view photos or images of the products, along with information about the product specifications, features and prices.\n" +
"<br>" +
"Online stores typically enable shoppers to use \"search\" features to find specific models, brands or items. Online customers must have access to the Internet and a valid method of payment in order to complete a transaction, such as a credit card, an Interac-enabled debit card, or a service such as PayPal. For physical products (e.g., paperback books or clothes), the e-tailer ships the products to the customer; for digital products, such as digital audio files of songs or software, the e-tailer typically sends the file to the customer over the Internet. The largest of these online retailing corporations are Alibaba, Amazon.com, and eBay.</font></p>");
                out.write("<hr><img src='2.jpg' width='100%' height='50%'>");
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
