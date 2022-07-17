package models;

import java.util.Scanner;

/**
 *
 * @author Rodrigo Oliveira - 29.655.609
 * @author Richard Rivera - 28.570.753
 */
public class Leer {
    
    static Scanner leer = new Scanner(System.in);
    
    public static int opcion(int max, String msj) {
        int op = -1;
        try {
            do {
                if (((op < 1) || (op > max)) && (op != -1)) {
                    Mostrar.error("La opcion no es valida");
                }
                System.out.print("\n" + msj);
                String l = leer.next();
                op = Integer.parseInt(l);
            } while ((op < 1) || (op > max));
        } catch(NumberFormatException nfe) {
           Mostrar.error("La opcion debe ser un numero");
        }
        return op;
    }
    
}
