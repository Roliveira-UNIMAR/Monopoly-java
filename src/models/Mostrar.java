/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author RICHARD RIVERA
 */
public class Mostrar {
    
    public static void ReglasBasicas(){
     
        System.out.println("\n\t REGLAS BASICAS DEL JUEGO");
        System.out.println("\t1 a. Comenzando con la Banca, cada jugador lanza los dados. El jugador que logre un seis (6) sale de casilla de inicio.");
        System.out.println("\t2 b. Luego cada jugador inicia su ficha en la esquina marcada «GO», lanza los dados y mueve el número de espacios indicados por los dados.");
        System.out.println("\t3 c. Dos o más fichas pueden estar en el mismo espacio al mismo tiempo.");
        System.out.println("\t4 d. Si lanzas dobles, mueves tu ficha y estás sujeto a cualquier privilegio o penalización relacionada con el espacio en el que aterrices. Luego puedes lanzar de nuevo y mover tu ficha como antes.");
        System.out.println("\t5 e. Si alguna vez lanzas dobles tres veces seguidas, tienes que ir inmediatamente a la cárcel.");  
        System.out.println("\t6 f. Cada vez que la ficha de un jugador aterriza o pasa por encima de la salida, el banquero le paga a ese jugador un salario de 200$.");
        System.out.println("\t7 g. Cuando aterrizas en una propiedad que es de otro jugador, el propietario le cobra el alquiler de acuerdo con la lista impresa en su tarjeta.");
        System.out.println("\t8 h. Al llegar a «Impuestos» simplemente paga lo que se indica.");
        System.out.println("\t9 i. El que es enviado a la carcel no recibe el sueldo de 200$ al llegar a salida.");
        System.out.println("\t10 j. Cuando eres enviado a la carcel puedes pagar 50$ o esperar tres turnos");
        System.out.println("\t11 k. ¡Los jugadores en bancarrota deben retirarse del juego y el último jugador que quede en el juego es el ganador!");
        
    }
    
    public static void ReglasBanco(){ 
        System.out.println("\n\t REGLAS DEL BANQUERO");
        System.out.println("\t1 1. El Banco paga sueldos y bonus. El Banco cobra todos los impuestos, multas, préstamos e intereses y el precio de todas las propiedades que vende y subasta.");
        System.out.println("\t2 2. El Banco no puede quebrar, si el Banco se queda sin dinero, el Banquero puede emitir tanto como sea necesario escribiendo en cualquier papel ordinario."); 
    }
    
    public static void MenuPrincipal(){
     
        System.out.println("\n\t MONOPOLY");
        System.out.println("\t1 1. Iniciar Juego");
        System.out.println("\t2 2. Salir");
    }
    
    public static void error(String msj) {
        System.out.println("\n\tError: " + msj);
    }
    
    public static void menuUsuario(){
        System.out.println("\n\t ELIJA LA OPCION A UTILIZAR");
        System.out.println("\t1 1. Tirar dado (moverse)");
        System.out.println("\t2 2. Dinero total obtenido");
        System.out.println("\t3 3. Comprar casa");
        System.out.println("\t4 4. Hipoteca");
    }
    
    public static void propiedadComprada(String propiedad){
        System.out.println("La propiedad "+propiedad+ " ya ha sido comparada");
    }
    
    public static void propiedadesEnventas(String Propiedades){
        System.out.println("Las propiedades en disponibles son: ");
    }
    
    public static void jugadorEliminado(String ficha){
        System.out.println("El jugador "+ ficha + " se ha quedo sin dinero");
    }
    
    public static void jugadorGanador(String ficha){
        System.out.println("El jugador "+ ficha + " ha ganado la partida");
    }

}
