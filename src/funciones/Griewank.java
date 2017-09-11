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
public class Griewank extends Funcion{

    public Griewank(double rangoMin, double rangoMax, int dimensiones) {
        super(rangoMin, rangoMax, dimensiones);
    }



    @Override
    public double evaluarIndividuo(Individuo ind) {
        double cons=1/4000.0;
        double partA=0;
        double sum=0;
        double mul=1;
        for (int i = 0; i < dimensiones; i++) {
            sum+=Math.pow(ind.getRepresentacion().get(i), 2);
            mul*=Math.cos((ind.getRepresentacion().get(i)/Math.sqrt(i+1)));
        }
        return (cons*sum)-mul+1;
    }
    
}
