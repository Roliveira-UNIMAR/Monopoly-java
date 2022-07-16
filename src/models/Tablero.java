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
public class Tablero {
    Casilla[] tablero = new Casilla[39];
    
    public static void iniciar() {
        Propiedad[] propiedades = Archivo.getPropiedades();
        
        tablero[0] = new Salida();
        tablero[1] = propiedades[0];
        tablero[2] = new ArcaComunal(2);
        tablero[3] = propiedades[1];
        tablero[4] = new Impuesto(4, "IMPUESTO SOBRE INGRESOS PÁGUESE", 200);
        tablero[5] = new Ferrocaril(5, "FERROCARRIL READING");
        tablero[6] = propiedades[2];
        tablero[7] = new Fortuna(7);
        tablero[8] = propiedades[3];
        tablero[9] = propiedades[4];
        tablero[10] = new Carcel(10);
        tablero[11] = propiedades[5];
        tablero[12] = new Sevicio(12, "COMPAÑÍA DE ELECTRICIDAD");
        tablero[13] = propiedades[6];
        tablero[14] = propiedades[7];
        tablero[15] = new Ferrocaril(15, "FERROCARRIL PENSYLVANIA");
        tablero[16] = propiedades[8];
        tablero[17] = new ArcaComunal(7);
        tablero[18] = propiedades[9];
        tablero[19] = propiedades[10];
        tablero[20] = new Libre(20);
        tablero[21] = propiedades[11];
        tablero[22] = new Fortuna(22);
        tablero[23] = propiedades[12];
        tablero[23] = propiedades[13];
        tablero[24] = new Ferrocaril(24, "FERROCARRIL B. & O.");
        tablero[25] = propiedades[14];
        tablero[26] = propiedades[15];
        tablero[27] = new Sevicio(12, "COMPAÑÍA DE AGUA");
        tablero[28] = propiedades[16];
        tablero[29] = new Carcel(29);
        tablero[30] = propiedades[17];
        tablero[31] = propiedades[18];
        tablero[32] = new ArcaComunal(31);
        tablero[32] = propiedades[19];
        tablero[34] = new Ferrocaril(34, "FERROCARRIL VÍA RÁPIDA");
        tablero[35] = new Fortuna(35);
        tablero[36] = propiedades[20];
        tablero[37] = new Impuesto(36, "IMPUESTO SOBRE POSESIONES DE LUJO PÁGUENSE", 100);
        tablero[38] = propiedades[21];  
    }
}
