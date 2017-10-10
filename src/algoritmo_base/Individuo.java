/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo_base;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Julian Esteban Solarte Rivera - Universidad del Cauca
 */
public class Individuo {

    private double evaluacion;
    private ArrayList<Double> representacion;
    private final Algoritmo algoritmo;

    public Individuo(Algoritmo algoritmo) {
        this.algoritmo = algoritmo;
        representacion = new ArrayList();
        iniciarIndividuo(algoritmo.getFuncion());
    }

    public Individuo(Algoritmo algoritmo, ArrayList<Double> representacion) {
        this.algoritmo = algoritmo;
        this.representacion = representacion;
    }

    public Individuo() {
        evaluacion=0;
        representacion=new ArrayList();
        algoritmo=null;
    }

    public Individuo tweak() {
        Random r = algoritmo.getR();
        Funcion funcion = algoritmo.getFuncion();
        Individuo copia = new Individuo(algoritmo, new ArrayList<>());
        double diff = 0;
        for (int i = 0; i < funcion.getDimensiones(); i++) {
            do {
                diff = algoritmo.getRadInf() + r.nextDouble() * (algoritmo.getRadSup() - algoritmo.getRadInf());
            } while (representacion.get(i) + diff > funcion.getRangoMax() || representacion.get(i) + diff < funcion.getRangoMin());
            copia.getRepresentacion().add(representacion.get(i) + diff);
        }
        copia.setEvaluacion(funcion.evaluarIndividuo(copia));
        algoritmo.setNumIteraciones(algoritmo.getNumIteraciones() - 1);
        return copia;
    }

    private void iniciarIndividuo(Funcion funcion) {
        Random r = algoritmo.getR();
        for (int i = 0; i < funcion.getDimensiones(); i++) {
//            NOBINARIO
//            double ale = funcion.getRangoMin() + r.nextDouble() * (funcion.getRangoMax() - funcion.getRangoMin());
//            representacion.add(ale);
              representacion.add((double)r.nextInt(2));

        }
        evaluacion = funcion.evaluarIndividuo(this);
        algoritmo.setNumIteraciones(algoritmo.getNumIteraciones() - 1);
    }

    public ArrayList<Double> getRepresentacion() {
        return representacion;
    }

    public void setRepresentacion(ArrayList<Double> representacion) {
        this.representacion = representacion;
    }

    public double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public Algoritmo getAlgoritmo() {
        return algoritmo;
    }
    
    

}
