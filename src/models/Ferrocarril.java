/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author RICHARD RIVERA
 */
public class Ferrocarril extends Casilla{
    private String Propietario;
    private final String Nombre = "";
    private int costo;
    private int CantFerrocar;
    private final int costoFerrocar = 200;
    private final int costHipoteca = 100;
    private boolean Hipoteca = false;
    int renta[];
    
    public Ferrocarril(){
        super();
        this.Propietario = null;
        this.costo = 0;
        this.CantFerrocar = 0;
        this.Hipoteca = false;
        this.renta = new int[4];
    }
    
    public Ferrocarril(int pos, String n ,int r, int r1, int r2, int r3, int cos, int CosF) {
        super(pos, n);
        this.Propietario = null;
        this.CantFerrocar = CosF;
        this.costo = cos;
        this.Hipoteca = false;
        this.renta = new int[] {r, r1, r2, r3};
    }
    
    public String getPropietario() {
        return this.Propietario;
    }
    
    public void setPropietario(String ficha) {
        this.Propietario = ficha;
    }

    public int getCantFerrocarril() {
        return this.CantFerrocar;
    }

    public void setCantFerrocaril() {
        this.CantFerrocar++;
    }
    
    public int getRenta() {
        switch (this.CantFerrocar) {
            case 1:
                return this.renta[1];
            case 2:
                return this.renta[2];
            case 3:
                return this.renta[3];
            default:
                return this.renta[0];
        }
    }

    public int getCostoFerrocarril() {
        return this.costoFerrocar;
    }

    public int getCostoHipoteca() {
        return this.costHipoteca;
    }
    
    @Override
    public String toString(){
        String string = "";
        string += "\n\t" + this.Nombre + "\n\n";
        string += "Compra: " + this.renta[0] + "$" + "\n\n";
        string += "Con 1 Ferrocarril: " + this.renta[1] + "$" + "\n";
        string += "Con 2 Ferrocarriles: " + this.renta[2] + "$" + "\n";
        string += "Con 3 Ferrocarriles: " + this.renta[3] + "$" + "\n";
        string += "Con 4 Ferrocarriles: " + this.renta[4] + "$" + "\n";
        string += "Hipoteca: " + this.costHipoteca + "$" + "\n\n";
        string += "Los Ferrocarriles cuestan: " + this.costoFerrocar + "$" + "\n";
        return string;
    }

    @Override
    public void hacer(Jugador actualJugador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}
