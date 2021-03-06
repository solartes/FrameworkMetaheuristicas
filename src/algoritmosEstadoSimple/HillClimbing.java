/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosEstadoSimple;

import algoritmo_base.AlgoritmoSimple;
import algoritmo_base.Individuo;
import algoritmo_base.Funcion;
import java.util.Random;

/**
 *
 * @author ingesis
 */
public class HillClimbing extends AlgoritmoSimple {

    Individuo sInd;
    Individuo rInd;

    public HillClimbing(int numIteraciones, double radInf, double radSup) {
        super(radInf, radSup, numIteraciones);
    }

    @Override
    public Individuo ejecutar() {
        r = new Random(seed);
        sInd = new Individuo(this);
        while (numIteraciones > 0&&funcion.getOptimo() != sInd.getEvaluacion() && Math.abs(sInd.getEvaluacion() - funcion.getOptimo()) >= 1 * Math.pow(10, -9)) {
            rInd = sInd.tweak();
            if (rInd.getEvaluacion() < sInd.getEvaluacion()) {
                //System.out.println("r Ind:"+rInd.getEvaluacion());
                sInd = rInd;
            }
        }
        return sInd;
    }

}
