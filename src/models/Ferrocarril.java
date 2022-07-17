package models;

/**
 *
 * @author Richard Rivera - 28.570.753
 * @author Rodrigo Oliveira 29.655.609
 */
public class Ferrocarril extends Propiedad {
    private final int costoHipoteca = 100;
    
    public Ferrocarril(){
        super();
    }
    
    public Ferrocarril(int pos, String n) {
        super(pos, n, 200);
    }
    
    public int getRenta() {
        int renta = 0;
        switch (propietario.getCantFerrocarriles()) {
            case 1:
                renta = 25;
            case 2:
                renta = 50;
            case 3:
                renta = 100;
            case 4:
                renta = 200;
        }
        return renta;
    }

    public int getCostoHipoteca() {
        return this.costoHipoteca;
    }
    
    @Override
    public String toString() {
        String string = "";
        string += "\n\t" + this.nombre + "\n\n"
                + "Renta: 25$" + "\n"
                + "Con 2 Ferrocarriles: 50$" + "\n"
                + "Con 3 Ferrocarriles: 100$" + "\n"
                + "Con 4 Ferrocarriles: 200$" + "\n"
                + "Hipoteca: " + this.costoHipoteca + "$" + "\n\n";
        return string;
    }

    @Override
    public void hacer(Jugador actualJugador) {
        if(propietario == actualJugador) {
           // No hacer nada
        } else if ((!hipotecada) && (propietario != actualJugador)) {
            Mostrar.msj(actualJugador.getNombre() + " paga a " + propietario.getNombre() + " " + getRenta() + "$ de renta");
                actualJugador.pagar(propietario, getRenta());
        } else {
            ofertar(actualJugador);
        }
    }
}
