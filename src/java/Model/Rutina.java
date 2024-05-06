/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import java.util.Random;

/**
 *
 * @author jhona
 */
public class Rutina {
    List<String> ejercicio;
    int repeticiones;
    int series;
    
    
    public String getEjercicioAleatorio(Random rand) {
        if (ejercicio != null && !ejercicio.isEmpty()) {
            int index = rand.nextInt(ejercicio.size());
            return ejercicio.get(index);
        } else {
            return "No hay ejercicios disponibles";
        }
    }
    
    public void aniadirEjercicios(){
        this.ejercicio= null ;
    }
    
    public void addRepeticiones(){
        this.repeticiones=0;
    }
    
    public void addSeries(){
        this.series=0;
    }



    public List<String> getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(List<String> ejercicio) {
        this.ejercicio = ejercicio;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }   
    
           
}
