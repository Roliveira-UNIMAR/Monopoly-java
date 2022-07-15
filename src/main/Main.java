/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.util.Scanner;

/**
 *
 * @author Richard Rivera - 28.570.753
 */
public class Main {


    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        
        boolean salir = false;
        int op = 0;
        
        do{
            Mostrar.MenuPrincipal();
            op = Leer.opcion(3, "Elija la opcion a realizar: ");
            switch (op) {
                case 1:
                    boolean terminada = false;
                        do {
                            switch (op) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                default:
                                if (op != -1) {
                                    Mostrar.error("La opcion no es valida.");
                                }
                            }
                        }while(!terminada); 
                    break;
                case 2:  
                    break;
                case 3: 
                    break;
                default:
            }
        }while(!salir); //Culminar.
    }
} //No terminada, Implementare una idea y la plasmare en un rato jaja

        

    

