/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Classes.DecoratorPattern.preferredGender;
import java.util.ArrayList;

/**
 *
 * @author Jordan
 */
public class Patient extends User{
    private preferredGender Gender;
    private ArrayList<Prescription> prescription = new ArrayList();
    
     public preferredGender getGender() {
        return Gender;
    }

    public void setGender(preferredGender Gender) {
        this.Gender = Gender;
    }

    public ArrayList<Prescription> getPrescription() {
        return prescription;
    }

    public void setPrescription(ArrayList<Prescription> prescription) {
        this.prescription = prescription;
    }
    public Medicine Medicine(int i, int g){ 
        Prescription temp = prescription.get(i);
        Medicine A = temp.returnMedicine(g);
        return A;
    }
   
}
