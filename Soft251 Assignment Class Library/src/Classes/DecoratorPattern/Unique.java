
import Classes.DecoratorPattern.preferredGender;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jordan
 */
public class Unique extends fluidGender {
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Unique(preferredGender Gender) {
        super(Gender);
    }
    
    
    public String setGender(){
        return this.gender = gender;
    }
}