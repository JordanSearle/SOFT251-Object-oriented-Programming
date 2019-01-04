package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Date;

/**
 * Ratings Class
 * @author Jordan Searle
 */
public class Ratings implements Serializable{
    private String doctorName;
    private String patientForename;
    private int rating;
    private String review;
    private String feedback;     
    private Date date;
    
    /**
     *  Returns the Review set by the Patients
     * @return Returns the Review set by the Patients
     */
    public String getReview() {
        return review;
    }

    /**
     * Sets the review
     * @param review is the String that Sets the review
     */
    public void setReview(String review) {
        this.review = review;
    }
    
    /**
     * Gets the Doctor's name 
     * @return Returns the String that contains the doctors name
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * Sets the Name of the Doctor
     * @param doctorName doctorName is the String that sets the Doctor's name
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    /**
     * gets the Forename of the Patient
     * @return Returns the String forename of the Patient
     */
    public String getPatientForename() {
        return patientForename;
    }

    /**
     * Sets the forename of the Patient
     * @param patientForename String for Patient Forename
     */
    public void setPatientForename(String patientForename) {
        this.patientForename = patientForename;
    }

    /**
     * Rating Number passed through by the Patient
     * @return Returns the Rating Int that is set
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets the Rating Int for the class
     * @param rating is the Int being set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Gets the Feedback provided by the Administrator
     * @return Returns the Feedback provided
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * Sets the Feedback of the Rating class
     * @param feedback String being set
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    /**
     * Gets the Date of the Rating
     * @return Returns the Date of the Rating 
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the Date of the Rating that is provided
     * @param date date contains the date which this Rating was set
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
