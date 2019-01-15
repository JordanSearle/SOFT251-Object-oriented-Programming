/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Classes.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jordan Searle
 */
@WebServlet(name = "newUser", urlPatterns = {"/newUser"})
public class newUser extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        accountStore store = new accountStore();
        store = store.readObject();
        String userType = request.getParameter("userType");
        String username = request.getParameter("username");
        String Password = request.getParameter("password");
        String Fname = request.getParameter("Forename");
        String Sname = request.getParameter("Surname");
        String address = request.getParameter("address");
        String addressTwo = request.getParameter("addressTwo");
        String City = request.getParameter("City");
        String PostCode = request.getParameter("Postcode");
        String DOB = request.getParameter("DOB");
        LocalDate dateBirth = LocalDate.parse(DOB);   
        int user = Integer.parseInt(userType);
        switch(user){
            case 1:  
                Doctor doc = new Doctor();
                doc.setiDnum("D"+(1000+store.getDoctor().size()+1));
                doc.setUsername(username);
                doc.setPassword(Password);
                doc.setForename(Fname);
                doc.setSurname(Sname);
                doc.setAddressLineOne(address);
                doc.setAddressLineTwo(addressTwo);
                doc.setCity(City);
                doc.setPostcode(PostCode);
                doc.setDateOfBirth(dateBirth);
                store.getDoctor().add(doc);
                
                     break;
            case 2:  
                Secretary sec = new Secretary();
                sec.setiDnum("S"+(1000+store.getSecretary().size()+1));
                sec.setUsername(username);
                sec.setPassword(Password);
                sec.setForename(Fname);
                sec.setSurname(Sname);
                sec.setAddressLineOne(address);
                sec.setAddressLineTwo(addressTwo);
                sec.setCity(City);
                sec.setPostcode(PostCode);
                sec.setDateOfBirth(dateBirth);
                store.getSecretary().add(sec);
                     break;
                     case 3:  
                Administrator admin = new Administrator();
                admin.setiDnum("A"+(1000+store.getSecretary().size()+1));
                admin.setUsername(username);
                admin.setPassword(Password);
                admin.setForename(Fname);
                admin.setSurname(Sname);
                admin.setAddressLineOne(address);
                admin.setAddressLineTwo(addressTwo);
                admin.setCity(City);
                admin.setPostcode(PostCode);
                admin.setDateOfBirth(dateBirth);
                store.getAdmin().add(admin);
                     break;
        }
        store.writeObject();
        response.sendRedirect("accounts.jsp");
        
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(newUser.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(newUser.class.getName()).log(Level.SEVERE, null, ex);
        }
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
