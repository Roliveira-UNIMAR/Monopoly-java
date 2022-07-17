/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.cartas;

import models.Carcel;
import models.Jugador;

/**
 *
 * @author Rodrigo Oliveira <roliveira@unimar.edu.ve>
 */
public class CartaIrCarcel extends Carta {
    private Carcel carcel;

    public CartaIrCarcel(Carcel carcel){
        super("Vas Directo a la carcel");
        this.carcel = carcel;
    }

    @Override
    public void hacer(Jugador jugador){
        carcel.enviarACarcel(jugador);
    }
}
