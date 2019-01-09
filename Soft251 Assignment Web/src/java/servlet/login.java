/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Classes.accountStore;
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
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

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
        String name = request.getParameter("uname");
        String password = request.getParameter("pass");     
        
        accountStore store = new accountStore();
        store = store.readObject();     
        HttpSession session = request.getSession();
        boolean boo = true;
        
        for (int i = 0; i < store.getAdmin().size(); i++) {
            if (name == null ? store.getAdmin().get(i).getUsername() == null : name.equals(store.getAdmin().get(i).getUsername())) {
                if (password == null ? store.getAdmin().get(i).getPassword() == null : password.equals(store.getAdmin().get(i).getPassword())) {
                session.setAttribute("username", name);
                session.setAttribute("name", store.getAdmin().get(i).returnFullName());
            }
            }
        }
        
        for (int i = 0; i < store.getDoctor().size(); i++) {
            if (name == null ? store.getDoctor().get(i).getUsername() == null : name.equals(store.getDoctor().get(i).getUsername())) {
                if (password == null ? store.getDoctor().get(i).getPassword() == null : password.equals(store.getDoctor().get(i).getPassword())) {
                session.setAttribute("username", name);
                session.setAttribute("name", store.getDoctor().get(i).returnFullName());
            }
            }
        }
        for (int i = 0; i < store.getSecretary().size(); i++) {
            if (name == null ? store.getSecretary().get(i).getUsername() == null : name.equals(store.getSecretary().get(i).getUsername())) {
                if (password == null ? store.getSecretary().get(i).getPassword() == null : password.equals(store.getSecretary().get(i).getPassword())) {
                session.setAttribute("username", name);
                session.setAttribute("name", store.getSecretary().get(i).returnFullName());
            }
            }
        }
        
        for (int i = 0; i < store.getPatient().size(); i++) {
            if (name == null ? store.getPatient().get(i).getUsername() == null : name.equals(store.getPatient().get(i).getUsername())) {
                if (password == null ? store.getPatient().get(i).getPassword() == null : password.equals(store.getPatient().get(i).getPassword())) {
                session.setAttribute("username", name);
                session.setAttribute("name", store.getPatient().get(i).returnFullName());
            }
            }
        }
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
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
