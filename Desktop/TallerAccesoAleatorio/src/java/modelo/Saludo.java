/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Labing I5
 */
public class Saludo {
    public String saludar(String nombre){
      return "Hola " + nombre;
    }
    
    public ArrayList<String> listar(){
      ArrayList resultado = new 
            ArrayList();
      resultado.add("A");
      resultado.add("B");
      resultado.add("C");
      return resultado;
    }
}
