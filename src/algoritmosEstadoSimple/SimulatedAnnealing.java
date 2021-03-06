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
public class SimulatedAnnealing extends AlgoritmoSimple {

    double t;
    double tInicial;
    int iteraciones;
    Individuo sInd;
    Individuo best;
    Individuo rInd;
    double expTemp;

    public SimulatedAnnealing(int iteraciones, double radInf, double radSup) {
        super(radInf, radSup, iteraciones);
        this.iteraciones = iteraciones;
    }

    @Override
    public Individuo ejecutar() {
        tInicial = 100;
        t = tInicial;
        r = new Random(seed);
        sInd = new Individuo(this);
        best = sInd;
        while (t > 1 * Math.pow(10, -7)&&funcion.getOptimo() != best.getEvaluacion() && Math.abs(best.getEvaluacion() - funcion.getOptimo()) >= 1 * Math.pow(10, -9)) {
            rInd = sInd.tweak();
            expTemp = Math.exp((sInd.getEvaluacion() - rInd.getEvaluacion()) / t);
            if (rInd.getEvaluacion() < sInd.getEvaluacion() || (r.nextDouble() < expTemp)) {
                sInd = rInd;
            }
            disminuirTemp();
            if (sInd.getEvaluacion() < best.getEvaluacion()) {
//                System.out.println("sInd: "+sInd.getEvaluacion());
                best = sInd;
            }
        }
        return best;
    }

    private void disminuirTemp() {
        t = t - (tInicial / iteraciones);
    }

}
