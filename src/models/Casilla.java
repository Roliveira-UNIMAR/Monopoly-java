package models;

/**
 *
 * @author Rodrigo Oliveira - 29.655.609
 * @author Shaenndry Carreño - 30.299.949
 * @author Edgar Ruiz - 30.065.695
 */
public abstract class Casilla {
    int posicion;
    String nombre;

    public Casilla() {
        this.posicion = 0;
        this.nombre = null;
    }
    
    public Casilla(int posicion, String nombre) {
        this.posicion = posicion;
        this.nombre = nombre;
    }

    public int getPosicion() {
        return this.posicion;
    }

    public void setPosicion(int pos) {
         this.posicion = pos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public abstract void hacer(Jugador actualJugador);
}
