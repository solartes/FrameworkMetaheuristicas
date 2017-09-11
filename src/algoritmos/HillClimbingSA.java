/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import algoritmo_base.Algoritmo;
import algoritmo_base.Individuo;
import algoritmo_base.Funcion;
import java.util.Random;

/**
 *
 * @author ingesis
 */
public class HillClimbingSA extends Algoritmo {

    Individuo sInd;
    Individuo rInd;
    Individuo wInd;
    int nTweaks;

    public HillClimbingSA(int numIteraciones, int nTweaks, double radInf, double radSup) {
        super(radInf, radSup, numIteraciones);
        this.nTweaks = nTweaks;
    }

    @Override
    public Individuo ejecutar(Funcion funcion, long seed) {
        this.funcion = funcion;
        this.seed = seed;
        r = new Random(seed);
        sInd = new Individuo(this);
        while (numIteraciones>=0) { 
            rInd = sInd.tweak();
            for (int j = 0; j < nTweaks; j++) {
                if(numIteraciones<=0){
                    break;
                }
                wInd = sInd.tweak();
                if (wInd.getEvaluacion() < rInd.getEvaluacion()) {
                    rInd = wInd;
                }
            }
            if (rInd.getEvaluacion() < sInd.getEvaluacion()) {
                sInd = rInd;
            }
        }
        return sInd;
    }

}
