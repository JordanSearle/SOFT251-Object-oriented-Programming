package Classes.StatePattern;

import Classes.Doctor;
import Classes.Patient;
import java.io.Serializable;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jordan
 */
public interface State extends Serializable{
    Date date = null;
    String patientNotes = null;
    String DoctorNotes = null;
    Patient patient = null;
    Doctor doctor = null;

    public Date getDate();

    public void setDate(Date date);

    public String getNotes();

    public void setNotes(String notes);

    public Patient getPatient();

    public void setPatient(Patient patient);

    public Doctor getDoctor();

    public void setDoctor(Doctor doctor);
    
    public void push(appState applicationState);
    public void printState();
}
