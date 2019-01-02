package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Classes.DecoratorPattern.*;
import Classes.StatePattern.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Jordan Searle
 */
public class Patient extends User implements Serializable{
    public preferredGender Gender;
    private ArrayList<Prescription> prescription = new ArrayList();
    private ArrayList<Appointment> appointments = new ArrayList();
    
    public Patient(){
        
    }
    
     public Medicine Medicine(int i, int g){ 
        Prescription temp = prescription.get(i);
        Medicine A = temp.returnMedicine(g);
        return A;
    }
    public void selectFluidGender(String unique){        
        preferredGender temp = Gender;
        Gender = null;
        Gender = new Unique(temp,unique);
    }
    public void addPrescription(Prescription prescription){
        this.prescription.add(prescription);
    }
    public String getNotes(int i){
        Prescription store = prescription.get(i);
        return store.getNotes();
    }
    //Getters and Setter
    public preferredGender getGender() {
        return Gender;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }
    public Appointment returnAppointment(int i){
        return appointments.get(i);
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }
    public void addAppointment(Appointment appointment){
        this.appointments.add(appointment);
    }

    public void setFemale() {
        this.Gender = new Female();
    }
    public void setMale() {
        this.Gender = new Male();
    }

    public ArrayList<Prescription> getPrescription() {
        return prescription;
    }

    public void setPrescription(ArrayList<Prescription> prescription) {
        this.prescription = prescription;
    }
   
   
}
