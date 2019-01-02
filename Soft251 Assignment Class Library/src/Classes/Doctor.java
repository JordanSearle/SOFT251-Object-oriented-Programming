package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Classes.StatePattern.Appointment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Doctor Class
 * @author Jordan Searle
 */
public class Doctor extends User implements Serializable{
    ArrayList<Ratings>ratings = new ArrayList();
    ArrayList<Appointment>appointment = new ArrayList();
    private int rating;
    
    /**
     * Gets all the Appointment times
     * @return Returns the times of the Appointments
     */
    public ArrayList<Date> getAppointmentTimes(){
        ArrayList<Date>date = new ArrayList();
        for (int i = 0; i < appointment.size(); i++) {
            date.add(appointment.get(i).getDate());
        }        
        return date;
    }
    
    /**
     * Adds Appointment to the ArrayList
     * @param appointments Passes through a value to add
     */
    public void addAppointment(Appointment appointments){
        this.appointment.add(appointments);
    }
    
    /**
     * Deletes a Selected Appointment from the ArrayList
     * @param appointmentNum integer of the Selected appointment value
     */
    public void delAppointment(int appointmentNum){
        appointment.remove(appointmentNum);
    }
    
    /**
     * Gets the Total Ratings from the ArrayList
     * Adds all the values up and works out the Percentage 
     */
    public void setRating(){
        float ratingNum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            ratingNum = ratingNum + ratings.get(i).getRating();
        }
        int rating = Math.round(ratingNum / ratings.size());
    }

    /**
     * Adds a Rating to the ArrayList
     * @param rating Rating is the Class Data that gets added
     */
    public void addRating(Ratings rating){
        ratings.add(rating);
    }

    /**
     * Edits an Existing rating
     * @param i Is the Location in the ArrayList rating
     * @param rating Is the modified class details that need saving
     */
    public void editRating(int i,Ratings rating){
            ratings.remove(i);
            ratings.add(i, rating);
        
    }

    /**
     * Deletes a Selected Rating
     * @param i integer i is the location in the ArrayList
     */
    public void deleteRating(int i){
        ratings.remove(i);
    }

    //Default Getters and Setters

    /**
     * Returns the overall Ratings integer
     * @return Returns the Rating integer
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets the rating integer
     * @param rating Rating integer that sets the rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    /**
     * gets the total ArrayList of Ratings
     * @return the ArrayList of Ratings
     */
    public ArrayList<Ratings> getRatings() {
        return ratings;
    }

    /**
     * Sets the ArrayList of Ratings
     * @param ratings ratings is the ArrayList of Ratings
     */
    public void setRatings(ArrayList<Ratings> ratings) {
        this.ratings = ratings;
    }

    /**
     * gets the ArrayList of Appointments
     * @return Returns the ArrayList of Appointments
     */
    public ArrayList<Appointment> getAppointment() {
        return appointment;
    }

    /**
     * Sets ArrayList of Appointments
     * @param appointment Appointment is the ArrayList of Appointments
     */
    public void setAppointment(ArrayList<Appointment> appointment) {
        this.appointment = appointment;
    }
    
}
