/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import models.*;
import java.util.ArrayList;

/**
 *
 * @author Richard Rivera - 28.570.753
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Jugador> jugadores;
        boolean salir = false;
        int op = 0;
        
        do{
            Mostrar.menuPrincipal();
            op = Leer.opcion(3, "Elija la opcion a realizar: ");
            switch (op) {
                case 1:
                    jugadores = Monopolio.crearJugadores(4);
                    Tablero.setJugadores(jugadores);
                    Tablero.iniciar();
                    do {
                        for (int i = 0; i < jugadores.size(); i++) {
                            Jugador actualJugador = jugadores.get(i);
                            Monopolio.turno(actualJugador);
                        }
                    } while (!Monopolio.getTermino());
                    break;
                case 2:
                    Mostrar.reglasBasicas();
                    break;
                case 3:
                    salir = true;
                    Mostrar.salida();
                    break;
                default:
            }
        }while(!salir); //Culminar.
    }
} //No terminada, Implementare una idea y la plasmare en un rato jaja

        

    

