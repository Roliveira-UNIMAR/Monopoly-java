package models;

/**
 *
 * @author Richard Rivera - 28.570.753
 * @author Rodrigo Oliveira 29.655.609
 */
public class Impuesto extends Casilla {
    private int impuesto;

    public Impuesto(int pos, String n, int impuesto){
        super(pos,n);
        this.impuesto = impuesto;
    }

    @Override
    public void hacer(Jugador jugador) {
        jugador.setDinero(-this.impuesto);
    }
}
