/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo_base;

import java.util.Random;
import operadoresCruce.OperadorCruce;
import operadoresMutacion.OperadorMutacion;
import operadoresReemplazo.OperadorReemplazo;
import operadoresSeleccion.OperadorSeleccion;

/**
 * Clase abstracta Algoritmo, Atributos
 *
 * Funcion: Funcion que utilizara el algoritmo para la optimizacion radInf:
 * Radio inferior que utiliza el algoritmo para realizar una perturbacion
 * radSup: Radio superior que utiliza el algoritmo para realizar una
 * perturbacion seed: Semilla que utiliza el algoritmo, para garantizar la
 * repetibilidad del experimento numIteraciones: Numero de iteracion que hara el
 * algoritmo, basada en el numero de evaluaciones
 *
 * @author Julian Esteban Solarte Rivera - Universidad del Cauca
 */
public abstract class AlgoritmoPoblacional extends Algoritmo{
    
    protected OperadorSeleccion opSeleccion1;
    protected OperadorSeleccion opSeleccion2;
    protected OperadorMutacion opMutacion;
    protected OperadorReemplazo opReemplazo;
    protected OperadorCruce opCruce;
    protected int numPoblacion;


    //Constructores, getters, setters

    public AlgoritmoPoblacional(OperadorSeleccion opSeleccion1, OperadorSeleccion opSeleccion2, OperadorMutacion opMutacion, OperadorReemplazo opReemplazo, OperadorCruce opCruce, int numPoblacion) {
        this.opSeleccion1 = opSeleccion1;
        this.opSeleccion2 = opSeleccion2;
        this.opMutacion = opMutacion;
        this.opReemplazo = opReemplazo;
        this.opCruce = opCruce;
        this.numPoblacion = numPoblacion;
    }





}
