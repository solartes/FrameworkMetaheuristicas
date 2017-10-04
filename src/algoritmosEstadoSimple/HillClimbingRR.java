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
public class HillClimbingRR extends AlgoritmoSimple {

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
        while (numIteraciones > 0 && funcion.getOptimo() != best.getEvaluacion() && Math.abs(best.getEvaluacion() - funcion.getOptimo()) >= 1 * Math.pow(10, -9)) {
            for (int j = 0; j < nTweaks; j++) {
                rInd = sInd.tweak();
                if (rInd.getEvaluacion() < sInd.getEvaluacion()) {
                    sInd = rInd;
                }
                if (numIteraciones <= 0) {
                    break;
                }
            }
            if (sInd.getEvaluacion() < best.getEvaluacion()) {
//                System.out.println("sInd:"+sInd.getEvaluacion());
                best = sInd;
            }
            if (numIteraciones <= 0) {
                break;
            }
            sInd = new Individuo(this);
        }
        return best;
    }

}
