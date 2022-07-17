package models;

/**
 *
 * @author Rodrigo Oliveira - 29.655.609
 * @author Richard Rivera - 28.570.753
 * @author Shaenndry Carreño - 30.299.949
 */
public class ColorPropiedad extends Propiedad {
    private final Grupo grupo;
    private int rentas[];
    private int cantCasas;
    private int costoCasa;
    private int costoHipoteca;
    
    public ColorPropiedad() {
        super();
        this.grupo = null;
        this.rentas = new int[6];
        this.cantCasas = 0;
        this.costoCasa = 0;
        this.costoHipoteca = 0;
    }
    
    public ColorPropiedad(int pos, String n, int p, int r, int r1, int r2, int r3, int r4, int r5, int cos, int hipo, Grupo g) {
        super(pos, n, p);
        this.grupo = g;
        this.rentas = new int[] {r, r1, r2, r3, r4, r5};
        this.cantCasas = 0;
        this.costoCasa = cos;
        this.costoHipoteca = hipo;
    }

     public Grupo getGrupo() {
         return this.grupo;
     }

    public void comprarCasa(){
        getPropietario().setDinero(-costoCasa);
        cantCasas++;
        if(cantCasas == 5){
            Mostrar.msj("Compraste un hotel en " + nombre + " por 4 casas + " + costoCasa + "$");
        } else {
            System.out.println("Compraste un casa en " + nombre + " por " + + costoCasa + "$");
        }  
    }
    
    public int getCantCasas() {
        return this.cantCasas;
    }
    
    public int getRenta() {
        switch (this.cantCasas) {
            case 1:
                return this.rentas[1];
            case 2:
                return this.rentas[2];
            case 3:
                return this.rentas[3];
            case 4:
                return this.rentas[4];
            case 5:
                return this.rentas[5];
            default:
                return this.rentas[0];
        }
    }
    
    public int getCostoCasa() {
        return this.costoCasa;
    }

    public int getCostoHipoteca() {
        return this.costoHipoteca;
    }

    @Override
    public void hacer(Jugador actualJugador) {
        if (propietario == actualJugador) {
           // No hacer nada
        } else if ((!hipotecada) && (propietario != actualJugador)) {
            Mostrar.msj(actualJugador.getNombre() + " paga a " + propietario.getNombre() + " " + getRenta() + "$ de renta");
                actualJugador.pagar(propietario, getRenta());
        } else {
            ofertar(actualJugador);
        } 
    }
    
    @Override
    public String toString() {
        String string = "";
        string += "\n\t" + this.nombre + "\n\n"
                + "Renta: " + this.rentas[0] + "$" + "\n"
                + "Con 1 Casa: " + this.rentas[1] + "$" + "\n"
                + "Con 2 Casa: " + this.rentas[2] + "$" + "\n"
                + "Con 3 Casa: " + this.rentas[3] + "$" + "\n"
                + "Con 4 Casa: " + this.rentas[4] + "$" + "\n"
                + "Con Hotel: " + this.rentas[5] + "$" + "\n\n"
                + "Hipoteca: " + this.costoHipoteca + "$" + "\n\n"
                + "Las Casa cuestan: " + this.costoCasa + "$" + "\n"
                + "El Hotel cuesta: 4 casas + " + this.costoCasa + "$";
        return string;
    }
}
