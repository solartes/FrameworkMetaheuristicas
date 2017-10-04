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
public class EmparejamientoRestringido extends OperadorSeleccion {

    int tamConjunto;
    Random r;

    public EmparejamientoRestringido(int tam) {
        tamConjunto = tam;
    }

    @Override
    public Individuo seleccionar(ArrayList<Individuo> poblacion, Individuo padre) {
        r=poblacion.get(0).getAlgoritmo().getR();
        //Individuo padre = poblacion.get(r.nextInt(poblacion.size()));       
        Individuo get;
        ArrayList<Individuo> conjunto = new ArrayList<>();
        for (int i = 0; i < tamConjunto; i++) {
            do {
                get = poblacion.get(r.nextInt(poblacion.size()));
            } while (conjunto.contains(get)||padre.equals(get));
            conjunto.add(get);            
        }
        return calcularDistancia(padre,conjunto);
        
    }

    private Individuo calcularDistancia(Individuo padre, ArrayList<Individuo> conjunto) {
        int index=-1;
        double max=Double.NEGATIVE_INFINITY;
        double sum=0;
        double dist=0;
        for (int i = 0; i < conjunto.size(); i++) {
            Individuo tmp=conjunto.get(i);
            for (int j = 0; j < padre.getRepresentacion().size(); j++) {
                sum+=Math.pow(padre.getRepresentacion().get(j)-tmp.getRepresentacion().get(j),2);
            }
            dist=Math.sqrt(sum);
            if(dist>max){
                index=i;
                max=dist;
            }
            sum=0;
        }
        return conjunto.get(index);
    }

    @Override
    public Individuo seleccionar(ArrayList<Individuo> poblacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    

}
