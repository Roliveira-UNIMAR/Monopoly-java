package models;

/**
 *
 * @author Richard Rivera - 28.570.753
 * @author Rodrigo Oliveira 29.655.609
 */
public class Utilidad extends Propiedad {
    
    public Utilidad(int pos, String n) {
        super(pos, n, 150, 75);
    }
    
    public int getRenta() {
        int renta = 0;
        switch (propietario.getCantUtilidades()) {
            case 1:
                renta = 4 * Dado.getResultado();
            case 2:
                renta = 10 * Dado.getResultado();
        }
        return renta;
    }

    public int getValorHipoteca() {
        return this.valorHipoteca;
    }
    
    @Override
    public String toString() {
        String string = "";
        string += "\n\t" + this.nombre + "\n\n"
                + "Renta: 4 veces el resultado de lanzar los dados" + "\n"
                + "Con 2 utilidades: 10 veces el resultado de lanzar los dados" + "\n"
                + "Hipoteca: " + this.valorHipoteca + "$" + "\n\n";
        return string;
    }

    @Override
    public void hacer(Jugador actualJugador) {
        if(propietario == actualJugador) {
           // No hacer nada
        } else if ((!hipotecada) && (propietario != null)) {
            Mostrar.texto(actualJugador.getNombre() + " paga a " + propietario.getNombre() + " " + getRenta() + "$ de renta");
                actualJugador.pagar(propietario, getRenta());
        } else {
            ofertar(actualJugador);
        }
    }
}
