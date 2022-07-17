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
        jugador.cartasSalirCarcel++;
    }
}
