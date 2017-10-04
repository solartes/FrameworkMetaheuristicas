/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operadoresCruce;

import algoritmo_base.Individuo;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ingesis
 */
public abstract class OperadorCruce {

    public abstract ArrayList<Individuo> cruzar(Individuo ind1, Individuo ind2);
}
