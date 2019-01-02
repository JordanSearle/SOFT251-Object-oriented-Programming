/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Jordan Searle
 */
public class accountStore implements Serializable {
    private ArrayList<Patient> patient = new ArrayList();
    private ArrayList<Doctor> doctor = new ArrayList();
    private ArrayList<Secretary> secretary = new ArrayList();
    private ArrayList<Administrator> admin = new ArrayList();
    private ArrayList<Stock> stock = new ArrayList();
    public accountStore(){
        
    }
    /**
     * Returns the Stock ArrayList
     * @return Returns the Stock ArrayList
     */
    public ArrayList<Stock> getStock() {
        return stock;
    }

    /**
     * Sets the Stock ArrayList
     * @param stock Stock ArrayList
     */
    public void setStock(ArrayList<Stock> stock) {
        this.stock = stock;
    }

    
    /**
     * Gets the patients ArrayList
     * @return The Patients ArrayList
     */
    public ArrayList<Patient> getPatient() {
        return patient;
    }

    /**
     * Sets the Patients ArrayList
     * @param patient ArrayList of Patients
     */
    public void setPatient(ArrayList<Patient> patient) {
        this.patient = patient;
    }

    /**
     * Gets the Doctors ArrayList
     * @return Returns the Doctors ArrayList
     */
    public ArrayList<Doctor> getDoctor() {
        return doctor;
    }

    /**
     * Sets the Doctors ArrayList
     * @param doctor ArrayList of Doctors
     */
    public void setDoctor(ArrayList<Doctor> doctor) {
        this.doctor = doctor;
    }

    /**
     * Gets the Secretary ArrayList
     * @return Return Secretary ArrayList
     */
    public ArrayList<Secretary> getSecretary() {
        return secretary;
    }

    /**
     * Sets Secretary ArrayList
     * @param secretary Secretary ArrayList
     */
    public void setSecretary(ArrayList<Secretary> secretary) {
        this.secretary = secretary;
    }

    /**
     * Gets the Administrator ArrayList
     * @return Returns the Administrator ArrayList
     */
    public ArrayList<Administrator> getAdmin() {
        return admin;
    }

    /**
     * Sets the Administrator ArrayList
     * @param admin Administrator ArrayList
     */
    public void setAdmin(ArrayList<Administrator> admin) {
        this.admin = admin;
    }
    
    public void writeObject() throws IOException {
        String filename = "C:/Users/megst/Documents/NetBeansProjects/testweb/web/medicine.ser"; 
        // Serialization  
        try {
         FileOutputStream fileOut =
         new FileOutputStream(filename);
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(this);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in "+filename);
      } catch (IOException i) {
         i.printStackTrace();
      }
    }
 
    public void readObject() 
      throws ClassNotFoundException, IOException {
        String filename = "C:/Users/megst/Documents/NetBeansProjects/testweb/web/medicine.ser"; 
        // Deserialization 
         try {
         FileInputStream fileIn = new FileInputStream(filename);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         accountStore temp = (accountStore) in.readObject();
         in.close();
         fileIn.close();
      } catch (IOException i) {
         i.printStackTrace();
         return;
      } catch (ClassNotFoundException c) {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return;
      }
    }
    
    
}
