package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
/**
 *
 * @author Jordan
 */
public class Prescription {
    
    private int quanity;
    private String notes = "";
    //Contains ArrayList of Medicines from an appointment
    private ArrayList<Medicine> medicine = new ArrayList();    

    public void addMedicine(Medicine medicines){
    medicine.add(medicines);
    setNotes(medicines.getName());
    }
    
    public ArrayList<Medicine> getMedicine() {
        return medicine;
    }
    public Medicine getMedicine(int i) {
        return medicine.get(i);
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

    public void setNotes(String name) {
        String nameStore = "";
        for (int i = 0; i < medicine.size(); i++) {
            nameStore = getNotes() + String.format("%s, %x, %s. ", name, medicine.get(i).getQuantity(), medicine.get(i).getDosage());
        }
        this.notes = nameStore;        
    }

    public Medicine returnMedicine(int i) {
        Medicine tempMedicine = medicine.get(i);
        return tempMedicine;
    }
    

    
}
