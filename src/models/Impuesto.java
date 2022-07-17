/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author RICHARD RIVERA
 */
public class Impuesto extends Casilla{
    
    private final int CantPagar = -200;
    
    public Impuesto(){
        super(38 ,"IMPUESTO");    
    }
    
    public int getCantpagar() {
        return CantPagar;
    }

    @Override
    public void hacer(Jugador actualJugador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
