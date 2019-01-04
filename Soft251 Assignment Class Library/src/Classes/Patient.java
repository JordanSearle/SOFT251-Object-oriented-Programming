package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Classes.DecoratorPattern.*;
import Classes.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Patient Class
 * @author Jordan Searle
 */
public class Patient extends User implements Serializable{

    
    public preferredGender Gender;
    private ArrayList<Prescription> prescription = new ArrayList();
    private ArrayList<Appointment> appointments = new ArrayList();
    
    /**
     * Default Constructor 
     */
    public Patient(){
        
    }
    
    /**
     * Selects a specific Medicine from an appointment and returns it's details
     * @param medicineID medicineID is the ArrayList medicine location
     * @param prescriptionID prescriptionID is the prescription ArrayList location
     * @return Returns the selected medicine
     */
    public Medicine Medicine(int medicineID, int prescriptionID){ 
        Prescription temp = prescription.get(prescriptionID);
        Medicine A = temp.returnMedicine(medicineID);
        return A;
    }

    /**
     * Adds a Fluid gender to the Patient
     * @param unique Unique is a String that contains the passed through data
     */
    public void selectFluidGender(String unique){        
        preferredGender temp = Gender;
        Gender = null;
        Gender = new Unique(temp,unique);
    }

    /**
     * Adds a prescription to the patient
     * @param prescription prescription is the value of the prescription being added
     */
    public void addPrescription(Prescription prescription){
        this.prescription.add(prescription);
    }

    /**
     * gets the Notes of a specific Prescription
     * @param location int location contains the location of the Notes in the ArrayList
     * @return
     */
    public String getNotes(int location){
        Prescription store = prescription.get(location);
        return store.getNotes();
    }
    //Getters and Setter

    /**
     * Gets the Gender of the Patient
     * @return Returns preferredGender Gender
     */
    public preferredGender getGender() {
        return Gender;
    }

    /**
     * Gets all the Patient Appointments
     * @return all the Patient Appointments
     */
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * Returns a Specific Appointment
     * @param i Location of the appointment in the ArrayList
     * @return Returns the selected appointment. 
     */
    public Appointment returnAppointment(int i){
        return appointments.get(i);
    }

    /**
     * Sets the ArrayList of Appointments
     * @param appointments Contains the entire list of appointments
     */
    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    /**
     * Adds a Single Appointment
     * @param appointment contains the specific appointment being added
     */
    public void addAppointment(Appointment appointment){
        this.appointments.add(appointment);
    }

    /**
     * Sets the Gender of the Patient as Female
     */
    public void setFemale() {
        this.Gender = new Female();
    }

    /**
     * Sets the Gender of the Patient as Male
     */
    public void setMale() {
        this.Gender = new Male();
    }

    /**
     * Returns the entire Prescription ArrayList
     * @return Returns the entire Prescription ArrayList
     */
    public ArrayList<Prescription> getPrescription() {
        return prescription;
    }

    /**
     * Sets the entire ArrayList of Prescriptions
     * @param prescription Passes through the entire ArrayList of Prescriptions
     */
    public void setPrescription(ArrayList<Prescription> prescription) {
        this.prescription = prescription;
    }
   
   
}
