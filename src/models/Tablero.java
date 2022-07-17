package models;

import java.util.ArrayList;
import models.cartas.*;

/**
 *
 * @author Rodrigo Oliveira 29.655.609
 * @author Shaenndry Carreño - 30.299.949
 * @author Edgar Ruiz - 30.065.695
 * @author Richard Rivera - 28.570.753
 */
public class Tablero {
    public static Casilla[] tablero = new Casilla[40];
    public static Baraja arcaComunal = new Baraja();
    public static Baraja fortuna = new Baraja();
    public static ArrayList<Jugador> jugadores;
    
    public static void iniciar() {
        ArrayList<ColorPropiedad> propiedades = Archivo.getPropiedades();
        
        Casilla salida = new Casilla(0, "SALIDA") {
            @Override
            public void hacer(Jugador actualJugador) {}
        };
        
        Casilla deVisita = new Casilla(10, "DE VISITA NADA MÁS ") {
            @Override
            public void hacer(Jugador actualJugador) {}
        };
        
        Casilla paradaLibre = new Casilla(20, "PARADA LIBRE") {
            @Override
            public void hacer(Jugador actualJugador) {}
        };
        
        Casilla irCarcel = new Casilla(30, "VÁYASE A LA CÁRCEL") {
            @Override
            public void hacer(Jugador actualJugador) { 
                       Carcel.enviarACarcel(actualJugador);
            }
        };
        
        tablero[0] = salida;
        tablero[1] = propiedades.get(0);
        tablero[2] = new TomarCarta(2, "ARCA COMUNAL", arcaComunal);
        tablero[3] = propiedades.get(0);
        tablero[4] = new Impuesto(4, "IMPUESTO SOBRE INGRESOS PÁGUESE", 200);
        tablero[5] = new Ferrocarril(5, "FERROCARRIL READING");
        tablero[6] = propiedades.get(2);
        tablero[7] = new TomarCarta(7, "FORTUNA", fortuna);
        tablero[8] = propiedades.get(3);
        tablero[9] = propiedades.get(4);
        tablero[10] = deVisita;
        tablero[11] = propiedades.get(5);
        tablero[12] = new Utilidad(12, "COMPAÑÍA DE ELECTRICIDAD");
        tablero[13] = propiedades.get(6);
        tablero[14] = propiedades.get(7);
        tablero[15] = new Ferrocarril(15, "FERROCARRIL PENSYLVANIA");
        tablero[16] = propiedades.get(8);
        tablero[17] = new TomarCarta(17, "ARCA COMUNAL", arcaComunal);
        tablero[18] = propiedades.get(9);
        tablero[19] = propiedades.get(10);
        tablero[20] = paradaLibre;
        tablero[21] = propiedades.get(11);
        tablero[22] = new TomarCarta(22, "FORTUNA", fortuna);
        tablero[23] = propiedades.get(12);
        tablero[24] = propiedades.get(13);
        tablero[25] = new Ferrocarril(25, "FERROCARRIL B. & O.");
        tablero[26] = propiedades.get(14);
        tablero[27] = propiedades.get(15);
        tablero[28] = new Utilidad(28, "COMPAÑÍA DE AGUA");
        tablero[29] = propiedades.get(16);
        tablero[30] = irCarcel;
        tablero[31] = propiedades.get(17);
        tablero[32] = propiedades.get(18);
        tablero[33] = new TomarCarta(33, "ARCA COMUNAL", arcaComunal);
        tablero[34] = propiedades.get(19);
        tablero[35] = new Ferrocarril(35, "FERROCARRIL VÍA RÁPIDA");
        tablero[36] = new TomarCarta(36, "FORTUNA", fortuna);
        tablero[37] = propiedades.get(20);
        tablero[38] = new Impuesto(38, "IMPUESTO SOBRE POSESIONES DE LUJO PÁGUENSE", 100);
        tablero[39] = propiedades.get(21);
        iniciarBarajas();
    }

    public static Casilla getActualCasilla(Jugador actualJugador) {
        int pos = actualJugador.getPosicion();
        return tablero[pos];
    }

    public static void setJugadores(ArrayList<Jugador> actuales) {
        jugadores = actuales;
    }
    
