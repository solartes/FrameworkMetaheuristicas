/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosEstadoSimple;

import algoritmo_base.AlgoritmoSimple;
import algoritmo_base.Funcion;
import algoritmo_base.Individuo;
import java.util.Random;

/**
 *
 * @author Julian Esteban Solarte Rivera - Universidad del Cauca
 */
public class RandomSearch extends AlgoritmoSimple {

    Individuo best;
    Individuo sInd;

    public RandomSearch(int numIteraciones) {
        super(numIteraciones);
    }

    @Override
    public Individuo ejecutar() {
        r = new Random(seed);
        best = new Individuo(this);
        while (numIteraciones>0&&funcion.getOptimo() != best.getEvaluacion() && Math.abs(best.getEvaluacion() - funcion.getOptimo()) >= 1 * Math.pow(10, -9)) { 
            sInd = new Individuo(this);
            if (sInd.getEvaluacion() < best.getEvaluacion()) {
                best = sInd;
            }
        }
        return best;
    }

}
