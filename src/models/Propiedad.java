package models;

/**
 *
 * @author Rodrigo Oliveira - 29.655.609
 * @author Richard Rivera - 28.570.753
 * @author Shaenndry Carreño - 30.299.949
 */
public class Propiedad extends Casilla {
    private String propietario;
    private int costo;
    private int rentas[];
    private int cantCasas;
    private int costoCasa;
    private int costoHipoteca;
    private boolean hipotecada;
    
    public Propiedad() {
        super();
        this.propietario = null;
        this.costo = 0;
        this.rentas = new int[6];
        this.cantCasas = 0;
        this.costoCasa = 0;
        this.costoHipoteca = 0;
        this.hipotecada = false;
    }
    
    public Propiedad(int pos, String n, int cos, int r, int r1, int r2, int r3, int r4, int r5, int cosC, int hipo) {
        super(pos, n);
        this.propietario = null;
        this.costo = cos;
        this.rentas = new int[] {r, r1, r2, r3, r4, r5};
        this.cantCasas = 0;
        this.costoCasa = cosC;
        this.costoHipoteca = hipo;
        this.hipotecada = false;
    }
    
    public String getPropietario() {
        return this.propietario;
    }
    
    public void setPropietario(String ficha) {
        this.propietario = ficha;
    }

    public int getCosto() {
        return costo;
    }
    
    public void setHipotecada(boolean tf) {
        this.hipotecada = tf;
    }
    
    public boolean isHipotecada() {
        return this.hipotecada;
    }

    public int getCantCasas() {
        return this.cantCasas;
    }

    public void setCantCasas() {
        this.cantCasas++;
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
    public String toString() {
        String string = "";
        string += "\n\t" + this.nombre + "\n\n";
        string += "Alquiler: " + this.rentas[0] + "$" + "\n\n";
        string += "Con 1 Casa: " + this.rentas[1] + "$" + "\n";
        string += "Con 2 Casa: " + this.rentas[2] + "$" + "\n";
        string += "Con 3 Casa: " + this.rentas[3] + "$" + "\n";
        string += "Con 4 Casa: " + this.rentas[4] + "$" + "\n";
        string += "Con Hotel: " + this.rentas[5] + "$" + "\n\n";
        string += "Hipoteca: " + this.costoHipoteca + "$" + "\n\n";
        string += "Las Casa cuestan: " + this.costoCasa + "$" + "\n";
        string += "El Hotel cuesta: 4 casas + " + this.costoCasa + "$";
        return string;
    }
}
