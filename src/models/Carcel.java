package models;

/**
 *
 * @author Rodrigo Oliveira 29.655.609
 */
public class Carcel {
    
    public static void enviarACarcel(Jugador jugador) {
        jugador.enCarcel = true;
        Mostrar.msj("Ahora estás en la cárcel durante los próximos turnos");
        jugador.mover(10);
        Monopolio.finTurno(jugador);
    }

    public static boolean carcelTurno(Jugador actualJugador) {
        actualJugador.turnosCarcel++;
        Mostrar.msj("Turnos en carcel: " + actualJugador.turnosCarcel);
        
        int tirada = Dado.lanzar();
        if (actualJugador.turnosCarcel <= 3) { 
            if (Dado.isDoble()) {
                actualJugador.enCarcel = false;
                actualJugador.mover(tirada);
            } else {
                if (actualJugador.turnosCarcel < 3) {
                    Mostrar.msj("Se cobraron 50$ y sales de la carcel");
                    actualJugador.enCarcel = false;
                    actualJugador.setDinero(-50);
                    actualJugador.mover(tirada);
                } else {
                    Mostrar.msj("Sigues en la carcel"); 
                }   
            }
        }
        return actualJugador.enCarcel;
    }
}