    public static ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    private static void iniciarBarajas() {
        arcaComunal.ponerAbajo(new CartaIrCarcel());
        arcaComunal.ponerAbajo(new CartaTomarPagar(50, "LA VENTA DE TUS ACCIONES TE PRODUCE 50$"));
        arcaComunal.ponerAbajo(new CartaTomarPagar(-100, "PAGA AL HOSTPITAL 100$"));
        arcaComunal.ponerAbajo(new CartaTomarPagar(100, "RECIBE 100$ POR LOS INTERESES DE TU PLAZO FIJO"));
        arcaComunal.ponerAbajo(new CartaTomarPagar(20, "HACIENDA TE DEVUELVE 20$"));
        arcaComunal.ponerAbajo(new CartaTomarPagar(-50, "PAGA TU POLIZA DE SEGURO 50$"));
        arcaComunal.ponerAbajo(new CartaMover(0, "COLOCATE EL LA CASILLA DE SALIDA"));
        arcaComunal.ponerAbajo(new CartaTomarPagarTodos(getJugadores(), 100, "ES TU CUMPLEAÑOS RECIBE DE CADA JUGADOR 10$"));
        arcaComunal.ponerAbajo(new CartaTomarPagar(200, "ERROR DE LA BANCA A TU FAVOR. RECIBE 200$"));
        arcaComunal.ponerAbajo(new CartaTomarPagar(25, "RECIBE 25$ COMO INTERESES DE TUS ACCIONES PREFERENCIALES"));
        arcaComunal.ponerAbajo(new CartaMover(11, "VE A LA PLAZA SAN CARLOS, SI PASAS POR LA CASILLA DE SALIDA, COBRA 200$"));
        arcaComunal.ponerAbajo(new CartaSalirCarcel());
        arcaComunal.ponerAbajo(new CartaTomarPagar(-50, "PAGA LA FACTURA DEL MEDICO 50$"));
        arcaComunal.ponerAbajo(new CartaTomarPagar(10, "HAZ GANADO EL SEGUNDO PREMIO DE BELLEZA. COBRA 10$"));
        arcaComunal.ponerAbajo(new CartaTomarPagar(50, "PAGA LA FACTURA DEL MEDICO 50$"));
        arcaComunal.ponerAbajo(new CartaTomarPagar(100, "COBRAS UNA HERENCIA DE 100$"));
        fortuna.ponerAbajo(new CartaRepararCasas(25, 100,"HAZ REPARACIONES EN TODOS TUS EDIFICIOS, PAGAR POR CADA CASA 25$, PAGAR POR CADA HOTEL 100$"));
        fortuna.ponerAbajo(new CartaMover(0, "COLOCATE EL LA CASILLA DE SALIDA"));
        fortuna.ponerAbajo(new CartaMover(16, "VE A PLAZA SANTIAGO, SI PASAS POR LA CASILLA DE SALIDA, COBRA 200$"));
        fortuna.ponerAbajo(new CartaMover(-150, "PAGA POR GASTOS ESCOLARES 150$"));
        fortuna.ponerAbajo(new CartaMoverA(new int[]{5, 15, 25, 35}, "AVANZA AL FERROCARRIL MAS CERCANO"));
        fortuna.ponerAbajo(new CartaIrCarcel());
        fortuna.ponerAbajo(new CartaTomarPagar(50, "EL BANCO TE PAGA 50$ DE INTERESES"));
        fortuna.ponerAbajo(new CartaTomarPagar(150, "RECIBES EL RESCATE POR EL SEGURO DE TUS EDIFICIOS. COBRA 150$"));
        fortuna.ponerAbajo(new CartaRepararCasas(40, 115, "LA INSPECCION DE LA CALLE TE OBLIGA A REALIZAR REPARACIONES, PAGA 40$ POR CASA Y 115$ POR HOTEL."));
        fortuna.ponerAbajo(new CartaMover(-3, "RETROCE 3 CASILLAS"));
        fortuna.ponerAbajo(new CartaTomarPagar(100, "HAS GANADO EL CONCURSO DE CRUCIGRAMAS. COBRA 100$."));
        fortuna.ponerAbajo(new CartaMover(20, "VE A PARADA LIBRE"));
        fortuna.ponerAbajo(new CartaMover(29, "ADELANTA HASTA JARDINES MARVIN, SI PASAS POR LA CASILLA DE SALIDA, COBRA 200$."));
        fortuna.ponerAbajo(new CartaTomarPagar(-20, "MULTA POR EMBRIAGUEZ. PAGA 20$"));
        fortuna.ponerAbajo(new CartaTomarPagar(-15, "MULTA POR EXCESO DE VELOCIDAD.PAGA 15$"));
        fortuna.ponerAbajo(new CartaSalirCarcel());
        arcaComunal.barajear();
        fortuna.barajear();
    }
}
