/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import algoritmo_base.Algoritmo;
import algoritmo_base.Funcion;
import algoritmos.*;
import funciones.*;
import java.awt.Desktop;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julian Esteban Solarte Rivera - Universidad del Cauca
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long seed = 0;
        int numIteraciones = 5000;
        int dimensiones = 10;

        ArrayList<Algoritmo> algoritmos = new ArrayList();

        HillClimbing hc = new HillClimbing(numIteraciones, -0.5, 0.5);
        HillClimbingSA hcsa = new HillClimbingSA(numIteraciones, 20, -0.5, 0.5);
        HillClimbingSAR hcsar = new HillClimbingSAR(numIteraciones, 20, -0.5, 0.5);
        BHillClimbing bhc = new BHillClimbing(numIteraciones, 0.6, 0.5);
        HillClimbingRR hcrr = new HillClimbingRR(numIteraciones, 20, -0.5, 0.5);
        RandomSearch rs = new RandomSearch(numIteraciones);
        SimulatedAnnealing sa = new SimulatedAnnealing(numIteraciones, -0.5, 0.5);

        algoritmos.add(hc);
        algoritmos.add(hcsa);
        algoritmos.add(hcsar);
        algoritmos.add(bhc);
        algoritmos.add(hcrr);
        algoritmos.add(rs);
        algoritmos.add(sa);

        ArrayList<Funcion> funciones = new ArrayList();

        Funcion fs = new Sphere(-100, 100, dimensiones);
        Funcion step = new Step(-100, 100, dimensiones);
        Funcion sch = new Schwefel(-100, 100, dimensiones);
        Funcion ras = new Rastrigin(-5.12, 5.12, dimensiones);
        Funcion grie = new Griewank(-600, 600, dimensiones);
        Funcion ack = new Ackley(-32, 32, dimensiones);

        funciones.add(fs);
        funciones.add(step);
        funciones.add(sch);
        funciones.add(ras);
        funciones.add(grie);
        funciones.add(ack);

        ArrayList<Imprimir> informe = new ArrayList();
        for (Funcion funcion : funciones) {
            Imprimir temp = new Imprimir();
            temp.setFuncion(funcion);
            for (Algoritmo algoritmo : algoritmos) {
                temp.setAlgoritmo(algoritmo);
                for (int i = 0; i < 30; i++) {
                    long startTime = System.nanoTime();
                    temp.getGanadores().add(algoritmo.ejecutar(funcion, seed));
                    long endTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
                    temp.getTiempos().add(endTime);
                    algoritmo.setNumIteraciones(numIteraciones);
                    seed++;
                }
                informe.add(temp);
                temp = new Imprimir();
                temp.setFuncion(funcion);

            }

        }

        generarInforme(informe);
    }

    private static void generarInforme(ArrayList<Imprimir> informe) {
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
            for (Imprimir iteracion : informe) {
                line = String.format(formato2, iteracion.getFuncion().getClass().getSimpleName(), iteracion.getAlgoritmo().getClass().getSimpleName(), iteracion.getFuncion().getDimensiones(), iteracion.promedioIteraciones(), iteracion.mejorOptimo(), iteracion.peorOptimo(), iteracion.promedioOptimos(), iteracion.desviacionOptimos(), iteracion.tiempoPromedio());
                text += line;
            }
            Files.write(path, text.getBytes());
            Desktop desktop = Desktop.getDesktop();
            desktop.open(path.toFile());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
