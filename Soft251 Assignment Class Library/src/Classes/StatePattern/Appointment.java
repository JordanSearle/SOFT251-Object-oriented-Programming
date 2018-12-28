/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.StatePattern;

import java.util.Date;

/**
 *
 * @author Jordan
 */
public class Appointment {
    private Date date;
    private String notes;
    private State state;
    private String patient;
    private String doctor;
}
