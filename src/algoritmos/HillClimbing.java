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
public class HillClimbing extends Algoritmo{

    Individuo sInd;
    Individuo rInd;
    

    public HillClimbing(int numIteraciones, double radInf,double radSup) {
        super(radInf, radSup, numIteraciones);         
    }

    @Override
    public Individuo ejecutar() {
        r = new Random(seed);
        sInd = new Individuo(this);
        while (numIteraciones!=0) {        
            rInd = sInd.tweak();
            if (rInd.getEvaluacion() < sInd.getEvaluacion()) {
                sInd = rInd;
            }
        }        
        return sInd;
    }  

    
}
