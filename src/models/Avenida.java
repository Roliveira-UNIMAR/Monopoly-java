public class Avenida {
    private String propietario;
    private int renta;
    private int unaCasa;
    private int dosCasa;
    private int tresCasa;
    private int cuatroCasa;
    private int hotel;
    private int costoCasa;
    private int cosHipoteca;
    private boolean[] casas;
    private boolean hipotecada;
    
    public Avenida() {
        this.propietario = null;
        this.renta = 0;
        this.unaCasa = 0;
        this.dosCasa = 0;
        this.tresCasa = 0;
        this.cuatroCasa = 0;
        this.hotel = 0;
        this.costoCasa = 0;
        this.cosHipoteca = 0;
        this.casas = new boolean[] {false, false, false, false, false};
        this.hipotecada = false;
    }
    
    public Avenida(int r, int una, int dos, int tres, int cuatro, int h, int cos, int hipo) {
        this.propietario = null;
        this.renta = r;
        this.unaCasa = una;
        this.dosCasa = dos;
        this.tresCasa = tres;
        this.cuatroCasa = cuatro;
        this.hotel = h;
        this.costoCasa = cos;
        this.cosHipoteca = hipo;
        this.casas = new boolean[] {false, false, false, false, false};
        this.hipotecada = false;
    }
    
    public String getPropietario() {
        return this.propietario;
    }
    
    public void setPropietario(String ficha) {
        this.propietario = ficha;
    }
    
    public void setHipotecada(boolean tf) {
        this.hipotecada = tf;
    }
    
    public boolean isHipotecada() {
        return this.hipotecada;
    }
    
    public int getRenta() {
        int cantCasas = 0;
        for (int i = 0; i < casas.length; i++) {
            if (casas[i]) {
                cantCasas++;
            } 
        }
        switch (cantCasas) {
            case 1:
                return this.unaCasa;
            case 2:
                return this.dosCasa;
            case 3:
                return this.tresCasa;
            case 4:
                return this.cuatroCasa;
            case 5:
                return this.hotel;
            default:
                return this.renta;
        }
    }
    
    public void comprarCasa() {
        for (int i = 0; i < casas.length; i++) {
            if (!casas[i]) {
                casas[i] = true;
                break;
            } 
        } 
    }
}
