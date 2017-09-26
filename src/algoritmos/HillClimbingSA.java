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
    public Individuo ejecutar() {
        r = new Random(seed);
        sInd = new Individuo(this);
        while (numIteraciones > 0 && funcion.getOptimo() != sInd.getEvaluacion() && Math.abs(sInd.getEvaluacion() - funcion.getOptimo()) >= 1 * Math.pow(10, -9)) {
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
            if (rInd.getEvaluacion() < sInd.getEvaluacion()) {
                sInd = rInd;
            }
        }
        //Se agrega esta parte para que den unos resultados perfectos, ya que 
        //la evaluacion de el individuo da 1*10^-16, y los resultados son muy
        //aproximados a un numero, por ejemplo 1.999999999999999999 o -5.0*10^17
 
        //Simplemente se redondea al valor mas cercano
        
        if (sInd.getEvaluacion()<1*Math.pow(10, -15)) {
            for (int i = 0; i < sInd.getRepresentacion().size(); i++) {
                sInd.getRepresentacion().set(i, (double) Math.round(sInd.getRepresentacion().get(i) * 10d) / 10d);
            }
        }
        return sInd;
    }

}
