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
        System.out.println("\t1 1. Comenzando con la Banca, cada jugador lanza los dados. El jugador que logre un seis (6) sale de casilla de inicio.");
        System.out.println("\t2 2. Luego cada jugador coloca su ficha en la esquina marcada «Casilla de Salida», lanza los dados y mueve el número de espacios indicados por los dados.");
        System.out.println("\t3 3. Dos o más fichas pueden estar en el mismo espacio al mismo tiempo.");
        System.out.println("\t4 4. Si lanzas dobles, mueves tu ficha y estás sujeto a cualquier privilegio o penalización relacionada con el espacio en el que aterrices. Luego puedes lanzar de nuevo y mover tu ficha como antes.");
        System.out.println("\t5 5. Si alguna vez lanzas dobles tres veces seguidas, tienes que ir inmediatamente a la cárcel.");  
        System.out.println("\t6 6. Cada vez que la ficha de un jugador aterriza o pasa por encima de la salida, el banquero le paga a ese jugador un salario de 200$.");
        System.out.println("\t7 7. Cuando aterrizas en una propiedad que es de otro jugador, el propietario le cobra el alquiler de acuerdo con la lista impresa en su tarjeta.");
        System.out.println("\t8 8. Al llegar a «Impuestos» simplemente paga lo que se indica.");
        System.out.println("\t9 9. El que es enviado a la carcel no recibe el sueldo de 200$ al llegar a salida.");
        System.out.println("\t10 10. Cuando eres enviado a la carcel puedes pagar 50$ o esperar tres turnos");
        System.out.println("\t11 11. ¡Los jugadores en bancarrota deben retirarse del juego y el último jugador que quede en el juego es el ganador!");
        
    }
    
    public static void ReglasBanco(){ 
        System.out.println("\n\t REGLAS DEL BANQUERO");
        System.out.println("\t1 1. El Banco paga sueldos y bonus. El Banco cobra todos los impuestos, multas, préstamos e intereses y el precio de todas las propiedades que vende y subasta.");
        System.out.println("\t2 2. El Banco no puede quebrar, si el Banco se queda sin dinero, el Banquero puede emitir tanto como sea necesario escribiendo en cualquier papel ordinario."); 
    }
    
    public static void MenuPrincipal(){
     
        System.out.println("\n\t REGLAS BASICAS DEL JUEGO");
        System.out.println("\t1 1. ");
        System.out.println("\t2 2. ");
        System.out.println("\t3 3. ");
        System.out.println("\t4 4. ");
        System.out.println("\t5 5. ");  
    }
    
    public static void error(String msj) {
        System.out.println("\n\tError: " + msj);
    }

}
