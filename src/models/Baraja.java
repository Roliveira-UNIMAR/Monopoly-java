/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.cartas.Carta;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Baraja {
    private ArrayList<Carta> baraja = new ArrayList<>();

    public Carta tomarCarta(){
        Carta carta;
        carta = baraja.remove(0);
        ponerFinal(carta);
        return carta;
    }

    public void ponerFinal(Carta carta){
        baraja.add(carta);
    }

    public void barajear(){
        Collections.shuffle(baraja);
    }
}
