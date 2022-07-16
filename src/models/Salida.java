

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Salida extends Casilla {
    
    private final int DAR = 200;

    public Salida() {
        super("SALIDA", 0);
    }

    public int getDAR() {
        return DAR;
    }
    
}
