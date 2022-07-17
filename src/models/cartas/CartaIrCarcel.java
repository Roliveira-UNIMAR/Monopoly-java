package models.cartas;

import models.Carcel;
import models.Jugador;

/**
 *
 * @author Rodrigo Oliveira 29.655.609
 */
public class CartaIrCarcel extends Carta {
    private Carcel carcel;

    public CartaIrCarcel(Carcel carcel){
        super("VAS DIRECTO A LA CARCEL");
        this.carcel = carcel;
    }

    @Override
    public void hacer(Jugador jugador){
        carcel.enviarACarcel(jugador);
    }
}
