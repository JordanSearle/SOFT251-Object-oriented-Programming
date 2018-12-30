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
    
    public ArrayList<Date> getAppointmentTimes(){
        ArrayList<Date>date = new ArrayList();
        for (int i = 0; i < appointment.size(); i++) {
            date.add(appointment.get(i).getDate());
        }        
        return date;
    }
    
    public void setRating(){
        float ratingNum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            ratingNum = ratingNum + ratings.get(i).getRating();
        }
        int rating = Math.round(ratingNum / ratings.size());
    }
    public void addRating(Ratings rating){
        ratings.add(rating);
    }
    public void editRating(int i,Ratings rating){
            ratings.remove(i);
            ratings.add(i, rating);
        
    }
    public void deleteRating(int i){
        ratings.remove(i);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public ArrayList<Ratings> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Ratings> ratings) {
        this.ratings = ratings;
    }

    public ArrayList<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(ArrayList<Appointment> appointment) {
        this.appointment = appointment;
    }
    
}
