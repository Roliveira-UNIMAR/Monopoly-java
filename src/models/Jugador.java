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
    public int cartasSalirCarcel;
    public boolean enCarcel;
    int turnosCarcel;
    int cantFerrocarriles;

    public Jugador() {
        this.nombre = null;
        this.dinero = 1500;
        this.posicion = 0;
        this.propiedades = new ArrayList<>();
        this.cartasSalirCarcel = 0;
        this.enCarcel = false;
        this.turnosCarcel = 0;
    }
    
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.dinero = 1500;
        this.posicion = 0;
        this.propiedades = new ArrayList<>();
        this.cartasSalirCarcel = 0;
        this.enCarcel = false;
        this.turnosCarcel = 0;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        if (this.dinero < -dinero) {
            bancarrota(-dinero - this.dinero);
        }
        this.dinero += dinero;
    }
    
    private void bancarrota(int faltaDinero){
        Mostrar.texto("Jugador: " + this.getNombre());
        Mostrar.texto("Te faltan " + faltaDinero + "$");
        ArrayList<Propiedad> pSinCasa = getPropiedadesSinCasas();
        if (pSinCasa.isEmpty()) {
            Mostrar.texto("No posees ninguna propiedad que puedas hipotecar");
            Mostrar.texto("Qudaste en la bancarrota");
        } else {
            Mostrar.propiedad(pSinCasa);
            int opc = Leer.opcion(pSinCasa.size(), "Escoje una propiedad: ");
            Propiedad p = pSinCasa.get(opc - 1);
            this.hipotecar(p);
        }
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
    
    public void pagar(Jugador recividor, int cant) {
        recividor.setDinero(cant);
        setDinero(-cant);
    }

    public void comprar(Propiedad propiedad) {
        setDinero(-propiedad.getPrecio());
        propiedades.add(propiedad);
        OrdenarPropiedadesPorGrupo();
    }
    
    public void mover(int pasos) {
        this.posicion += pasos;
        boolean pasaPorSalida = (this.posicion >= 40);
        if (pasaPorSalida) {
            Mostrar.texto(nombre + " pasaste por \"SALIDA\" y cobrate 200$ de sueldo");
            this.dinero += 200;
            this.posicion -= 40;
        }
        Mostrar.texto("Ahora estas en " + Tablero.getActualCasilla(this).getNombre());
        Tablero.getActualCasilla(this).hacer(this);
    }
    
    public void moverA(int aPos){
        mover((40 - this.posicion + aPos) % 40);
    }
     public void vender(Propiedad propiedad){
        setDinero(propiedad.getPrecio() / 2);
        propiedad.setPropietario(null);
    }

    public void hipotecar(Propiedad propiedad){
        propiedad.hipotecada = true;
        setDinero(propiedad.getValorHipoteca());
    }

    public void pagaHipoteca(Propiedad propiedad){
        propiedad.hipotecada = false;
        setDinero((int) (-propiedad.getPrecio() * 0.10));
    }
    
    /**
     * Metodo que ordena todas las porpiedades de un jugador
     * 
     */
    public void OrdenarPropiedadesPorGrupo() {
        ArrayList<Utilidad> utilidades = new ArrayList<>();
        ArrayList<Ferrocarril> ferrocarriles = new ArrayList<>();
        ArrayList<Propiedad> ordenadas = new ArrayList<>();

        for (Propiedad propiedad : this.propiedades) {
            if (propiedad instanceof Utilidad){
                utilidades.add((Utilidad) propiedad);
            } else if (propiedad instanceof Ferrocarril) {
                ferrocarriles.add((Ferrocarril) propiedad);
            } else {
                ordenadas.add(propiedad);
            }
        }        
        ordenadas.addAll(ferrocarriles);
        ordenadas.addAll(utilidades);
        this.propiedades = ordenadas;
    }
    
    public int getCantFerrocarriles(){
        int cantFerro = 0;
        for (Propiedad p : this.propiedades) {
            if (p instanceof Ferrocarril) {
                cantFerro++;
            }
        }

        return cantFerro;
    }

    public int getCantUtilidades() {
        int cantUtilidades = 0;
        for (Propiedad p : this.propiedades){
            if (p instanceof Utilidad){
                cantUtilidades++;
            }
        }

        return cantUtilidades;
    }

    public int getCantCalles() {
        int cantCalles = 0;
        for (Propiedad p : this.propiedades){
            if (p instanceof ColorPropiedad){
                cantCalles++;
            }
        }
        return cantCalles;
    }
    
    public String getPropiedades() {
        String string = "\nPropiedades del Jugador\n\n";
        if (propiedades.isEmpty()) {
            string += "No pasees propiedades";
        } else {
            for(Propiedad p : this.propiedades){
                string += p.toString() + "\n";
            } 
        }
        return string;
    }
    
    /**
     * Metodo que retorna todas las propiedades que el jugador posee de ColorPropiedad
     * 
     * @return Propiedades de ColorPropiedad del jugador
     */
    public ArrayList<ColorPropiedad> getListaGrupoColores(){
        ArrayList<ColorPropiedad> lista = new ArrayList<>();
        for (Propiedad propiedad: propiedades){
            if ((propiedad instanceof ColorPropiedad) && (isPropietarioGrupo(((ColorPropiedad) propiedad).getGrupo()))){
                lista.add((ColorPropiedad) propiedad);
            }
        }
        return lista;
    }

    /**
     * Metodo que retorna las propiedades donde se puede constriuir casas
     * 
     * @return Propiedades del jugador donde pueden constuir casas
     */
    public ArrayList<ColorPropiedad> getPropiedadesHabitables() {
        ArrayList<ColorPropiedad> habitables = new ArrayList<>();
        for (ColorPropiedad i: getListaGrupoColores()) {
            boolean minCasa = true;
            for (ColorPropiedad j: getListaGrupoColores()) {
                if(i.getGrupo() == j.getGrupo() && i.getCantCasas() > j.getCantCasas()){
                    minCasa = false;
                }
            }
            if ((minCasa) && (i.getCantCasas() != 5)){
                habitables.add(i);
            }
        }
        return habitables;
    }

    /**
     * Metodo que retorna las propiedades sin casas, estas puedes ser hipotecadas
     * 
     * @return Propiedades sin casa del jugador
     */
    public ArrayList<Propiedad> getPropiedadesSinCasas(){
        ArrayList<Propiedad> sinCasas = new ArrayList<>();
        for (Propiedad propiedad : this.propiedades) {
            if ((propiedad instanceof ColorPropiedad) && (((ColorPropiedad) propiedad).getCantCasas() != 0));
            else {
                sinCasas.add(propiedad);
            }
        }
        return sinCasas;
    }

    /**
     * Metodo que retorna las propiedades hipotecadas del jugador
     * 
     * @return Propiedades hipotecados del jugador
     */
    public ArrayList<Propiedad> getPropiedadesHipotecadas(){
        ArrayList<Propiedad> hipotecadas = new ArrayList<>();
        for (Propiedad propiedad : this.propiedades) {
            if (propiedad.hipotecada){
                hipotecadas.add(propiedad);
            }
        }
        return hipotecadas;
    }

    /**
     * Metodo que verifica si un jugador es dueño de una propiedad
     * 
     * @return true si el jugador es el propietario, false en caso contrario
     */
    private boolean isPropietario(Propiedad propiedad) {
        return this.propiedades.contains(propiedad);
    }

    /**
     * Metodo que verifica si un jugador es dueño de una propiedad
     * 
     * @return true si el jugador es el propietario, false en caso contrario
     */
    public boolean isPropietarioGrupo(Grupo grupo){
        int contador = 0;
        for (Propiedad propiedad : this.propiedades){
            if ((propiedad instanceof ColorPropiedad) && (((ColorPropiedad) propiedad).getGrupo() == grupo)){
                contador++;
            }
        }
        return (contador == grupo.maxGrupo);
    }
    
    @Override
    public String toString() {
        String string = "\nEstado del Jugador\n\n";
        string += "Ficha: " + this.nombre + "\n"
                + "Balance: " + this.dinero + "\n"
                + "Posicion actual: " + Tablero.tablero[this.posicion].getNombre() + "\n"
                + "Condicion: " + ((enCarcel) ? "En la carcel" : "Jugando")  + "\n"
                + "Propiedades: " + propiedades.size()  + "\n"
                + "Calles: " + getCantCalles()  + "\n"
                + "Ferrocariles: " + getCantFerrocarriles()  + "\n"
                + "Utilidades: " + getCantUtilidades()  + "\n";
        return string;
    }
}
