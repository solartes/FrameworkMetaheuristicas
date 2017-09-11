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
public class Sphere extends Funcion {

    public Sphere(double rangoMin, double rangoMax, int dimensiones) {
        super(rangoMin, rangoMax, dimensiones);
    }



    @Override
    public double evaluarIndividuo(Individuo ind) {
        double sum = 0;
        for (int i = 0; i < dimensiones; i++) {
            sum += Math.pow(ind.getRepresentacion().get(i), 2);
        }        
        return sum;
    }



   
}
