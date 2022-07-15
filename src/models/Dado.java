/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Random;

/**
 *
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Dado {
    static Random random = new Random();
    public static int dado1, dado2;
    
    public static void lanzarDado(){
        dado1 = random.nextInt(6) + 1;
        dado2 = random.nextInt(6) + 1; 
    }
    
    public static boolean isDoble() {
        return dado1 == dado2;
    }
}
