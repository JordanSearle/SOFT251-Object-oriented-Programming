/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.DecoratorPattern;

/**
 *
 * @author Jordan
 */
public abstract class fluidGender extends preferredGender {
    
    preferredGender Gender;
    
    public fluidGender(preferredGender Gender){
        this.Gender = Gender;
    }
}
