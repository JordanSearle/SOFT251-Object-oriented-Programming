/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Secretary Class
 * @author Jordan Searle
 */
public class Secretary extends User implements Serializable{
    private static final long serialVersionUID = -8502678843666016948L;
    private ArrayList<Patient>approvePatient = new ArrayList();
    private ArrayList<Patient>approveDelPatient = new ArrayList();
    private ArrayList<Appointment>approveAppointment = new ArrayList();
    
    /**
     * Gets the Entire list of appointments waiting to be approved
     * @return The List of waiting appointments
     */
    public ArrayList<Appointment> getAppointments(){
        return approveAppointment;
    }

    /**
     * Returns ArrayList of pending new Patients
     * @return ArrayList for the pending Patients
     */
    public ArrayList<Patient> getApprovePatient() {
        return approvePatient;
    }

    /**
     * Sets the ArrayList of pending Patients
     * @param approvePatient ArrayList containing pending Patients
     */
    public void setApprovePatient(ArrayList<Patient> approvePatient) {
        this.approvePatient = approvePatient;
    }

    /**
     * Gets an ArrayList of pending deleted Patients
     * @return an ArrayList of pending deleted Patients
     */
    public ArrayList<Patient> getApproveDelPatient() {
        return approveDelPatient;
    }

    /**
     * Sets the ArrayList of pending Deleted Patients
     * @param approveDelPatient ArrayList of pending Deleted Patients
     */
    public void setApproveDelPatient(ArrayList<Patient> approveDelPatient) {
        this.approveDelPatient = approveDelPatient;
    }

    /**
     * Gets an ArrayList of pending appointments
     * @return an ArrayList of pending appointments
     */
    public ArrayList<Appointment> getApproveAppointment() {
        return approveAppointment;
    }

    /**
     * Sets the ArrayList of pending Appointments
     * @param approveAppointment the ArrayList of pending Appointments
     */
    public void setApproveAppointment(ArrayList<Appointment> approveAppointment) {
        this.approveAppointment = approveAppointment;
    }

    /**
     * Adds an appointment to the approval list
     * @param appointment Is the class that is being added to the approval List
     */
    public void addAppointments(Appointment appointment){
        approveAppointment.add(appointment);
    }

    /**
     * Deletes a selected appointment from the approval list
     * @param appointmentNum Int  for the location of the Appointment in the list
     */
    public void delAppointment(int appointmentNum){
        approveAppointment.remove(appointmentNum);
    }

    /**
     * Approves a selected appointment in the approval list
     * @param appointment appointment is the ArrayList which the appointment is being added to
     * @param appointmentNum appointmentNum is the index of the appointment being approved
     * @return The updated ArrayList with the approved appointment
     */
    public ArrayList<Appointment> approveAppointments(ArrayList<Appointment> appointment, int appointmentNum){
        ArrayList<Appointment>appointments = appointment;
        int number = appointmentNum;
        appointments.add(approveAppointment.get(number)); 
        return appointments;
    }

    /**
     * Approves a new Patient
     * @param patientNum Int containing the Index of the new patient in the ArrayList
     * @return Returns the new patient details 
     */
    public Patient approvePatient(int patientNum){
       Patient patient = approvePatient.get(patientNum);
       return patient;
    }

    /**
     * Adds a patient for approval
     * @param patient Contains the patient details being added
     */
    public void addPatient(Patient patient){
       approvePatient.add(patient);
    }
    /**
     * Returns Patient List
     * @return patient ArrayList
     */
    public ArrayList<Patient> getPatients(){
        return approvePatient;
    }

    /**
     * Removes a pending patient
     * @param numberPatient Int for the index of the Patient in the List
     */
    public void disprovePatient(int numberPatient){
        this.approvePatient.remove(numberPatient);
    }

    /**
     * Deletes an existing approved patient from an Int
     * @param patientNum Int where the patient is located in the List
     * @param patients ArrayList which the patient is removed from
     * @return Returns the updated ArrayList
     */
    public ArrayList<Patient>delPatient(int patientNum, ArrayList<Patient> patients){
        ArrayList<Patient> patient = patients;
        patient.remove(patientNum);
        return patient;
    }

    /**
     * Deletes an existing approved Patient from their Full Name
     * @param Patient Is the List which the Patient will be removed from
     * @param PatientFullName Is the Full Name of the patient which will be removed
     * @return Returns the updated ArrayList
     */
    public ArrayList<Patient> delPatient(ArrayList<Patient>Patient,String PatientFullName){
        ArrayList<Patient>Patients = Patient;
        String name = PatientFullName;
        for (int i = 0; i < Patients.size(); i++) {
            if (Patients.get(i).returnFullName() == name) {
                Patients.remove(i);
            }
        }
        return Patients;
    }
    
    /**
     * Uses a select amount of Medicine from the system
     * Sets the Medicine as being used in the Prescription
     * @param stock Class containing the Stock of the Medicine
     * @param patient Containing the Patient who will be prescribed the medicine to
     * @param prescription Containing the prescription the Medicines used
     * @return Returns the Updated Stock Class
     */
    public Stock useStock(Stock stock, Patient patient, Prescription prescription){
        Patient patientStore = patient;
        Stock stockStore = stock;
        //Copies the Patients Prescriptions
        ArrayList<Prescription> prescriptionStore = patientStore.getPrescription();
        ArrayList<Medicine> medicine = new ArrayList();
        
        //Selects the Correct Prescription and Prescribes it to the patient
        for (int i = 0; i < prescriptionStore.size(); i++) {
            //Checks if it is the Correct Prescription
            if (prescriptionStore.get(i) == prescription) {
                for (int j = 0; j < prescriptionStore.get(i).getMedicine().size(); j++) {
                    //Sets prescribed boolean to true and updates level
                    prescriptionStore.get(i).getMedicine(j).setPrescribed(true);  
                    stockStore.getMedicine(prescriptionStore.get(i).getMedicine(j).getQuantity(), prescriptionStore.get(i).getMedicine(j).getName());
                }                
            }
        }
        
        //Returns Stock
        return stockStore;
    }
    
    /**
     * Adds medicine to the Stock
     * @param stock Class containing the Stock of the Medicine
     * @param Amount Amount Int that selects the amount of Stock being added
     * @param medicine Medicine which the Stock will be added too
     * @return Returns the Stock Class with updated stock
     */
    public Stock addStock(Stock stock, int Amount, Medicine medicine){
        Stock tempStock = stock;
        ArrayList<Medicine> medicines = stock.getMedicine();
        for (int i = 0; i < medicines.size(); i++) {
            if (medicines.get(i) == medicine) {
                medicines.get(i).setStock(Amount);
            }
        }
        tempStock.setMedicine(medicines);
        return tempStock;
    }
}
