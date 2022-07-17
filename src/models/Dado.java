package models;

import java.util.Random;

/**
 *
 * @author Edgar Ruiz - 30.065.695
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Dado {
    static Random random = new Random();
    public static int dado1, dado2;
    
    public static void lanzar() {
        dado1 = random.nextInt(6) + 1;
        dado2 = random.nextInt(6) + 1;
    }
    
    public static int getResultado() {
        return dado1 + dado2;
    }
    
    public static boolean isDoble() {
        return dado1 == dado2;
    }
}
