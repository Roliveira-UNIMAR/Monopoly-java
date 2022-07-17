/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.cartas;

import models.Jugador;

/**
 *
 * @author Rodrigo Oliveira 29.655.609
 */
public class CartaSalirCarcel extends Carta {
    public CartaSalirCarcel() {
        super("SALIR DE LA CARCEL GRATIS");
    }
    
    @Override
    public void hacer(Jugador jugador) {
        jugador.salirCarcel = true;
    }
}
