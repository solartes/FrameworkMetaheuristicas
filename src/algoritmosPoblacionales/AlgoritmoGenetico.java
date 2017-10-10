/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosPoblacionales;

import algoritmo_base.AlgoritmoPoblacional;
import algoritmo_base.AlgoritmoSimple;
import algoritmo_base.Individuo;
import java.util.ArrayList;
import operadoresCruce.OperadorCruce;
import operadoresMutacion.OperadorMutacion;
import operadoresReemplazo.OperadorReemplazo;
import operadoresSeleccion.OperadorSeleccion;

/**
 *
 * @author ingesis
 */
public class AlgoritmoGenetico extends AlgoritmoPoblacional {

    ArrayList<Individuo> poblacion;
    Individuo best;
    Individuo padre;
    Individuo madre;
    ArrayList<Individuo> hijos;
    ArrayList<Individuo> temp;
    

    public AlgoritmoGenetico(OperadorSeleccion opSeleccion1, OperadorSeleccion opSeleccion2, OperadorMutacion opMutacion, OperadorReemplazo opReemplazo, OperadorCruce opCruce,int numPob) {
        super(opSeleccion1, opSeleccion2, opMutacion, opReemplazo, opCruce,numPob);
    }

    @Override
    public Individuo ejecutar() {
        temp=new ArrayList<>();
        inicializarPoblacion();
        while (numIteraciones>=0) {
            best = poblacion.get(0);
            for (int i = 1; i < poblacion.size(); i++) {
                if (best.getEvaluacion() > poblacion.get(i).getEvaluacion()) {
                    best = poblacion.get(i);
                }
            }
            for (int i = 0; i < poblacion.size() / 2; i++) {
                padre = opSeleccion1.seleccionar(poblacion);
                if (opSeleccion2 == null) {
                    madre = opSeleccion1.seleccionar(poblacion);
                }else{                    
                    madre = opSeleccion2.seleccionar(poblacion,padre);
                }
                hijos=opCruce.cruzar(padre,madre);
                hijos=opMutacion.mutar(hijos);
                //HACER UN METODO DE RECOSTRUCCION
                //RECOSTRUCCION(HIJOS)
                //El metodo debe arreglar los hijos que no sirvan(que sobrepasen el peso de la mochila)
                //UNA forma de hacerlo es quitar los objetos con menos densidad(ver diapositivas) e ir metiendo
                //hasta que se arregle
                temp.addAll(hijos);
            }
            poblacion=opReemplazo.reemplazar(poblacion,temp);
            temp=new ArrayList<>();
        }
        return best;
    }

    private void inicializarPoblacion() {
        poblacion=new ArrayList<>();
        for (int i = 0; i < numPoblacion; i++) {
            poblacion.add(new Individuo(this));
        }
    }

}
