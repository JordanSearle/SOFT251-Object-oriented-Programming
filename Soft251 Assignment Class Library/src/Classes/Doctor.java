package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Classes.StatePattern.Appointment;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jordan Searle
 */
public class Doctor extends User {
    ArrayList<Ratings>ratings = new ArrayList();
    ArrayList<Appointment>appointment = new ArrayList();
    private int rating;
    
    /**
     *
     * @return
     */
    public ArrayList<Date> getAppointmentTimes(){
        ArrayList<Date>date = new ArrayList();
        for (int i = 0; i < appointment.size(); i++) {
            date.add(appointment.get(i).getDate());
        }        
        return date;
    }
    
    /**
     *
     * @param appointments
     */
    public void addAppointment(Appointment appointments){
        this.appointment.add(appointments);
    }
    
    /**
     *
     * @param appointmentNum
     */
    public void delAppointment(int appointmentNum){
        appointment.remove(appointmentNum);
    }
    
    /**
     *
     */
    public void setRating(){
        float ratingNum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            ratingNum = ratingNum + ratings.get(i).getRating();
        }
        int rating = Math.round(ratingNum / ratings.size());
    }

    /**
     *
     * @param rating
     */
    public void addRating(Ratings rating){
        ratings.add(rating);
    }

    /**
     *
     * @param i
     * @param rating
     */
    public void editRating(int i,Ratings rating){
            ratings.remove(i);
            ratings.add(i, rating);
        
    }

    /**
     *
     * @param i
     */
    public void deleteRating(int i){
        ratings.remove(i);
    }

    //Default Getters and Setters

    /**
     *
     * @return
     */
    public int getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Ratings> getRatings() {
        return ratings;
    }

    /**
     *
     * @param ratings
     */
    public void setRatings(ArrayList<Ratings> ratings) {
        this.ratings = ratings;
    }

    /**
     *
     * @return
     */
    public ArrayList<Appointment> getAppointment() {
        return appointment;
    }

    /**
     *
     * @param appointment
     */
    public void setAppointment(ArrayList<Appointment> appointment) {
        this.appointment = appointment;
    }
    
}
