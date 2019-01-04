/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Stock Class
 * @author Jordan Searle
 */
public class Stock implements Serializable{
    private ArrayList<Medicine>medicine= new ArrayList();


    /**
     * Selects and returns a medicine based on the passed parameters;
     * @param i is the selected Medicine
     * @return the Medicine that is selected
     */
    public int getStock(int i){
        return medicine.get(i).getStock();
    }
    
    /**
     * Orders new Medicine
     * selects the correct medicine from Variable name
     * Adds to the stock from Variable i
     * @param i is the selected Medicine stock
     * @param name is the selected Medicine name
     */
    public void orderStock(int i, String name){
        for (int j = 0; j < medicine.size(); j++) {
            //Selects each Medicine in the list
            if (medicine.get(j).getName() == name) {
                //Selects the Correct Medicine from method variables
                int Stock = medicine.get(j).getStock();
                //Adds new stock
                int newStock = Stock + i;
                medicine.get(j).setStock(newStock); 
            }
        }   
    }

    /**
     * Uses a selected medicine if the stock is high enough
     * Selects the Correct Medicine by variable name
     * removes the stock of the selected medicine from variable i
     * @param i is the Index selected Medicine stock
     * @param name is the selected Medicine name
     */
     public void useStock(int i, String name){
        for (int j = 0; j < medicine.size(); j++) {
            //Selects each Medicine in the list
            if (medicine.get(j).getName() == name) {
                //Selects the Correct Medicine from method variables
                int Stock = getStock(j);
                int newStock = Stock - i;
                medicine.get(j).setStock(newStock);
            }
        }        
    }      
     
    /**
     * Returns the entire Class
     * @return Returns the entire Class
     */ 
    public Stock returnStock(){
        return this;
    }
    

    /**
     * Medicine ArrayList getter
     * @return the Medicine
     */
    public ArrayList<Medicine> getMedicine() {
        return medicine;
    }

    /**
     * Returns a medicine and updates the stock
     * @param amount is the stock it adds
     * @param medicineName is the name of the medicine
     * @return the medicine that is selected
     */
    public Medicine getMedicine(int amount, String medicineName){
        useStock(amount, medicineName);
        return medicine.get(amount);
    }

    /**
     * Medicine ArrayList Setter
     * @param medicine sets the medicine ArrayList
     */
    public void setMedicine(ArrayList<Medicine> medicine) {
        this.medicine = medicine;
    }
}
