/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.DecoratorPattern.preferredGender;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jordan
 */
public class Patient extends User{
    private preferredGender Gender;
    private List<Prescription> prescription = new ArrayList();
    
public Patient(String forename, String surname, String addressLineOne, String addressLineTwo, String postcode, String iDNum){
    setForename(forename);
    setSurname(forename);
    setAddressLineOne(addressLineOne);
    setAddressLineTwo(addressLineTwo);
    setPostcode(postcode);
    setiDnum(iDNum);      
}



}
