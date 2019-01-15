/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Classes.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
@WebServlet(name = "appointments", urlPatterns = {"/appointments"})
public class appointments extends HttpServlet {

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
        String name = request.getParameter("PID");
        String dname = request.getParameter("DID");
        int docnum = Integer.parseInt(dname);
        String pnotes = request.getParameter("pnotes");
        String stime = request.getParameter("sdate");
        String ftime = request.getParameter("fdate");;
        
        accountStore store = new accountStore();
        store = store.readObject();
        
        for (int i = 0; i < store.getPatient().size(); i++) {
            if (name.equals(store.getPatient().get(i).getiDnum())) {
                
                
                Appointment app = new Appointment();
                app.setDoctor(store.getDoctor().get(docnum));
                               
                app.setPatient(store.getPatient().get(i));
                app.setPatientNotes(pnotes);
                
                LocalDateTime startTime = LocalDateTime.parse(stime);
                
                LocalDateTime finishTime = LocalDateTime.parse(ftime);     
                
                app.setStartTime(startTime);
                app.setFinishTime(finishTime);
                store.getSecretary().get(0).addAppointments(app);
                store.writeObject();
            }
        }
        response.sendRedirect("appointments.jsp");
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
            Logger.getLogger(appointments.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(appointments.class.getName()).log(Level.SEVERE, null, ex);
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

