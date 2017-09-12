/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo_base;

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
    protected double optimo;

    /**
     * Metedo que evalua un individuo.
     *
     * @param ind Individuo a evaluar
     * @return Evaluacion del individuo
     */
    public abstract double evaluarIndividuo(Individuo ind);

    //Constructores, getter, setter
    public Funcion(double rangoMin, double rangoMax, int dimensiones, double optimo) {
        this.rangoMin = rangoMin;
        this.rangoMax = rangoMax;
        this.dimensiones = dimensiones;
        this.optimo = optimo;
    }

    public Funcion(double rangoMin, double rangoMax, int dimensiones) {
        this.rangoMin = rangoMin;
        this.rangoMax = rangoMax;
        this.dimensiones = dimensiones;
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

    public double getOptimo() {
        return optimo;
    }

    public void setOptimo(double optimo) {
        this.optimo = optimo;
    }

}
