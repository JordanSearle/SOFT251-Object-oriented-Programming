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
public class Unique extends fluidGender {
    
    public Unique(preferredGender gender, String fluidGender) {
        super(gender);
        FluidGender = fluidGender;
    }   
    @Override
    public String getGender(){
        String Gender = gender.getGender()+","+ FluidGender;
        return Gender;
    }
}