/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t.archivoaleatorio.web;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author Mario-Bx
 */
public class Prueba {
    
    public static void main(String[] args) throws IOException {
        ////Declaramos un objerto de la clase 
        RandomAccessFile XFAleatorios;
        
        
        String codigo="1234";           ///4 CARACTERES
        String nombre="Mario Rojas";    ///11 CARACTERES
        String edad="29";               ///2 CARACTERES
        String peso="60.55";            ///5 CARACTERES
        String activo="*";              ///1 CARACTERES
        String fol="\r\n";              ///2 CARACTERES
        int longitud =25;               
        int registro;
        
        
            XFAleatorios = new RandomAccessFile("Datos.txt", "rw");
            
            System.out.println("longitud del archivo: "+XFAleatorios.length());
            System.out.println("longitud del registros: "+XFAleatorios.length()/longitud);
            
//            XFAleatorios.seek(XFAleatorios.length());
            
            registro=3;
            XFAleatorios.seek((registro-1)*longitud);
            
            
            
            XFAleatorios.writeBytes(codigo);
            System.out.println(XFAleatorios.getFilePointer()); //Byte actual
            XFAleatorios.writeBytes(nombre);
            System.out.println(XFAleatorios.getFilePointer()); //Byte actual
            XFAleatorios.writeBytes(edad);
            System.out.println(XFAleatorios.getFilePointer()); //Byte actual
            XFAleatorios.writeBytes(peso);
            System.out.println(XFAleatorios.getFilePointer()); //Byte actual
            XFAleatorios.writeBytes(activo);
            System.out.println(XFAleatorios.getFilePointer()); //Byte actual
            XFAleatorios.writeBytes(fol);
            System.out.println(XFAleatorios.getFilePointer()); //Byte actual
            
            XFAleatorios.close();
        
                
    }
           
    
}
