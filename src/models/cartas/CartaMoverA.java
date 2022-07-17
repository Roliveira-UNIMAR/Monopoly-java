package models.cartas;

import models.Jugador;
import models.Tablero;

/**
 *
 * @author Rodrigo Oliveira 29.655.609
 */
public class CartaMoverA extends Carta {
    private int[] indexs;

    public CartaMoverA(int[] indexs, String text){
        super(text);
        this.indexs = indexs;
    }

    public void hacer(Jugador jugador){
        int minDistancia = 40;

        for(int i = 0; i < indexs.length; i++){
            int distanciaAIndex = (40 + indexs[i] - jugador.getPosicion()) % 40;
            if ((40 + indexs[i] - jugador.getPosicion()) < minDistancia) {
                minDistancia = distanciaAIndex;
            }
        }
        jugador.moverA(minDistancia);
    }
}
