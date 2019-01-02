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
public class Male extends preferredGender implements Serializable{   
    public Male(){
        this.gender = "Male";
    }
    @Override
    public String getGender(){
        return this.gender = "Male";
    }
    }
    
