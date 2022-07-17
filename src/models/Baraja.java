package models;

import models.cartas.Carta;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Rodrigo Oliveira - 29.655.609
 * @author Richard Rivera - 28.570.753
 */
public class Baraja {
    private ArrayList<Carta> baraja = new ArrayList<>();

    public void tomarCarta(Jugador jugador){
        Carta carta;
        carta = baraja.remove(0);
        ponerAbajo(carta);
        carta.usar(jugador);
    }

    public void ponerAbajo(Carta carta){
        baraja.add(carta);
    }

    public void barajear(){
        Collections.shuffle(baraja);
    }
}
