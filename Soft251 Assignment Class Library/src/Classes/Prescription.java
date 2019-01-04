package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
/**
 * Prescription Class
 * @author Jordan
 */
public class Prescription {
    
    private int quanity;
    private String notes = "";
    //Contains ArrayList of Medicines from an appointment
    private ArrayList<Medicine> medicine = new ArrayList();    

    /**
     * Adds a new medicine to the Prescription
     * @param medicines Medicine Class containing the medicine being added
     */
    public void addMedicine(Medicine medicines){
    medicine.add(medicines);
    setNotes(medicines.getName());
    }
    
    /**
     * Returns the ArrayList of Medicine
     * @return The Medicine ArrayList
     */
    public ArrayList<Medicine> getMedicine() {
        return medicine;
    }

    /**
     * Gets a selected Medicine and returns it
     * @param medIndex medIndex Int is the index of the Medicine
     * @return The Selected Medicine
     */
    public Medicine getMedicine(int medIndex) {
        return medicine.get(medIndex);
    }

    /**
     * Sets the Complete ArrayList of Medicine
     * @param medicine Containing the ArrayList of medicine being added
     */
    public void setMedicine(ArrayList<Medicine> medicine) {
        this.medicine = medicine;
    }

    /**
     * Gets the Quantity of Medicine needed to be prescribed
     * @return the Quantity of Medicine
     */
    public int getQuanity() {
        return quanity;
    }

    /**
     * Sets the Quantity
     * @param quanity Int Quantity
     */
    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    /**
     * Returns Notes left by the Doctor
     * @return The String of notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the String of Notes
     * @param name String that passes through the Medicine name
     */
    public void setNotes(String name) {
        String nameStore = "";
        for (int i = 0; i < medicine.size(); i++) {
            nameStore = getNotes() + String.format("%s, %x, %s. ", name, medicine.get(i).getQuantity(), medicine.get(i).getDosage());
        }
        this.notes = nameStore;        
    }

    /**
     * Returns a selected Medicine from the prescription
     * @param i Index of the Medicine
     * @return the selected Medicine
     */
    public Medicine returnMedicine(int i) {
        Medicine tempMedicine = medicine.get(i);
        return tempMedicine;
    }
    

    
}
