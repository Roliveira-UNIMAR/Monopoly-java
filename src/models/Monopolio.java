package models;

import java.util.ArrayList;

/**
 *
 * @author Rodrigo Oliveira 29.655.609
 * @author Shaenndry Carreño - 30.299.949
 * @author Edgar Ruiz - 30.065.695
 * @author Richard Rivera - 28.570.753
 */
public class Monopolio {
    public static final String[] FICHAS = new String[] {"GATO", "BUQUE", "TREN", "SOMBRERO"};
    
    public static ArrayList<Jugador> crearJugadores(int nJugadores){
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Jugador nuevo = new Jugador();
        String[] disponibles = FICHAS;
        for (int i = 1; i <= nJugadores; i++) {
            boolean fracaso = true;
            do {
                Mostrar.crearJuador(i, disponibles);
                int op = Leer.opcion(4, "Elija una ficha: ");
                if (op != -1) {
                    if (disponibles[op - 1] != null ) {
                        nuevo = new Jugador(FICHAS[op - 1]);
                        disponibles[op - 1] = null;
                        jugadores.add(nuevo);
                        fracaso = false;
                    }
                }
            } while (fracaso);
        }
        return jugadores;
    }
    
    public static void turno(Jugador actualJugador){
        int nDobles = 0;
        Mostrar.texto(actualJugador.getNombre() + " es tu turno!");
        if (actualJugador.enCarcel) {
            Carcel.carcelTurno(actualJugador);
        } 
        if (!actualJugador.enCarcel) {
            int op;
            do {
                Mostrar.menuUsuario();
                op = Leer.opcion(5, "Escoja una opcion: ");
                switch (op) {
                    case 1:
                        Mostrar.texto("Posicion: " + Tablero.getActualCasilla(actualJugador).getNombre());
                        do{
                            nDobles++;
                            Dado.lanzar();
                            Mostrar.texto("Obtuviste al lanzar los dados: " + Dado.dado1 + " + " + Dado.dado2 + " = " + Dado.getResultado());
                            actualJugador.mover(Dado.getResultado());
                            if (nDobles == 3){
                                Carcel.enviarACarcel(actualJugador);
                            }
                        } while ((nDobles < 3) && (Dado.isDoble()));
                        break;
                    case 2:
                        Mostrar.texto(actualJugador.toString());
                        break;
                    case 3:
                        ArrayList<ColorPropiedad> pHabitables = actualJugador.getPropiedadesHabitables();
                        if (pHabitables.isEmpty()) {
                            Mostrar.texto("No posees ninguna propiedad donde puedas construir casa");
                        } else {
                            Mostrar.colorPropiedad(pHabitables);
                            int opc = Leer.opcion(pHabitables.size(), "Escoje una propiedad: ");
                            ColorPropiedad cp = pHabitables.get(opc - 1);
                            cp.comprarCasa();
                        }
                        break;
                    case 4:
                        ArrayList<Propiedad> pSinCasa = actualJugador.getPropiedadesSinCasas();
                        if (pSinCasa.isEmpty()) {
                            Mostrar.texto("No posees ninguna propiedad que puedas hipotecar");
                        } else {
                            Mostrar.propiedad(pSinCasa);
                            int opc = Leer.opcion(pSinCasa.size(), "Escoje una propiedad: ");
                            Propiedad p = pSinCasa.get(opc - 1);
                            actualJugador.hipotecar(p);
                        }
                        break;
                }
            } while (op != 1);
        }
            
            
            
        }

    public static boolean getTermino() {
        boolean[] termino = new boolean[] {false, false, false, false};
        int enBancarrota = 0;
        ArrayList<Jugador> jugadores;
        jugadores = Tablero.getJugadores();
        for (int i = 0; i < jugadores.size(); i++) {
            termino[i] = jugadores.get(i).isBancarota();   
        }
        for (int i = 0; i < termino.length; i++) {
           if (termino[i]) {
               enBancarrota++;
           }  
        }
        return enBancarrota >= 3;
    }
}
