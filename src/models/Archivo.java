/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author RICHARD RIVERA
 */
public class Archivo {
    
    
    //Se leera el txt con los datos de las propiedades (Casas, hoteles, etc...)
    public static String ColorPropiedades()throws FileNotFoundException{
        
           File ref = new File ("Propiedades.txt");
           Scanner leer = new Scanner (ref);
               while (leer.hasNextLine()){
                    System.out.println(leer.nextLine());
               }
        return ColorPropiedad;
    
    }
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    

