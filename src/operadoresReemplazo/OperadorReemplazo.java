/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operadoresReemplazo;

import algoritmo_base.Individuo;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ingesis
 */
public abstract class OperadorReemplazo {

    public abstract ArrayList<Individuo> reemplazar(ArrayList<Individuo> poblacion1, ArrayList<Individuo> poblacion2);
}
