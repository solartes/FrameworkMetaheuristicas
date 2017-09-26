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
public abstract class Algoritmo {

    protected Funcion funcion;
    private final double radInf;
    private final double radSup;
    protected long seed;
    protected int numIteraciones;
    protected Random r;

    /**
     * Metodo abstracto que permitira ejecutar diferentes funciones con
     * diferentes algoritmos
     *
     * @param funcion Funcion a optimizar
     * @param seed Semilla utilizada para la ejecucion
     * @return Individuo ganador
     * 
     */
    public Individuo ejecutar(Funcion funcion, long seed) {
        this.funcion = funcion;
        this.seed = seed;
        return ejecutar();
    }

    public abstract Individuo ejecutar();

    //Constructores, getters, setters
    public Algoritmo(double radInf, double radSup, int numIteraciones) {
        this.radInf = radInf;
        this.radSup = radSup;
        this.numIteraciones = numIteraciones;
    }

    public Algoritmo(int numIteraciones) {
        this.radInf = 0;
        this.radSup = 0;
        this.numIteraciones = numIteraciones;
    }

    public Algoritmo() {
        this.radInf = 0;
        this.radSup = 0;
    }

    public double numAleatorio() {
        return funcion.getRangoMin() + r.nextDouble() * (funcion.getRangoMax() - funcion.getRangoMin());
    }

    public int getNumIteraciones() {
        return numIteraciones;
    }

    public void setNumIteraciones(int numIteraciones) {
        this.numIteraciones = numIteraciones;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public double getRadInf() {
        return radInf;
    }

    public double getRadSup() {
        return radSup;
    }

    public long getSeed() {
        return seed;
    }

    public Random getR() {
        return r;
    }

    public void setR(Random r) {
        this.r = r;
    }

}
