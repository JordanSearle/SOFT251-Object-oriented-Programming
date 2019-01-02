/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.DecoratorPattern;

import java.io.Serializable;


/**
 *
 * @author Jordan
 */
public class Unique extends fluidGender implements Serializable{
    
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