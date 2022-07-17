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