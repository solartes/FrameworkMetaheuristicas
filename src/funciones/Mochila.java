/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import algoritmo_base.Funcion;
import algoritmo_base.Individuo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julian Esteban Solarte Rivera - Universidad del Cauca
 */
public class Mochila extends Funcion {
    int tamMochila;
    int numObjetos;
    double[][] objetos;

    public Mochila(double rangoMin, double rangoMax, int dimensiones, double optimo,String archivo) {
        super(rangoMin, rangoMax, dimensiones, optimo);
        cargarArchivo(archivo);
    }

    public void cargarArchivo(String ruta) {
        List<String> lines = new ArrayList();
        try {
            lines = Files.readAllLines(Paths.get(ruta));
        } catch (IOException ex) {
            Logger.getLogger(Mochila.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] split = lines.get(0).split(" ");      
        numObjetos=Integer.parseInt(split[0]);
        tamMochila=Integer.parseInt(split[1]);
        objetos=new double[numObjetos][2];
        for (int i = 1; i < lines.size()-2; i++) {
            String[] split1 = lines.get(i).split(" ");
            objetos[i-1][0]=Double.parseDouble(split1[0]);
            objetos[i-1][1]=Double.parseDouble(split1[1]);;
        }
        
    }

    @Override
    public double evaluarIndividuo(Individuo ind) {
        double valor=0;
        double peso=0;
        for (int i = 0; i < ind.getRepresentacion().size(); i++) {
            ArrayList<Double> representacion = ind.getRepresentacion();
            if(representacion.get(i).equals(1.0)){
                valor+=objetos[i][0];
                peso+=objetos[i][1];
            }
        }
        if(peso>tamMochila){
            return 0.0;
        }else{
            return valor;
        }
    }

}
