package models;

import java.util.ArrayList;

/**
 *
 * @author @author Richard Rivera - 28.570.753
 */
public class Mostrar {
    
    public static void reglasBasicas(){    
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
    
    public static void menuPrincipal(){
        System.out.println("\n\tMONOPOLY\n");
        System.out.println("1. Iniciar Juego");
        System.out.println("2. Mostrar Reglas Basicas");
        System.out.println("3. Salir");
    }
    
    public static void error(String msj) {
        System.out.println("\nError: " + msj);
    }
    
    public static void menuUsuario(){
        System.out.println("\n\tMenu Usuario\n");
        System.out.println("1. Tirar dado  y avanzar");
        System.out.println("2. Mostar Estado");
        System.out.println("3. Comprar casa");
        System.out.println("4. Hipoteca");
    }
    
    public static void menuCarcel(){
        System.out.println("\n\tMenu Carcel\n");
        System.out.println("1. Tirar dado para salir");
        System.out.println("2. Pagar 50$ para salir");
        System.out.println("3. Usar tarjeta");
        System.out.println("4. Mostar Estado");
        System.out.println("5. Comprar casa");
        System.out.println("6. Hipoteca");
    }
    
    public static void propiedad(ColorPropiedad propiedad){
        System.out.println(propiedad.toString());
    }
    
    public static void texto(String texto) {
        System.out.println("\n" + texto);
    }

    public static void salida() {
        System.out.print("\n\tHa salido del sistema");
        for (int i = 1; i <= 3; i++) {
            System.out.print(".");
            try {
                Thread.sleep(1000); 
            } catch(InterruptedException ie) {}
        }
    }

    public static void crearJuador(int n, String[] disponibles) {
        System.out.println("\n\tCreando Jugador " + n);
        System.out.println("\nSeleciona una ficha ");
        for (int i = 0; i < disponibles.length; i++) {
            if (disponibles[i] != null) {
                System.out.println((i + 1) + ". " + disponibles[i]);
            }
        }
        
    }

    public static void colorPropiedad(ArrayList<ColorPropiedad> pHabitables) {
        System.out.println("\nTienes estas propiedades: ");
        for (int i = 0; i < pHabitables.size(); i++) {
            System.out.println(i + ". " + pHabitables.get(i).getNombre());   
        }
    }

    public static void propiedad(ArrayList<Propiedad> pSinCasa) {
        System.out.println("\nTienes estas propiedades: ");
        for (int i = 0; i < pSinCasa.size(); i++) {
            System.out.println(i + ". " + pSinCasa.get(i).getNombre());   
        }
    }

    public static void carta(String description) {
        System.out.println("\nTomastes una tarjeta y dice: ");
        System.out.println(description);
    }
}
