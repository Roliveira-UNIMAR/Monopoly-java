package models.cartas;

import models.Jugador;
import models.Tablero;

/**
 *
 * @author Rodrigo Oliveira - 29.655.609
 */
public class CartaMover extends Carta {
    private int nCasilla;

    public CartaMover (int nCasilla, Tablero tablero, String descrip){
        super(descrip);
        this.nCasilla = nCasilla;
    }

    @Override
    public void hacer(Jugador jugador) {
        jugador.mover(nCasilla);
    }
}
