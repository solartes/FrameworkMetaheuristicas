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
 * @author Julian Esteban Solarte Rivera - Universidad del Cauca
 */
public class DosPuntos extends OperadorCruce {

    Random r;

    public DosPuntos() {

    }

    @Override
    public ArrayList<Individuo> cruzar(Individuo ind1, Individuo ind2) {
        r = ind1.getAlgoritmo().getR();
        Individuo copyInd1 = new Individuo(ind1.getAlgoritmo(), new ArrayList<>(ind1.getRepresentacion()));
        Individuo copyInd2 = new Individuo(ind2.getAlgoritmo(), new ArrayList<>(ind2.getRepresentacion()));
        int c=r.nextInt(ind1.getRepresentacion().size());
        int d;
        do{
            d=r.nextInt(ind1.getRepresentacion().size());
        }while(d==c);
        if(c>d){
            int aux=c;
            c=d;
            d=aux;
        }
        double aux;
        for (int i = c; i < d; i++) {
            aux=copyInd1.getRepresentacion().get(i);
            copyInd1.getRepresentacion().set(i, copyInd2.getRepresentacion().get(i));
            copyInd2.getRepresentacion().set(i, aux);
        }
        ArrayList<Individuo> temp=new ArrayList<>();
        temp.add(copyInd1);
        temp.add(copyInd2);
        return temp;
    }

}
