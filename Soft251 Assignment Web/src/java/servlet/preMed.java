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

/**
 *
 * @author Jordan Searle
 */
@WebServlet(name = "preMed", urlPatterns = {"/preMed"})
public class preMed extends HttpServlet {

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
        String medName = request.getParameter("stockName");
        String idNUM = request.getParameter("idNUM");
        String tempNum = request.getParameter("medNum");
        int number = Integer.parseInt(tempNum);
        
        for (Medicine med : store.getStock().get(0).getMedicine()) {
            for (Patient patient : store.getPatient()) {
            if (patient.getiDnum().equals(idNUM)) {
                for (int i = 0; i < patient.getPrescription().get(number).getMedicine().size(); i++) {
                    if (patient.getPrescription().get(number).getMedicine().get(i).getName().equals(med.getName())) {
                        if (med.getStock()>=patient.getPrescription().get(number).getMedicine().get(i).getQuantity()) {
                            int amount = med.getStock()-patient.getPrescription().get(number).getMedicine().get(i).getQuantity();
                            patient.getPrescription().get(number).getMedicine().get(i).setPrescribed(Boolean.TRUE);
                          med.setStock(amount);
                          store.writeObject();
                        }
                    }
                }
            }
        }
        }
        response.sendRedirect("history.jsp");
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
            Logger.getLogger(preMed.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(preMed.class.getName()).log(Level.SEVERE, null, ex);
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
