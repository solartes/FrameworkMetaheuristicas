/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import algoritmo_base.Algoritmo;
import algoritmo_base.Funcion;
import algoritmo_base.Individuo;
import java.util.ArrayList;

/**
 *
 * @author Julian Esteban Solarte Rivera - Universidad del Cauca
 */
public class Imprimir {

    Algoritmo algoritmo;
    Funcion funcion;
    ArrayList<Individuo> ganadores;
    ArrayList<Long> tiempos;
    ArrayList<Integer> iteraciones;
    int mejorPos;

    public Imprimir(Algoritmo algoritmo, Funcion funcion, ArrayList<Individuo> ganadores, ArrayList<Integer> iteraciones) {
        this.algoritmo = algoritmo;
        this.funcion = funcion;
        this.ganadores = ganadores;
        this.iteraciones = iteraciones;
        mejorPos=0;
    }

    public Imprimir() {
        ganadores = new ArrayList();
        tiempos = new ArrayList();
        iteraciones = new ArrayList();
        funcion = null;
        algoritmo = null;
    }

    public Algoritmo getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(Algoritmo algoritmo) {
        this.algoritmo = algoritmo;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public ArrayList<Individuo> getGanadores() {
        return ganadores;
    }

    public void setGanadores(ArrayList<Individuo> ganadores) {
        this.ganadores = ganadores;
    }

    public ArrayList<Long> getTiempos() {
        return tiempos;
    }

    public void setTiempos(ArrayList<Long> tiempos) {
        this.tiempos = tiempos;
    }

    public ArrayList<Integer> getIteraciones() {
        return iteraciones;
    }

    public void setIteraciones(ArrayList<Integer> iteraciones) {
        this.iteraciones = iteraciones;
    }

    public double mejorOptimo() {
        double mejor = ganadores.get(0).getEvaluacion();
        for (int i = 1; i < ganadores.size(); i++) {
            if (mejor > ganadores.get(i).getEvaluacion()) {
                mejorPos=i;
                mejor = ganadores.get(i).getEvaluacion();
            }
        }
        return mejor;
    }

    public double promedioOptimos() {
        double prom = 0;
        for (int i = 0; i < ganadores.size(); i++) {
            prom += ganadores.get(i).getEvaluacion();
        }
        prom = prom / ganadores.size();
        return prom;
    }

    public double peorOptimo() {
        double peor = ganadores.get(0).getEvaluacion();
        for (int i = 1; i < ganadores.size(); i++) {
            if (peor < ganadores.get(i).getEvaluacion()) {
                peor = ganadores.get(i).getEvaluacion();
            }
        }
        return peor;
    }

    public int promedioIteraciones(int total) {
        int sum = 0;
        int it = 0;

        for (Integer ganador : iteraciones) {
            it = Math.abs(ganador - total);
            sum += it;
        }

        return sum / ganadores.size();
    }

    public double desviacionOptimos() {
        double promedio = promedioOptimos();
        double sum = 0;
        for (Individuo ganador : ganadores) {
            sum += Math.pow(ganador.getEvaluacion() - promedio, 2);
        }
        return sum / (ganadores.size() - 1);
    }

    public double tiempoPromedio() {
        long sum = 0;
        for (long tiempo : tiempos) {
            sum += tiempo;
        }
        double promedio = sum / tiempos.size();
        return promedio / 1000;
    }
    
    public String imprimirMejorIndividuo(){
        String linea=""+ganadores.get(mejorPos).getRepresentacion().get(0);
        for (int i = 1; i < ganadores.get(mejorPos).getRepresentacion().size(); i++) {
            ArrayList<Double> representacion = ganadores.get(mejorPos).getRepresentacion();
            linea+=";;"+representacion.get(i);
        }
        return linea;
    }

}
