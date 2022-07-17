package models.cartas;

import models.Carcel;
import models.Jugador;

/**
 *
 * @author Rodrigo Oliveira 29.655.609
 */
public class CartaIrCarcel extends Carta {
    public CartaIrCarcel() {
        super("VE A LA CARCEL. VE DIRECTAMENTE SIN PASAR POR LA CASILLA DE SALIDA Y SIN COBRAR LOS 200$");
    }

    @Override
    public void hacer(Jugador jugador){
        Carcel.enviarACarcel(jugador);
    }
}
