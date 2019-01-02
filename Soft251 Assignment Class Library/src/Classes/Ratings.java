package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jordan Searle
 */
public class Ratings implements Serializable{
    private String doctorName;
    private String patientForename;
    private int rating;
    private String review;
    private String feedback;     
    private Date date;
    
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
    
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientForename() {
        return patientForename;
    }

    public void setPatientForename(String patientForename) {
        this.patientForename = patientForename;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
