package Classes.DecoratorPattern;


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
public class Male extends preferredGender{   
    public Male(){
        this.gender = "Male";
    }
    @Override
    public String getGender(){
        return this.gender = "Male";
    }
    }
    
