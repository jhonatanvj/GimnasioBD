/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Arrays;

/**
 *
 * @author jhona
 */
public class RutinaResistencia extends Rutina {
    
      @Override
     public void addRepeticiones(){
        this.repeticiones=5;
    }
    
     @Override
    public void addSeries(){
        this.series=2;
    }
    
       @Override
       public void aniadirEjercicios(){
        this.ejercicio= Arrays.asList(
        "Carrera en la cinta de correr",
        "Entrenamiento en la elíptica",
        "Circuito de entrenamiento",
        "Entrenamiento con pesas con repeticiones altas"
    );
       }  
}
