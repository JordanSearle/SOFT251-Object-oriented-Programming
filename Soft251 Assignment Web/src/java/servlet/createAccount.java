package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
@WebServlet(urlPatterns = {"/createAccount"})
public class createAccount extends HttpServlet {

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
       String username = request.getParameter("username");;
       String Password = request.getParameter("password");;
       String Fname = request.getParameter("Forename");
       String Sname = request.getParameter("Surname");
       String address = request.getParameter("address");
       String addressTwo = request.getParameter("addressTwo");
       String City = request.getParameter("City");
       String PostCode = request.getParameter("Postcode");
       String Gender = request.getParameter("Bgender");
       String PGender = request.getParameter("Pgender");
       String DOB = request.getParameter("DOB");
       
       Patient patient = new Patient();
       patient.setUsername(username);
       patient.setPassword(Password);
       patient.setForename(Fname);
       patient.setSurname(Sname);
       patient.setAddressLineOne(address);
       patient.setAddressLineTwo(addressTwo);
       patient.setCity(City);
       patient.setPostcode(PostCode);
       LocalDate dateBirth = LocalDate.parse(DOB);     
       
       patient.setDateOfBirth(dateBirth);
       patient.calculateAge();
       if (Gender.equals("0")) {
            patient.setMale();
        } else{
            patient.setFemale();
        }
        if (PGender != null) {
            patient.selectFluidGender(PGender);
        }
        patient.setiDnum("P"+1000+(store.getPatient().size()+1+store.getSecretary().get(0).getPatients().size()));
        store.getSecretary().get(0).getApprovePatient().add(patient);
        store.writeObject();
        response.sendRedirect("index.jsp");
        
        
        
        
        
       
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
            Logger.getLogger(createAccount.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(createAccount.class.getName()).log(Level.SEVERE, null, ex);
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
