package models;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

 /**
 *
 * @author Rodrigo Oliveira 29.655.609
 * @author Shaenndry Carreño - 30.299.949
 * @author Edgar Ruiz - 30.065.695
 * @author Richard Rivera - 28.570.753
 */
public class Archivo {
    
    
    //Se leera el txt con los datos de las propiedades (Casas, hoteles, etc...)
    public static ArrayList<ColorPropiedad> getPropiedades() {
        ArrayList<ColorPropiedad> propiedades = new ArrayList<>();
        ColorPropiedad tempCP = new ColorPropiedad();
        try {
            Scanner leer = new Scanner(new FileReader("src\\models\\propiedades.txt"));
            int pos = 0;
            String n = null;
            int p = 0;
            int[] r = new int[6];
            int cos = 0;
            int hipo = 0;
            Grupo g = null;
            int contador = 0;
            while (leer.hasNextLine()) {
                contador++;
                String line = leer.nextLine();
                String[] separado = line.split(":");
                pos = Integer.parseInt(separado[0]);
                n = separado[1];
                p = Integer.parseInt(separado[2]);
                for (int i = 0; i < 6; i++) {
                    r[i] = Integer.parseInt(separado[3 + i]); 
                }
                cos = Integer.parseInt(separado[9]);
                hipo = Integer.parseInt(separado[10]);
                switch (contador) {
                    case 1:
                    case 2:
                        g = Grupo.MARRON;
                        break;
                    case 3:
                    case 4:
                    case 5:
                        g = Grupo.CIELO;
                        break;
                    case 6:
                    case 7:
                    case 8:
                        g = Grupo.ROSA;
                        break;
                    case 9:
                    case 10:
                    case 11:
                        g = Grupo.NARANJA;
                        break;
                    case 12:
                    case 13:
                    case 14:
                        g = Grupo.ROJO;
                        break;
                    case 15:
                    case 16:
                    case 17:
                        g = Grupo.AMARRILLO;
                        break;
                    case 18:
                    case 19:
                    case 20:
                        g = Grupo.VERDE;
                        break;
                    case 21:
                    case 22:
                        g = Grupo.AZUL;
                        break;
                }
                tempCP = new ColorPropiedad(pos, n, p, r, cos, hipo, g);
                propiedades.add(tempCP);
            }
        } catch (FileNotFoundException fnfe) {
            Mostrar.error("El archivo \"propiedades.txt\" no encontrado.");
        } catch (IOException ioe) {
            Mostrar.error("El archivo \"propiedades.txt\" no se puede leer.");
        }
        return propiedades;
    }
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    

