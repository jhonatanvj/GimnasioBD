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
public class RutinaAumento extends Rutina{
    
    
     @Override
     public void addRepeticiones(){
        this.repeticiones=7;
    }
    
     @Override
    public void addSeries(){
        this.series=2;
    }
    
       @Override
       public void aniadirEjercicios(){
        this.ejercicio= Arrays.asList(
        "Sentadillas",
        "Press de banca",
        "Peso muerto",
        "Dominadas",
        "Press militar",
        "Remo con barra"
    );
    }
    
}
