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
 * @author ingesis
 */
public abstract class OperadorSeleccion {
    public abstract Individuo seleccionar(ArrayList<Individuo> poblacion);
    public abstract Individuo seleccionar(ArrayList<Individuo> poblacion,Individuo padre);
}
