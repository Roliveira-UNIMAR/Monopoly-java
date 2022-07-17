package models.cartas;

import java.util.ArrayList;
import models.Jugador;

/**
 *
 * @author Rodrigo Oliveira - 29.655.609
 */
public class CartaTomarPagarTodos extends CartaTomarPagar {
    private ArrayList<Jugador> jugadores;
    private int cant;

    public CartaTomarPagarTodos(ArrayList<Jugador> jugadores, int cant, String descrip){
        super(cant, crearMsj(cant, descrip));
        this.cant = cant;
        this.jugadores = jugadores;
    }

    protected static String crearMsj(int cant, String descrip) {
        return CartaTomarPagar.crearTomarPagar(cant, descrip) + ((cant > 0) ? " DE TODOS LOS JUGADORES" : " A TODOS LOS JUGADORES");
    }

    @Override
    public void hacer(Jugador jugador) {
        jugador.setDinero(cant * jugadores.size());
        for(Jugador j : jugadores){
            j.setDinero(cant);
        }
    }
}
