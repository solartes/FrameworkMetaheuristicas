/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosEstadoSimple;

import algoritmo_base.AlgoritmoSimple;
import algoritmo_base.Individuo;
import algoritmo_base.Funcion;
import funciones.Sphere;
import java.util.Random;

/**
 *
 * @author Julian Esteban Solarte Rivera - Universidad del Cauca
 */
public class HillClimbingSAR extends AlgoritmoSimple {

    Individuo sInd;
    Individuo mejorInd;
    Individuo rInd;
    Individuo wInd;
    int nTweaks;

    public HillClimbingSAR(int numIteraciones, int nTweaks, double radMin, double radMax) {
        super(radMin, radMax, numIteraciones);
        this.nTweaks = nTweaks;
    }

    @Override
    public Individuo ejecutar() {
        r = new Random(seed);
        sInd = new Individuo(this);
        mejorInd = sInd;
        while (numIteraciones > 0&&funcion.getOptimo() != mejorInd.getEvaluacion() && Math.abs(mejorInd.getEvaluacion() - funcion.getOptimo()) >= 1 * Math.pow(10, -9)) {
            rInd = sInd.tweak();
            for (int j = 0; j < nTweaks; j++) {
                if (numIteraciones <= 0) {
                    break;
                }
                wInd = sInd.tweak();
                if (wInd.getEvaluacion() < rInd.getEvaluacion()) {
                    rInd = wInd;
                }
            }
            sInd = rInd;
            if (sInd.getEvaluacion() < mejorInd.getEvaluacion()) {
                mejorInd = sInd;
            }

        }
        return mejorInd;
    }

}
