package models;

/**
 *
 * @author Rodrigo Oliveira 29.655.609
 */
public class Propiedad extends Casilla {
    private final int precio;
    public Jugador propietario;
    public boolean hipotecada;
    
    public Propiedad(){
        super();
        this.precio = 0;
        this.hipotecada = false;
    }
    
    public Propiedad(int pos, String nombre, int precio){
        super(pos, nombre);
        this.precio = precio;
        this.hipotecada = false;
    }

    public int getPrecio(){
        return this.precio;
    }

    public Jugador getPropietario() {
        return this.propietario;
    }
    
    public void setPropietario(Jugador jugador) {
        this.propietario = jugador;
    }
    
    public boolean isHipotecada() {
        return this.hipotecada;
    }

    public void comprado(Jugador actualJugador) {
        setPropietario(actualJugador);
        actualJugador.comprar(this);
    }
    
    public void ofertar(Jugador actualJugador){
        Mostrar.msj("Le gustaria comprar esta propiedad " + nombre + " por $" + precio + "?");
        int op = Leer.opcion(2, "1. Si\t\t2. No");
        if(op == 1){
            comprado(actualJugador);
        }
    }

    @Override
    public void hacer(Jugador actualJugador) {}
}
