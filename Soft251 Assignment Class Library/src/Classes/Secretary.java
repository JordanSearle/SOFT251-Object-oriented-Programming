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
public class Secretary {
    
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
}
