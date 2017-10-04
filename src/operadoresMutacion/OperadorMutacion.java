/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operadoresMutacion;

import algoritmo_base.Individuo;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ingesis
 */
public abstract class OperadorMutacion {

    public abstract ArrayList<Individuo> mutar(ArrayList<Individuo> poblacion);
}
