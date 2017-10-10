/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import algoritmo_base.AlgoritmoPoblacional;
import main.*;
import algoritmo_base.Funcion;
import algoritmo_base.Individuo;
import algoritmosPoblacionales.AlgoritmoGenetico;
import funciones.*;
import java.awt.Desktop;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import operadoresCruce.*;
import operadoresMutacion.*;
import operadoresReemplazo.*;
import operadoresSeleccion.*;

/**
 *
 * @author Julian Esteban Solarte Rivera - Universidad del Cauca
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Meter el tamaño de la mochila en el tercer parametro, si no no funciona!!!
        Funcion mochila=new Mochila(0, 1, 10, 295,"./f1.txt");
        AlgoritmoPoblacional genetico=new AlgoritmoGenetico(new Torneo(2), new EmparejamientoRestringido(5),new MultiBit(), new HijosMasPadres(20), new DosPuntos(),20);
        genetico.setNumIteraciones(100000);
        Individuo ganador = genetico.ejecutar(mochila, 0);
        System.out.println("Valor: "+ganador.getEvaluacion());
        System.out.println("Solucion: "+ganador.getRepresentacion().toString());
    }
//    public static void main(String[] args) {
//        long seed = 0;
//        int numIteraciones = 5000;
//        int dimensiones = 10;
//        double optimo=0;
//
//        
//        
//        ArrayList<AlgoritmoSimple> algoritmos = new ArrayList();
//
//        HillClimbing hc = new HillClimbing(numIteraciones, -0.5, 0.5);
//        HillClimbingSA hcsa = new HillClimbingSA(numIteraciones, 5, -0.5, 0.5);
//        HillClimbingSAR hcsar = new HillClimbingSAR(numIteraciones, 5, -0.5, 0.5);
//        BHillClimbing bhc = new BHillClimbing(numIteraciones, 0.6, 0.5);
//        HillClimbingRR hcrr = new HillClimbingRR(numIteraciones, 5, -0.5, 0.5);
//        RandomSearch rs = new RandomSearch(numIteraciones);
//        SimulatedAnnealing sa = new SimulatedAnnealing(numIteraciones, -0.5, 0.5);
//
//        algoritmos.add(bhc);
//        algoritmos.add(hc);
//        algoritmos.add(hcsa);
//        algoritmos.add(hcsar);
//        algoritmos.add(rs);
//        algoritmos.add(hcrr);
//        algoritmos.add(sa);
//
//        ArrayList<Funcion> funciones = new ArrayList();
//
//        Funcion fs = new Sphere(-100, 100, dimensiones,optimo);
//        Funcion step = new Step(-100, 100, dimensiones,optimo);
//        Funcion sch = new Schwefel(-100, 100, dimensiones,optimo);
//        Funcion ras = new Rastrigin(-5.12, 5.12, dimensiones,optimo);
//        Funcion grie = new Griewank(-600, 600, dimensiones,optimo);
//        Funcion ack = new Ackley(-32, 32, dimensiones,optimo);
//
//        funciones.add(step);
//        funciones.add(fs);
//        funciones.add(sch);
//        funciones.add(ras);
//        funciones.add(grie);
//        funciones.add(ack);
//
//        ArrayList<Imprimir> informe = new ArrayList();
//        for (Funcion funcion : funciones) {
//            Imprimir temp = new Imprimir();
//            temp.setFuncion(funcion);
//            for (AlgoritmoSimple algoritmo : algoritmos) {
//                temp.setAlgoritmo(algoritmo);
//                for (int i = 0; i < 30; i++) {
//                    long startTime = System.nanoTime();
//                    temp.getGanadores().add(algoritmo.ejecutar(funcion, seed));
//                    long endTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
//                    temp.getIteraciones().add(algoritmo.getNumIteraciones());
//                    temp.getTiempos().add(endTime);
//                    algoritmo.setNumIteraciones(numIteraciones);
//                    seed++;
//                }
//                informe.add(temp);
//                temp = new Imprimir();
//                temp.setFuncion(funcion);
//
//            }
//
//        }
//
//        generarInforme(informe, algoritmos.size(),numIteraciones);
//    }

    private static void generarInforme(ArrayList<Imprimir> informe, int numAlg, int numIteraciones) {
        String forStr = "%20s ";
        String forInt = "%20d";
        String forDec = "%20.10f ";
        String fin = "\r\n";
        String formato = "%-15s" + forStr + "%10s" + "%15s" + forStr + forStr + forStr + forStr + forStr + fin;
        String formato2 = "%-15s" + forStr + "%10d" + "%15d" + forDec + forDec + forDec + forDec + "%15.3f" + fin;
        String cabecera = String.format(formato, "Funcion", "Algoritmo", "D", "Pro.Ite.", "Mejor Optimo", "Peor Optimo", "Promedio Optimos", "Desviacion Optimos", "Tiempo Promedio");
        String text = cabecera;
        String line = "";
        Path path = Paths.get("./ResultadosFramework.txt");

        try {
            int count = 1;
            for (Imprimir iteracion : informe) {
                line = String.format(formato2, iteracion.getFuncion().getClass().getSimpleName(), iteracion.getAlgoritmo().getClass().getSimpleName(), iteracion.getFuncion().getDimensiones(), iteracion.promedioIteraciones(numIteraciones), iteracion.mejorOptimo(), iteracion.peorOptimo(), iteracion.promedioOptimos(), iteracion.desviacionOptimos(), iteracion.tiempoPromedio());
                text += line;
                if (count == numAlg) {
                    text += "\n";
                    count = 1;
                } else {
                    count++;
                }
            }
            Files.write(path, text.getBytes());
            Desktop desktop = Desktop.getDesktop();
            desktop.open(path.toFile());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
