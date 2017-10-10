/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operadoresReemplazo;

import algoritmo_base.Funcion;
import algoritmo_base.Individuo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Julian Esteban Solarte Rivera - Universidad del Cauca
 */
public class HijosMasPadres extends OperadorReemplazo{

    int tamPoblacion;
    public HijosMasPadres(int tam) {
        tamPoblacion=tam;
    }

    
    @Override
    public ArrayList<Individuo> reemplazar(ArrayList<Individuo> poblacion1, ArrayList<Individuo> poblacion2) {
        ArrayList<Individuo> poblacionTotal=new ArrayList<>();
        poblacionTotal.addAll(poblacion1);
        poblacionTotal.addAll(poblacion2);
        Collections.sort(poblacionTotal, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Individuo i2=(Individuo) o2;
                Individuo i1=(Individuo) o1;              
                return new Double(i2.getEvaluacion()).compareTo(i1.getEvaluacion());
                //return new Double(i1.getEvaluacion()).compareTo(i2.getEvaluacion()); MINIMIZAR
            }
        });
        return new ArrayList<>(poblacionTotal.subList(0, tamPoblacion));
    }
    
    
    
}
