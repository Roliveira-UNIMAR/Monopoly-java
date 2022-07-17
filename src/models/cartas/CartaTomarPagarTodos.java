/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.cartas;

import java.util.ArrayList;
import models.Jugador;

/**
 *
 * @author Rodrigo Oliveira - 29.655.609
 */
public class CartaTomarPagarTodos extends CartaTomarPagar {
    private ArrayList<Jugador> jugadores;
    private int cant;

    public CartaTomarPagarTodos(ArrayList<Jugador> jugadores, int cant, String descrip){
        super(cant, crearMsj(cant, descrip));
        this.cant = cant;
        this.jugadores = jugadores;
    }

    protected static String crearMsj(int cant, String descrip) {
        return CartaTomarPagar.crearTomarPagar(cant, descrip) + ((cant > 0) ? " de todos los jugadores" : " a todo jugador");
    }

    @Override
    public void hacer(Jugador jugador) {
        jugador.setDinero(cant * jugadores.size());
        for(Jugador j : jugadores){
            j.setDinero(cant);
        }
    }
}
