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
public class HillClimbingRR extends Algoritmo {

    int nTweaks;
    Individuo sInd;
    Individuo best;
    Individuo rInd;

    public HillClimbingRR(int numIteraciones, int nTweaks, double radInf, double radSup) {
        super(radInf, radSup, numIteraciones);
        this.nTweaks = nTweaks;
    }

    @Override
    public Individuo ejecutar() {
        r = new Random(seed);
        sInd = new Individuo(this);
        best = sInd;
        while (numIteraciones >= 0) {
            for (int j = 0; j < nTweaks; j++) {
                if (numIteraciones <= 0) {                   
                    break;
                }
                rInd = sInd.tweak();
                if (rInd.getEvaluacion() < sInd.getEvaluacion()) {
                    sInd = rInd;
                }
            }
            if (sInd.getEvaluacion() < best.getEvaluacion()) {
                best = sInd;
            }
            sInd = new Individuo(this);
        }
        return best;
    }

}
