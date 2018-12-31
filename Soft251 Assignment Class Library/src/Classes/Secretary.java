/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.StatePattern.Appointment;
import java.util.ArrayList;

/**
 *
 * @author Jordan Searle
 */
public class Secretary extends User{
    
    private ArrayList<Patient>approvePatient = new ArrayList();
    private ArrayList<Appointment>approveAppointment = new ArrayList();
    
    public ArrayList<Appointment> getAppointments(){
        return approveAppointment;
    }
    public void addAppointments(Appointment appointment){
        approveAppointment.add(appointment);
    }
    public void delAppointment(int appointmentNum){
        approveAppointment.remove(appointmentNum);
    }
    public ArrayList<Appointment> approveAppointments(ArrayList<Appointment> appointment, int appointmentNum){
        ArrayList<Appointment>appointments = appointment;
        int number = appointmentNum;
        appointments.add(approveAppointment.get(number)); 
        return appointments;
    }
    public Patient approvePatient(int patientNum){
       Patient patient = approvePatient.get(patientNum);
       return patient;
    }
    public void addPatient(Patient patient){
       approvePatient.add(patient);
    }
    public void disprovePatient(int numberPatient){
        this.approvePatient.remove(numberPatient);
    }
    public ArrayList<Patient>delPatient(int patientNum, ArrayList<Patient> patients){
        ArrayList<Patient> patient = patients;
        patient.remove(patientNum);
        return patient;
    }
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
