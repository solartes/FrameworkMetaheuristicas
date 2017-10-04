/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo_base;

import java.util.Random;

/**
 *
 * @author Julian Esteban Solarte Rivera - Universidad del Cauca
 */
public abstract class Algoritmo {

    protected Random r;
    protected int numIteraciones;
    protected Funcion funcion;
    protected double radInf;
    protected double radSup;
    protected long seed;

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
        this.seed = seed;
        r = new Random(seed);
        this.funcion = funcion;
        return ejecutar();
    }

    public abstract Individuo ejecutar();

    public double numAleatorio() {
        return funcion.getRangoMin() + r.nextDouble() * (funcion.getRangoMax() - funcion.getRangoMin());
    }

    public Random getR() {
        return r;
    }

    public void setR(Random r) {
        this.r = r;
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

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public double getRadInf() {
        return radInf;
    }

    public void setRadInf(double radInf) {
        this.radInf = radInf;
    }

    public double getRadSup() {
        return radSup;
    }

    public void setRadSup(double radSup) {
        this.radSup = radSup;
    }

}
