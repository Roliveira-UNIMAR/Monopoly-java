/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author RICHARD RIVERA
 */
public class Impuesto extends Casilla {
    private int impuesto;

    public Impuesto(int pos, String n, int impuesto){
        super(pos,n);
        this.impuesto = impuesto;
    }

    @Override
    public void hacer(Jugador jugador) {
        jugador.setDinero(-this.impuesto);
    }
}
