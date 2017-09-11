/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import algoritmo_base.Algoritmo;
import algoritmo_base.Funcion;
import algoritmo_base.Individuo;
import java.util.Random;

/**
 *
 * @author Julian Esteban Solarte Rivera - Universidad del Cauca
 */
public class RandomSearch extends Algoritmo {

    Individuo best;
    Individuo sInd;

    public RandomSearch(int numIteraciones) {
        super(numIteraciones);
    }

    @Override
    public Individuo ejecutar(Funcion funcion, long seed) {
        this.funcion = funcion;
        this.seed = seed;
        r = new Random(seed);
        best = new Individuo(this);
        while (numIteraciones!=0) { 
            sInd = new Individuo(this);
            if (sInd.getEvaluacion() < best.getEvaluacion()) {
                best = sInd;
            }
        }
        return best;
    }

}
