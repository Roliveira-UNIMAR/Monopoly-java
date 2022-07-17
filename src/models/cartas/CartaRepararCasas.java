package models.cartas;

import models.Jugador;
import models.ColorPropiedad;

/**
 *
 * @author Rodrigo Oliveira 29.655.609
 */
public class CartaRepararCasas extends CartaTomarPagar {
    private int pCasa;
    private int pHotel;

    public CartaRepararCasas(int pCasa, int pHotel, String descrip){
        super(0, descrip);
        this.pCasa = pCasa;
        this.pHotel = pHotel;
    }

    private int calcularTarifa(Jugador jugador){
        int tarifa = 0;
        for(ColorPropiedad cp : jugador.getListaGrupoColores()){
            if(cp.getCantCasas() == 5){
                tarifa += pHotel;
            } else if (cp.getCantCasas() > 0) {
                tarifa += pCasa * cp.getCantCasas();
            }
        }
        return tarifa;
    }

    @Override
    public void hacer(Jugador jugador){
        jugador.setDinero(-calcularTarifa(jugador));
    }
}
