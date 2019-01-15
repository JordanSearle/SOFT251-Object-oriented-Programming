/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Classes.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jordan Searle
 */
@WebServlet(name = "saveUser", urlPatterns = {"/saveUser"})
public class saveUser extends HttpServlet {

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
       HttpSession session = request.getSession();
       String ID = String.valueOf(session.getAttribute("ID"));
       accountStore store = new accountStore();
       store = store.readObject();
       String Fname = request.getParameter("Forename");
       String Sname = request.getParameter("Surname");
       String address = request.getParameter("address");
       String addressTwo = request.getParameter("addressTwo");
       String City = request.getParameter("City");
       String PostCode = request.getParameter("Postcode");
       String Gender = request.getParameter("Bgender");
       
        for (int i = 0; i < store.getPatient().size(); i++) {
            if (store.getPatient().get(i).getiDnum().equals(ID)) {
                store.getPatient().get(i).setForename(Fname);
                store.getPatient().get(i).setSurname(Sname);
                store.getPatient().get(i).setAddressLineOne(address);
                store.getPatient().get(i).setAddressLineTwo(addressTwo);
                store.getPatient().get(i).setCity(City);
                store.getPatient().get(i).setPostcode(PostCode);
                if (Gender.equals("0")) {
                    store.getPatient().get(i).setMale();
                } else{
                    store.getPatient().get(i).setFemale();
                }
                store.writeObject();
                session.setAttribute("name", store.getPatient().get(i).returnFullName());
            }
        }
        response.sendRedirect("account.jsp");
               
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
            Logger.getLogger(saveUser.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(saveUser.class.getName()).log(Level.SEVERE, null, ex);
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
