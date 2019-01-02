package Classes.DecoratorPattern;


import Classes.DecoratorPattern.preferredGender;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jordan
 */
public abstract class fluidGender extends preferredGender implements Serializable{    
    preferredGender gender;
    
    public fluidGender(preferredGender Gender){
        this.gender = Gender;
    }
}
