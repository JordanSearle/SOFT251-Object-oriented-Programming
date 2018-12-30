package Classes;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jordan
 */
public class User {
    private String iDnum;
    private String forename;
    private String surname;
    private LocalDate dateOfBirth;
    private int age;
    private String addressLineOne;
    private String addressLineTwo;
    private String City;
    private String postcode;

    
    
    
    /**
     *Initial Constructor for the user
     */
    public User(){
        
    }
    
    /**
     * Calculates the Ages of the user
     */
    public void calculateAge(){
        LocalDate today = LocalDate.now();//Today's date
        Period p = Period.between(dateOfBirth, today);
        age = p.getYears();
    }
    
    /**
     * Returns the Date of Birth of the User
     * @return Date of birth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the Date of Birth of the user
     * @param dateOfBirth users Date of Birth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        calculateAge();
    }

    /**
     * returns the Users age
     * @return the Users age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the users age
     * @param Age is the selected Age
     */
    public void setAge(int Age) {
        this.age = Age;
    }

    /**
     * Gets the City where the User lives
     * @return the city
     */
    public String getCity() {
        return City;
    }

    /**
     * Sets the City where the User lives
     * @param City Users City
     */
    public void setCity(String City) {
        this.City = City;
    }
    /**
     * Returns the Value for the Forename
     * @return Forename of the User
     */
    public String getForename() {
        return forename;
    }

    /**
     * Sets the Value for the Forename
     * @param forename of the User
     */
    public void setForename(String forename) {
        this.forename = forename;
    }

    /**
     *gets the value of the Surname
     * @return Surname
     */
    public String getSurname(){
        return surname;
    }

    /**
     * Sets the Value of the Surname
     * @param surname of the User
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Returns the Address of the User
     * @return AddressLineOne
     */
    public String getAddressLineOne() {
        return addressLineOne;
    }

    /**
     * Sets the Address of the User
     * @param addressLineOne of the User
     */
    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    /**
     *Returns the Address of the User
     * @return AddressLineTwo
     */
    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    /**
     * Sets the Address of the User
     * @param addressLineTwo of the User
     */
    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    /**
     * Returns the Address of the User
     * @return Postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Sets the Address of the User
     * @param postcode of the User
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     *  Returns the ID Number of the User
     *  @return iDNum
     */
    public String getiDnum() {
        return iDnum;
    }

    /**
     * Sets the ID Number of the User
     * @param iDnum of the User
     */
    public void setiDnum(String iDnum) {
        this.iDnum = iDnum;
    }
    
    
}
