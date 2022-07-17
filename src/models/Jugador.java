package models;

import java.util.ArrayList;

/**
 *
 * @author Rodrigo Oliveira - 29.655.609
 * @author Edgar Ruiz - 30.065.695
 */
public class Jugador {
    String nombre;
    int dinero;
    int posicion;
    private ArrayList<Propiedad> propiedades;
    public boolean salirCarcel;
    public boolean enCarcel;
    int turnosCarcel;
    int cantFerrocarriles;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.dinero = 1500;
        this.posicion = 0;
        this.propiedades = new ArrayList<Propiedad>();
        this.salirCarcel = false;
        this.enCarcel = false;
        this.turnosCarcel = 0;
        this.cantFerrocarriles = 0;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        if (this.dinero < -dinero){
            bancarrota(-dinero - this.dinero);
        }
        this.dinero += dinero;
    }
    
    private void bancarrota(int faltaDinero){
        System.out.println("Te faltan " + faltaDinero + "$");
            Mostrar.hipoteca(this);
            Leer.opcion(0, "Escoja una opcion: ");
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int pos) {
        this.posicion += pos;
    }

    public boolean isBancarota() {
        return dinero == 0;
    }

    public int getCantFerrocarriles() {
          return this.cantFerrocarriles;  
    }
    
    public void pagar(Jugador recividor, int cant) {
        recividor.setDinero(cant);
        setDinero(-cant);
    }

    public void comprar(Propiedad propiedad) {
        setDinero(-propiedad.getPrecio());
        propiedades.add(propiedad);
        OrdenarPropiedadesPorGrupo();
    }
    
    public void mover(int nCasilla) {
        posicion += nCasilla;
        if (posicion > 39) {
            Mostrar.msj(nombre + " pasaste por \"SALIDA\" y cobrate 200$ de sueldo");
            dinero += 200;
            posicion -= 40;
        }
        Mostrar.msj("Ahora estas en " + Tablero.getActualCasilla(this));
        Tablero.getActualCasilla(this).hacer(this);
    }

     public void vender(Propiedad propiedad){
        setDinero(propiedad.getPrecio() / 2);
        propiedad.setPropietario(null);
    }

    public void hipotecar(ColorPropiedad propiedad){
        propiedad.hipotecada = true;
        setDinero(propiedad.getCostoHipoteca() / 2);
    }

    public void payMortgage(Property property){
        property.mortgaged = false;
        addMoney( (int) (-property.getPrice() * 0.55) );
    }

    
    public void OrdenarPropiedadesPorGrupo() {
        ArrayList<Servic> utilities = new ArrayList<>();
        ArrayList<Ferrocarril> ferrocarrils = new ArrayList<>();
        ArrayList<ColorPropiedad> ordenadas = new ArrayList<>();

        for(ColorPropiedad property : this.propiedades){
            if(property instanceof Utility){
                utilities.add((Utility) property);
            } else if(property instanceof Railroad){
                railroads.add((Railroad) property);
            } else {
                sorted.add(property);
            }
        }
        Collections.sort(utilities);
        Collections.sort(railroads);
        Collections.sort(sorted);

        sorted.addAll(railroads);
        sorted.addAll(utilities);

        this.properties = sorted;
    }
    
    @Override
    public String toString() {
        String string = "\nEstado del Jugador\n\n";
        string += "Ficha: " + this.nombre + "\n"
                + "Balance: " + this.dinero + "\n"
                + "Posicion actual: " + Tablero.tablero[this.posicion].getNombre() + "\n"
                + "Condicion: " + ((enCarcel) ? "En la carcel" : "Jugando")
                + "Propiedades: ";
        if(propiedades.isEmpty()) {
            string += "No pase propiedades";
        } else {
            for (ColorPropiedad propiedad : propiedades) {
                string += propiedad.toString() + "\n";
            }  
        }
        return string;
    }
}
