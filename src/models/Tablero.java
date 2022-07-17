package models;

/**
 *
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Tablero {
    public static Casilla[] tablero = new Casilla[40];
    public static Baraja arcaComunal = new Baraja();
    public static Baraja fortuna = new Baraja();
    
    public static void iniciar() {
        ColorPropiedad[] propiedades = Archivo.getPropiedades();
        
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
        tablero[1] = propiedades[0];
        tablero[2] = new TomarCarta(2, "ARCA COMUNAL", arcaComunal);
        tablero[3] = propiedades[1];
        tablero[4] = new Impuesto(4, "IMPUESTO SOBRE INGRESOS PÁGUESE", 200);
        tablero[5] = new Ferrocarril(5, "FERROCARRIL READING");
        tablero[6] = propiedades[2];
        tablero[7] = new TomarCarta(7, "FORTUNA", fortuna);
        tablero[8] = propiedades[3];
        tablero[9] = propiedades[4];
        tablero[10] = deVisita;
        tablero[11] = propiedades[5];
        tablero[12] = new Sevicio(12, "COMPAÑÍA DE ELECTRICIDAD");
        tablero[13] = propiedades[6];
        tablero[14] = propiedades[7];
        tablero[15] = new Ferrocarril(15, "FERROCARRIL PENSYLVANIA");
        tablero[16] = propiedades[8];
        tablero[17] = new TomarCarta(17, "ARCA COMUNAL", arcaComunal);
        tablero[18] = propiedades[9];
        tablero[19] = propiedades[10];
        tablero[20] = paradaLibre;
        tablero[21] = propiedades[11];
        tablero[22] = new TomarCarta(22, "FORTUNA", fortuna);
        tablero[23] = propiedades[12];
        tablero[24] = propiedades[13];
        tablero[25] = new Ferrocarril(25, "FERROCARRIL B. & O.");
        tablero[26] = propiedades[14];
        tablero[27] = propiedades[15];
        tablero[28] = new Sevicio(28, "COMPAÑÍA DE AGUA");
        tablero[29] = propiedades[16];
        tablero[30] = irCarcel;
        tablero[31] = propiedades[17];
        tablero[32] = propiedades[18];
        tablero[33] = new TomarCarta(33, "ARCA COMUNAL", arcaComunal);
        tablero[34] = propiedades[19];
        tablero[35] = new Ferrocarril(35, "FERROCARRIL VÍA RÁPIDA");
        tablero[36] = new TomarCarta(36, "FORTUNA", fortuna);
        tablero[37] = propiedades[20];
        tablero[38] = new Impuesto(38, "IMPUESTO SOBRE POSESIONES DE LUJO PÁGUENSE", 100);
        tablero[39] = propiedades[21];
    }

    public static Casilla getActualCasilla(Jugador actualJugador) {
        int pos = actualJugador.getPosicion();
        return tablero[pos];
    }
}
