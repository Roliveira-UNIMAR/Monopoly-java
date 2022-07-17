/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.cartas;

import models.Jugador;
import models.Tablero;

/**
 *
 * @author Rodrigo Oliveira - 29.655.609
 */
public class CartaMover extends Carta {
    private int nCasilla;
    private Tablero tablero;

    public CartaMover (int nCasilla, Tablero tablero, String descrip){
        super(descrip);
        this.nCasilla = nCasilla;
        this.tablero = tablero;
    }

    @Override
    public void hacer(Jugador jugador) {
        jugador.mover(nCasilla, tablero);
    }
}
