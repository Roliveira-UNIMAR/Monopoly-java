/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Jugador {
    String ficha;
    int dinero;
    int posicion;

    public Jugador(String ficha) {
        this.ficha = ficha;
        this.dinero = 1500;
        this.posicion = 0;
    }
    
    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    
    public void sumarDinero(int amount) {
	dinero += amount;
    }
    
    public void restarDinero(int amount) {
        dinero -= amount;
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

    public boolean isPreso() {
        return posicion == 10;
    }
    
    @Override
    public String toString() {
        String string = "";
        string += "Jugador -> [ Ficha: " + this.ficha + ", Dinero: " + this.dinero + ", Posicion: " + this.posicion + " ]";
        return string;
    }
}
