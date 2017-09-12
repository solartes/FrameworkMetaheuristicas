/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import algoritmo_base.Algoritmo;
import algoritmo_base.Funcion;
import algoritmo_base.Individuo;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Julian Esteban Solarte Rivera - Universidad del Cauca
 */
public class BHillClimbing extends Algoritmo {

    double bandWidth;
    double beta;
    Individuo ind;
    Individuo mutInd;

    public BHillClimbing(int numIteraciones,double bandWidth, double beta) {
        this.bandWidth = bandWidth;
        this.beta = beta;
        this.numIteraciones = numIteraciones;
    }

    @Override
    public Individuo ejecutar(Funcion funcion, long seed) {
        this.funcion = funcion;
        this.seed = seed;
        r = new Random(seed);
        ind = new Individuo(this);
        for (int i = 0; i < numIteraciones; i++) {
            mutInd = nOpe(ind);
            for (int j = 0; j < funcion.getDimensiones(); j++) {
                if (r.nextDouble() < beta) {
                    mutInd.getRepresentacion().set(j, numAleatorio());
                }
            }
            mutInd.setEvaluacion(funcion.evaluarIndividuo(mutInd));
            numIteraciones = numIteraciones - 1;
            if (mutInd.getEvaluacion() < ind.getEvaluacion()) {
                ind = mutInd;
            }
        }
        return ind;
    }

    private Individuo nOpe(Individuo ind) {
        Individuo copia = new Individuo(this, (ArrayList<Double>) ind.getRepresentacion().clone());
        int posAl = (int) (0 + r.nextDouble() * (funcion.getDimensiones() - 0));
        double gen = ind.getRepresentacion().get(posAl);
        double perturbacion = 0;
        do {
            perturbacion = gen + (r.nextDouble() * bandWidth);
        } while (perturbacion > funcion.getRangoMax() || perturbacion < funcion.getRangoMin());
        copia.getRepresentacion().set(posAl, perturbacion);
        copia.setEvaluacion(funcion.evaluarIndividuo(copia));
        numIteraciones = numIteraciones - 1;
        return copia;
    }


}
