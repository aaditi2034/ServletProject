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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aditi
 */
@WebServlet(urlPatterns = {"/db"})
public class db extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occursstmt=con.prepareStatement("Create Table mobiles(mid int Primary Key,mname varchar(20),mprice int,qtyInStock int,Photo varchar(20))");
                stmt.executeUpdate();
                
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try{
                Class.forName("org.gjt.mm.mysql.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1","root","");
                PreparedStatement stmt=con.prepareStatement("Create database ShoppingWeb");
                stmt.executeUpdate();
                stmt=con.prepareStatement("use ShoppingWeb");
                stmt.executeUpdate();
                stmt=con.prepareStatement("Create Table products(pid int Primary Key,pcategory varchar(20),pname varchar(20),pprice int,qtyInStock int,Photo varchar(20))");
                stmt.executeUpdate();
                stmt=con.prepareStatement("Create Table Members(Email varchar(30) Primary Key,Name varchar(30),Mobile varchar(10),Address varchar(30),City varchar(30),State varchar(30),PinCode varchar(6),SecretQuestion varchar(40),answer varchar(30))");
                stmt.executeUpdate();
                stmt=con.prepareStatement("Create Table Users(email varchar(30),upass varchar(20),utype varchar(20))");
                stmt.executeUpdate();
                stmt=con.prepareStatement("Create Table Orders(Oderid int,Odate date,email varchar(30),TotalAmt int)");
                stmt.executeUpdate();
                stmt=con.prepareStatement("Create Table OrderItems(Oderid int,mid int,name varchar(30),price int,qty int)");
                stmt.executeUpdate();
                stmt=con.prepareStatement("Insert into users values('admin@yahoo.com','admin123','admin')");
                stmt.executeUpdate();
                for(int i=1;i<=25;i++)
                {
                    int price=(int)(Math.random()*150+10);
                    price=price+10000;
                    int qty=(int)(Math.random()*50+10);
                    int dt=(int)(Math.random()*29+1);
                    if(i<=5)
                    {
                    stmt=con.prepareStatement("Insert into products values(?,?,?,?,?,?)");
                    stmt.setInt(1,100+i);
                    stmt.setString(2,"Mobile");
                    stmt.setString(3,"Mobile "+i);
                    stmt.setInt(4,price);
                    stmt.setInt(5,qty);
                    stmt.setString(6,"p"+i+".jpg");
                    stmt.executeUpdate();
                    }
                    if(i>5&&i<=10)
                    {
                    stmt=con.prepareStatement("Insert into products values(?,?,?,?,?,?)");
                    stmt.setInt(1,100+i);
                    stmt.setString(2,"Laptop");
                    stmt.setString(3,"Laptop "+i);
                    stmt.setInt(4,price);
                    stmt.setInt(5,qty);
                    stmt.setString(6,"l"+i+".jpg");
                    stmt.executeUpdate();    
                    }
                    if(i>10&&i<=15)
                    {
                    stmt=con.prepareStatement("Insert into products values(?,?,?,?,?,?)");
                    stmt.setInt(1,100+i);
                    stmt.setString(2,"Tablet");
                    stmt.setString(3,"Tablet "+i);
                    stmt.setInt(4,price);
                    stmt.setInt(5,qty);
                    stmt.setString(6,"t"+i+".jpg");
                    stmt.executeUpdate();
                    }
                    if(i>15&&i<=20)
                    {
                    stmt=con.prepareStatement("Insert into products values(?,?,?,?,?,?)");
                    stmt.setInt(1,100+i);
                    stmt.setString(2,"Girls Wearr");
                    stmt.setString(3,"Girls Wear "+i);
                    stmt.setInt(4,price);
                    stmt.setInt(5,qty);
                    stmt.setString(6,"g"+i+".jpg");
                    stmt.executeUpdate();
                    }
                    if(i>20&&i<=25)
                    {
                    stmt=con.prepareStatement("Insert into products values(?,?,?,?,?,?)");
                    stmt.setInt(1,100+i);
                    stmt.setString(2,"Boys Wear");
                    stmt.setString(3,"Boys Wear "+i);
                    stmt.setInt(4,price);
                    stmt.setInt(5,qty);
                    stmt.setString(6,"b"+i+".jpg");
                    stmt.executeUpdate();
                    }
                }
                PrintWriter out=response.getWriter();
                out.write("Done");
        }catch(Exception ee){System.out.println(ee);}
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
