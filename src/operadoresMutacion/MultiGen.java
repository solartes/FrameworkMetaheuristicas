/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operadoresMutacion;

import algoritmo_base.Funcion;
import algoritmo_base.Individuo;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Julian Esteban Solarte Rivera - Universidad del Cauca
 */
public class MultiGen extends OperadorMutacion {

    Random r;

    public MultiGen() {
    }

    @Override
    public ArrayList<Individuo> mutar(ArrayList<Individuo> poblacion) {
        r = poblacion.get(0).getAlgoritmo().getR();
        Funcion funcion = poblacion.get(0).getAlgoritmo().getFuncion();
        for (int i = 0; i < poblacion.size(); i++) {
            ArrayList<Double> representacion = poblacion.get(i).getRepresentacion();
            for (int j = 0; j < representacion.size(); j++) {
                if (r.nextDouble() < 0.05) {
                    // Para variar media y desviacion..x = standardDeviation * num + mean;
                    double valor = funcion.getRangoMin() + r.nextGaussian() * (funcion.getRangoMax() - funcion.getRangoMin());
                    representacion.set(j, valor);
                }
            }
            poblacion.get(i).setEvaluacion(funcion.evaluarIndividuo(poblacion.get(i))); 
            poblacion.get(i).getAlgoritmo().setNumIteraciones(poblacion.get(i).getAlgoritmo().getNumIteraciones() - 1);
        }
        return poblacion;
    }

}
