/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Administrator Class
 * @author Jordan Searle
 */
public class Administrator extends User implements Serializable{

    /**
     * Creates a Patient account for the Administrator
     * @param patient ArrayList of Patients
     * @return edited ArrayList of Patients
     */
    public ArrayList<Patient> addPatient(ArrayList<Patient> patient){
        ArrayList<Patient> patients = patient;
        Patient admin = new Patient();
        
        admin.setiDnum(getiDnum());
        admin.setForename(getForename());
        admin.setSurname(getSurname());
        admin.setDateOfBirth(getDateOfBirth());
        admin.calculateAge();
        admin.setAddressLineOne(getAddressLineOne());
        admin.setAddressLineTwo(getAddressLineTwo());
        admin.setPostcode(getPostcode());
        admin.setCity(getCity());
        admin.setUsername(getUsername());
        admin.setPassword(getPassword());
        
        patients.add(admin);
        return patients;
        
    }

    /**
     * Adds a new Doctor
     * @param doctorDetails Provides the Details of the Doctor to add
     * @return The new Doctors details
     */
    public Doctor addDoctor(Doctor doctorDetails){
        return doctorDetails;
    }

    /**
     * Adds a new Secretary
     * @param secretaryDetails Provides the Details of the Secretary to add
     * @return the new Secretary Details
     */
    public Secretary addSecretary(Secretary secretaryDetails){
        return secretaryDetails;
    }

    /**
     * Deletes a selected Doctor
     * @param doctorNumber Provides the ArrayList number of the Doctor
     * @param doctors Provides the Doctor's ArrayList 
     * @return the updated ArrayList
     */
    public ArrayList<Doctor> delDoctor(int doctorNumber, ArrayList<Doctor> doctors){
        doctors.remove(doctorNumber);
        return doctors;
    }

    /**
     * Deletes a selected Secretary
     * @param secretaryNumber provides the ArrayList number of the Secretary
     * @param secretary Provides the Secretary's ArrayList
     * @return returns the updated ArrayList
     */
    public ArrayList<Secretary> delSecretary(int secretaryNumber, ArrayList<Secretary> secretary){
        secretary.remove(secretaryNumber);
        return secretary;
    }

    /**
     * Views the Doctors ratings
     * @param doctor Provides the Doctors Class
     * @return the ratings ArrayList from the Doctor
     */
    public ArrayList<Ratings> viewRatings(Doctor doctor){
        return doctor.getRatings();
    }
            
    /**
     * Adds Feedback to the Doctors Ratings
     * @param doctor Provides the Doctors Class Details
     * @param ratingNum Provides the selected Rating number in the ArrayList
     * @param Feedback Provides the String containing the Feedback 
     * @return Returns the Updated Doctor Ratings ArrayList
     */
    public Ratings addFeeback(Doctor doctor, int ratingNum, String Feedback){
        ArrayList<Ratings> rating= doctor.getRatings();
        Ratings ratingStore = rating.get(ratingNum);
        ratingStore.setFeedback(Feedback);    
        return ratingStore;
    }
}