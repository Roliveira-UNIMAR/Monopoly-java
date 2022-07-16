/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.cartas;

import models.Jugador;
import models.Mostrar;

/**
 *
 * @author Rodrigo Oliveira - 29.655.609
 */
public abstract class Carta {
    String description;

    public Carta(String description){
        this.description = description;
    }

    public void usar(Jugador jugador){
        hacer(jugador);
        Mostrar.carta(this.description);
    }

    public abstract void hacer(Jugador jugador);
}