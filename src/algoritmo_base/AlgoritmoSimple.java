/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo_base;

import java.util.Random;

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
public abstract class AlgoritmoSimple extends Algoritmo{

    //Constructores, getters, setters
    public AlgoritmoSimple(double radInf, double radSup, int numIteraciones) {
        this.radInf = radInf;
        this.radSup = radSup;
        this.numIteraciones = numIteraciones;
    }

    public AlgoritmoSimple(int numIteraciones) {
        this.radInf = 0;
        this.radSup = 0;
        this.numIteraciones = numIteraciones;
    }

    public AlgoritmoSimple() {
        this.radInf = 0;
        this.radSup = 0;
    }




}
