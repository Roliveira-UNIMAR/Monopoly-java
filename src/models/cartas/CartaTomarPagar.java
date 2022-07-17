/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.cartas;

import models.Jugador;

/**
 *
 * @author Rodrigo Oliveira - 29.655.609
 */
public class CartaTomarPagar extends Carta {
    private int cant;

    public CartaTomarPagar(int cant, String descrip){
        super(crearTomarPagar(cant, descrip));
        this.cant = cant;
        
    }

    public static String crearTomarPagar(int cant, String descrip) {
        String tomarMsj = descrip + ". Toma " + cant + "$";
        String pagarMsj = descrip + ". Paga " + -cant + "$";
        return (cant > 0) ? tomarMsj : pagarMsj;
    }
    
    @Override
    public void hacer(Jugador jugador) {
       jugador.setDinero(cant);
    }
}
