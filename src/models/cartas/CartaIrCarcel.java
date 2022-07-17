package models.cartas;

import models.Carcel;
import models.Jugador;

/**
 *
 * @author Rodrigo Oliveira 29.655.609
 */
public class CartaIrCarcel extends Carta {
    public CartaIrCarcel(Carcel carcel){
        super("Vas Directo a la carcel");
    }

    @Override
    public void hacer(Jugador jugador){
        Carcel.enviarACarcel(jugador);
    }
}
