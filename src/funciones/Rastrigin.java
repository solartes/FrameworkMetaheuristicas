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
public class Rastrigin extends Funcion{

    public Rastrigin(double rangoMin, double rangoMax, int dimensiones, double optimo) {
        super(rangoMin, rangoMax, dimensiones, optimo);
    }


    @Override
    public double evaluarIndividuo(Individuo ind) {
        double sum=0;
        for (int i = 0; i < dimensiones; i++) {
            sum+=Math.pow(ind.getRepresentacion().get(i),2)-(10*Math.cos(2*Math.PI*ind.getRepresentacion().get(i)))+10;
        }
        return sum;
    }
    
}
