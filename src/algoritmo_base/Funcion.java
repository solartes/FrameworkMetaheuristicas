/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo_base;

import java.util.ArrayList;

/**
 * Clase abstracta Funcion, Atributos
 *
 * rangoMin: Rango minimo en la cual esta definida la funcion. rangoMax: Rango
 * maximo en la cual esta definida la funcion. dimensiones: Numero de
 * dimensiones que tendra la funcion.
 *
 * @author Julian Esteban Solarte Rivera - Universidad del Cauca
 */
public abstract class Funcion {

    protected double rangoMin;
    protected double rangoMax;
    protected int dimensiones;
    protected ArrayList<Double> optimo;

    /**
     * Metedo que evalua un individuo.
     *
     * @param ind Individuo a evaluar
     * @return Evaluacion del individuo
     */
    public abstract double evaluarIndividuo(Individuo ind);

    //Constructores, getter, setter
    public Funcion(double rangoMin, double rangoMax, int dimensiones, ArrayList<Double> optimo) {
        this.rangoMin = rangoMin;
        this.rangoMax = rangoMax;
        this.dimensiones = dimensiones;
        this.optimo = optimo;
    }

    public int getDimensiones() {
        return dimensiones;
    }

    public double getRangoMin() {
        return rangoMin;
    }

    public double getRangoMax() {
        return rangoMax;
    }

    public ArrayList<Double> getOptimo() {
        return optimo;
    }

    public void setOptimo(ArrayList<Double> optimo) {
        this.optimo = optimo;
    }



}
