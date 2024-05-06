package Model;

import java.util.Arrays;

public class RutinaFuerza extends Rutina {
     @Override
     public void addRepeticiones(){
        this.repeticiones=15;
    }
    
     @Override
    public void addSeries(){
        this.series=1;
    }
    
       @Override
       public void aniadirEjercicios(){
        this.ejercicio= Arrays.asList(
        "Press de pierna",
        "Fondos en paralelas",
        "Peso muerto",
        "Press de hombros con mancuernas",
        "Curl de bíceps con barra",
        "Sentadillas"
    );
    }



    
}

