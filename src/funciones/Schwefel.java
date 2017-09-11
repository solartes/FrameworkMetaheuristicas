/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import algoritmo_base.Funcion;
import algoritmo_base.Individuo;

/**
 *
 * @author Julian Esteban Solarte Rivera - Universidad del Cauca
 */
public class Schwefel extends Funcion {

    public Schwefel(double rangoMin, double rangoMax, int dimensiones) {
        super(rangoMin, rangoMax, dimensiones);
    }



    @Override
    public double evaluarIndividuo(Individuo ind) {
        double sum = 0;
        double dim = 0;        
        for (int i = 0; i < dimensiones; i++) {
            dim += ind.getRepresentacion().get(i);
            sum += Math.pow(dim, 2);            
        }
        return sum;
    }

}
