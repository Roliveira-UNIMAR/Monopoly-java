package models;

/**
 *
 * @author @author Richard Rivera - 28.570.753
 */
public class Mostrar {
    
    public static void ReglasBasicas(){    
        System.out.println("\n\tREGLAS BASICAS DEL JUEGO");
        System.out.println("1. Comenzando con la Banca, cada jugador lanza los dados. El jugador que logre el mayor puntaje sale de casilla de inicio.");
        System.out.println("2. Luego cada jugador inicia su ficha en la esquina de \"salida\", lanza los dados y mueve el número de espacios indicados por los dados.");
        System.out.println("3. Dos o más fichas pueden estar en el mismo espacio al mismo tiempo.");
        System.out.println("4. Si lanzas dobles, mueves tu ficha y estás sujeto a cualquier privilegio o penalización relacionada con el espacio en el que aterrices. Luego puedes lanzar de nuevo y mover tu ficha como antes.");
        System.out.println("5. Si alguna vez lanzas dobles tres veces seguidas, tienes que ir inmediatamente a la cárcel.");  
        System.out.println("6. Cada vez que la ficha de un jugador aterriza o pasa por encima de la salida, el banquero le paga a ese jugador un salario de 200$.");
        System.out.println("7. Cuando aterrizas en una propiedad que es de otro jugador, el propietario le cobra el alquiler de acuerdo con la lista impresa en su tarjeta.");
        System.out.println("8. Al llegar a \"Impuestos\" simplemente paga lo que se indica.");
        System.out.println("9. El que es enviado a la carcel no recibe el sueldo de 200$ al llegar a salida.");
        System.out.println("10. Cuando eres enviado a la carcel puedes pagar 50$ o esperar tres turnos");
        System.out.println("11. ¡Los jugadores en bancarrota deben retirarse del juego y el último jugador que quede en el juego es el ganador!"); 
    }
    
    public static void MenuPrincipal(){
        System.out.println("\n\tMONOPOLY");
        System.out.println("1. Iniciar Juego");
        System.out.println("2. Mostrar Reglas Basicas");
        System.out.println("3. Salir");
    }
    
    public static void error(String msj) {
        System.out.println("\n\tError: " + msj);
    }
    
    public static void menuUsuario(){
        System.out.println("\n\tMenu");
        System.out.println("\t1. Tirar dado  y avanzar");
        System.out.println("\t2. Mostar Estado");
        System.out.println("\t3. Comprar casa");
        System.out.println("\t4. Hipoteca");
    }
    
    public static void propiedad(ColorPropiedad propiedad){
        System.out.println(propiedad.toString());
    }
        
     public static void propiedadComprada(String propiedad) {
        System.out.println("La propiedad " + propiedad + " ha sido comparada exitosamente");
    }
    
    public static void propiedadDisponible(boolean disponible){
        if (disponible) {
            System.out.println("Esta propiedad esta en venta.");
        } else {
            System.out.println("Esta propiedad no esta en venta."); 
        }
    }
    
    public static void carta(){
        
    }

    public static void carta(String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void msj(String msj) {
        System.out.println(msj);
    }

    static void hipoteca(Jugador aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
