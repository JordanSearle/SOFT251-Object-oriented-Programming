/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Classes.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
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
@WebServlet(name = "conSave", urlPatterns = {"/conSave"})
public class conSave extends HttpServlet {

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
        HttpSession session = request.getSession();
        String ID=(String)session.getAttribute("ID");
        Prescription prescription = new Prescription();
        String numbers=String.valueOf(session.getAttribute("num"));
        int num = Integer.valueOf(numbers);
        Appointment app = new Appointment();
        for (Doctor doc : store.getDoctor()) {
                if (doc.getiDnum().equals(ID)) {
                     app = doc.getAppointment().get(num);
                }
            }

        
        String dNotes = request.getParameter("notes");
        String[] med = request.getParameterValues("medNum");
        String[] dos = request.getParameterValues("preDosage");
        String[] quan = request.getParameterValues("quantity");
        
        for (int i = 0; i < med.length; i++) {
            
            Medicine meds = new Medicine();
            for (int j = 0; j < store.getStock().get(0).getMedicine().size(); j++) {
            }
            int number = Integer.parseInt((String)Array.get(med, i));
            meds.setName(store.getStock().get(0).getMedicine().get(number).getName());
            meds.setDosage((String)Array.get(dos, i));
            int st = Integer.parseInt((String)Array.get(quan, i));
            meds.setQuantity(st);
            prescription.addMedicine(meds);
        }
        
        app.setCompleted(true);
        app.setDoctorNotes(dNotes);
        for (Patient patient : store.getPatient()) {
            if (patient.getiDnum().equals(app.getPatient().getiDnum())) {  
                patient.addPrescription(prescription);
            }
            System.out.println(patient.getPrescription().size());
        }
        
        //Save for Doctor
        for (Doctor doc : store.getDoctor()) {
            if (doc.getiDnum().equals(ID)) {
                doc.getAppointment().remove(num);
                doc.getAppointment().add(num, app);
            }
        }
        //Save for Patients
        for (Patient patient : store.getPatient()) {
            for (Appointment appointment : patient.getAppointments()) {
                if ((appointment.getDoctor().getiDnum()==ID)&&(appointment.getPatient()==app.getPatient())&&(appointment.getStartTime()==app.getStartTime())) {
                    appointment.equals(app);
                }
            }
        }
        store.writeObject();
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
            Logger.getLogger(conSave.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(conSave.class.getName()).log(Level.SEVERE, null, ex);
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
