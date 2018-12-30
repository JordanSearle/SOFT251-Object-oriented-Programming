package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jordan
 */
public class Medicine {
    private String name;
    private int Quantity;
    private String Dosage;
    private int Stock;
    
    /**
     * Default Constructor 
     */
    public Medicine(){        
    }
    
    /**
     * Alternative Constructor 
     * initialises the Name and Stock Variables with Data
     *
     * @param Name Medicine Name
     * @param Quanity Quantity of the Medicine
     * @param Dosage Dosage required
     */
    public Medicine(String Name, int Quanity, String Dosage){
    this.name = Name;
    this.Quantity = Quantity;
    this.Dosage = Dosage;
    }

    /**
     * Gets the Quantity of the Medicine
     * @return Quantity of the Medicine
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * Sets the Quantity of the Medicine
     * @param Quantity Quantity of the Medicine
     */
    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    /**
     * Gets the Dosage of the Medicine
     * @return the Dosage of the Medicine
     */
    public String getDosage() {
        return Dosage;
    }

    /**
     * Sets the Dosage of the Medicine
     * @param Dosage Dosage of the Medicine
     */
    public void setDosage(String Dosage) {
        this.Dosage = Dosage;
    }
    

    /**
     *  Returns the String Name
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     *Sets the String Name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Stock of the Medicine
     * @return the Stock of the Medicine
     */
    public int getStock() {
        return Stock;
    }

    /**
     * Sets the Stock of the Medicine
     * @param Stock Stock of the Medicine
     */
    public void setStock(int Stock) {
        this.Stock = Stock;
    }
    
    
}
