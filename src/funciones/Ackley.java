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
public class Ackley extends Funcion{

    public Ackley(double rangoMin, double rangoMax, int dimensiones, ArrayList<Double> optimo) {
        super(rangoMin, rangoMax, dimensiones, optimo);
    }





    @Override
    public double evaluarIndividuo(Individuo ind) {
        double sum2=0;
        double sum1=0;
        
        for (int i = 0; i < dimensiones; i++) {
            sum1+=Math.pow(ind.getRepresentacion().get(i), 2);
            sum2+=Math.cos(2*Math.PI*ind.getRepresentacion().get(i));
        }
        double dim=dimensiones;
        double partA=-20 * Math.exp(-0.2 * Math.sqrt((1 / dim) * sum1));
        double partB=Math.exp((1/dim)*sum2);
        return partA-partB+20+Math.exp(1);
    }
    
}
