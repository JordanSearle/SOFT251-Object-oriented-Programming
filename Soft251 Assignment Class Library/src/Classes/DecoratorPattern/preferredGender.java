package Classes.DecoratorPattern;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jordan Searle
 */
public abstract class preferredGender implements Serializable{
    String gender = "Unknown Gender";
    String FluidGender = null;
    public String getGender(){
    return gender;
}}
