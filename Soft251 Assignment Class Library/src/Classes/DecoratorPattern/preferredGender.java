package Classes.DecoratorPattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jordan
 */
public abstract class preferredGender {
    String gender = "Unknown Gender";
    
    public String getGender() {
        return gender;
    }
    public abstract String setGender();
    
}
