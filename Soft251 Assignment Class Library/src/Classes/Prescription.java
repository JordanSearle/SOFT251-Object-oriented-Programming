/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jordan
 */
public class Prescription {
    
    private int quanity;
    private String notes;
    //Contains ArrayList of Medicines from an appointment
    private ArrayList<Medicine> medicine = new ArrayList();    

    public void addMedicine(){
    //Will add Medicine when called.
    }
    
    public ArrayList<Medicine> getMedicine() {
        return medicine;
    }

    public void setMedicine(ArrayList<Medicine> medicine) {
        this.medicine = medicine;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Medicine returnMedicine(int i) {
        Medicine tempMedicine = medicine.get(i);
        return tempMedicine;
    }

    
}
