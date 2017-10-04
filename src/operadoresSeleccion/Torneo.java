/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operadoresSeleccion;

import algoritmo_base.Individuo;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Julian Esteban Solarte Rivera - Universidad del Cauca
 */
public class Torneo extends OperadorSeleccion {

    int tamTorneo;
    Random r;

    public Torneo(int tamTorneo) {
        this.tamTorneo = tamTorneo;
    }

    @Override
    public Individuo seleccionar(ArrayList<Individuo> poblacion) {
        r=poblacion.get(0).getAlgoritmo().getR();
        Individuo next;
        Individuo best = poblacion.get(r.nextInt(poblacion.size()));
        for (int i = 1; i < tamTorneo; i++) {
            next = new Individuo();
            do {
                next = poblacion.get(r.nextInt(poblacion.size()));
            } while (next.equals(best));
            if (next.getEvaluacion() > best.getEvaluacion()) {
                best = next;
            }
        }
        return best;
    }

    @Override
    public Individuo seleccionar(ArrayList<Individuo> poblacion, Individuo padre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
