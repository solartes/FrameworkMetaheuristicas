/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import algoritmo_base.Funcion;
import algoritmo_base.Individuo;
import java.util.ArrayList;

/**
 *
 * @author Julian Esteban Solarte Rivera - Universidad del Cauca
 */
public class Step extends Funcion{

    public Step(double rangoMin, double rangoMax, int dimensiones, double optimo) {
        super(rangoMin, rangoMax, dimensiones, optimo);
    }

    
    @Override
    public double evaluarIndividuo(Individuo ind) {
        double sum=0;
        for (int i = 0; i < dimensiones; i++) {
            sum+=Math.pow(Math.floor(ind.getRepresentacion().get(i)+0.5),2);
        }
        return sum;
    }

    
}
