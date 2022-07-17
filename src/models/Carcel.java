package models;

import java.util.ArrayList;

/**
 *
 * @author Rodrigo Oliveira 29.655.609
 */
public class Carcel {
    
    public static void enviarACarcel(Jugador jugador) {
        jugador.enCarcel = true;
        Mostrar.msj("Ahora estás en la cárcel durante los próximos turnos");
        jugador.moverA(10);
    }

    public static void carcelTurno(Jugador actualJugador) {
        actualJugador.turnosCarcel++;
        Mostrar.msj("Turnos en carcel: " + actualJugador.turnosCarcel);
        int op;
        do {
            Mostrar.menuCarcel();
            op = Leer.opcion(5, "Escoja una opcion");
            switch (op) {
                case 1:
                    if (actualJugador.turnosCarcel <= 3) { 
                        Dado.lanzar();
                        if (Dado.isDoble()) {
                            actualJugador.enCarcel = false;
                            Mostrar.msj("Saliste de la carcel, por doble");
                            actualJugador.mover(Dado.getResultado());                            
                        } else {
                            if (actualJugador.turnosCarcel < 3) {
                                Mostrar.msj("Se cobraron 50$ y sales de la carcel");
                                actualJugador.enCarcel = false;
                                actualJugador.setDinero(-50);
                                actualJugador.mover(Dado.getResultado());
                            } else {
                                Mostrar.msj("Sigues en la carcel"); 
                            }   
                        }
                    }
                    break;
                case 2:
                    actualJugador.setDinero(-50);
                    Monopolio.turno(actualJugador);
                    break;
                case 3:
                    if (actualJugador.cartasSalirCarcel > 0) {
                        actualJugador.enCarcel = false;
                        actualJugador.cartasSalirCarcel--;
                        Mostrar.msj("Saliste de la carcel, por tarjeta");
                    } else {
                         Mostrar.msj("No posees tarjeta SALIR DE LA CARCEL GRATIS");
                    }
                    break;    
                case 4:
                    actualJugador.toString();
                    break;
                case 5:
                    ArrayList<ColorPropiedad> pHabitables = actualJugador.getPropiedadesHabitables();
                    if (pHabitables.isEmpty()) {
                        Mostrar.msj("No posees ninguna propiedad donde puedas construir casa");
                    } else {
                        Mostrar.colorPropiedad(pHabitables);
                        int opc = Leer.opcion(pHabitables.size(), "Escoje una propiedad: ");
                        ColorPropiedad cp = pHabitables.get(opc - 1);
                        cp.comprarCasa();
                    }
                    break;
                case 6:
                    ArrayList<Propiedad> pSinCasa = actualJugador.getPropiedadesSinCasas();
                    if (pSinCasa.isEmpty()) {
                        Mostrar.msj("No posees ninguna propiedad que puedas hipotecar");
                    } else {
                        Mostrar.propiedad(pSinCasa);
                        int opc = Leer.opcion(pSinCasa.size(), "Escoje una propiedad: ");
                        Propiedad p = pSinCasa.get(opc - 1);
                        actualJugador.hipotecar(p);
                    }
                    break;
                default:
                    Mostrar.error("Opcion no valida");
            }
        } while (op != 1);
    }
}
