package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Classes.Doctor;
import Classes.Patient;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
/**
 * Appointment Class
 * @author Jordan
 */
public class Appointment implements Serializable{
    private Long duration;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;
    private String patientNotes;
    private String DoctorNotes;
    private Patient patient;
    private Doctor doctor;
    private boolean Completed = false;

    /**
     * Returns the Appointment Duration in Hours
     * @return The Duration of the appointment in hours
     */
    public Long getDuration() {
        return duration;
    }

    /**
     * Boolean, to see if Appointment is complete or not
     * @return True or False
     */
    public boolean isCompleted() {
        return Completed;
    }

    /**
     * Sets the boolean value of the completed
     * @param Completed True or false value
     */
    public void setCompleted(boolean Completed) {
        this.Completed = Completed;
    }

    /**
     * Sets the Duration of the appointment
     * Takes the startTime Variable and finishTime Variable and calculates the duration
     */
    public void setDuration() {
        duration = null;
        duration = startTime.until(finishTime, ChronoUnit.MINUTES);
    }

    /**
     * Gets the Start time of the Appointment
     * @return Returns the Start time of the Appointment
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     *  Sets the Start time of the Appointment
     * @param startTime startTime passes the time the appointment starts
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the Finish Time of the appointment
     * @return Returns the Finish Time of the Appointment
     */
    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    /**
     * Sets the FinishTime of the Appointment
     * @param finishTime Passes through the selected finish time of the appointment
     */
    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }
    
    /**
     * gets the initial patient Notes made when the appointment is made
     * @return Returns the Patient Notes
     */
    public String getPatientNotes() {
        return patientNotes;
    }

    /**
     * Sets the Patients notes
     * @param patientNotes String containing the Patient Notes
     */
    public void setPatientNotes(String patientNotes) {
        this.patientNotes = patientNotes;
    }

    /**
     * Gets the Doctors notes set during the appointment
     * @return Returns the Notes 
     */
    public String getDoctorNotes() {
        return DoctorNotes;
    }

    /**
     * Sets the Doctors Notes during the appointment
     * @param DoctorNotes String containing Doctor notes
     */
    public void setDoctorNotes(String DoctorNotes) {
        this.DoctorNotes = DoctorNotes;
    }

    /**
     * Gets the Patient 
     * @return The Patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Sets the Patient involved
     * @param patient Patient 
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * gets the Doctor's Details
     * @return Returns the Doctor's Details
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Sets the Doctor's Details
     * @param doctor Doctor  Details
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    
}
