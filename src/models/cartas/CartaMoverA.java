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
 * @author Rodrigo Oliveira 29.655.609
 */
public class CartaMoverA extends Carta {
    private int[] index;
    private Tablero tablero;

    public CartaMoverA(int[] index, Tablero tablero, String text){
        super(text);
        this.index = index;
        this.tablero = tablero;
    }

    public void hacer(Jugador jugador){
        int minDistancia = 40;

        for(int i = 0; i < index.length; i++){
            int distanciaAIndex = (40 + index[i] - jugador.getPosicion()) % 40;
            if ((40 + index[i] - jugador.getPosicion()) < minDistancia) {
                minDistancia = distanciaAIndex;
            }
        }
        jugador.mover(minDistancia, tablero);
    }
}
