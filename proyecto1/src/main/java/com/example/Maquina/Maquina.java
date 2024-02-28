package com.example.Maquina;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


import com.example.Nodo.Nodo;
import com.example.Transicion.Transicion;

public class Maquina {
    private List<BigInteger> fiboList;
    public List<Transicion> transiciones;
    public List<Nodo> nodos;
    private int n;

    public Maquina(int n) {
        this.n = n;
        this.fiboList = new ArrayList<>();
        this.transiciones = new ArrayList<>();
        this.nodos = new ArrayList<>();
        this.fiboList.add(BigInteger.ZERO);
        this.fiboList.add(BigInteger.ONE);
        // Inicializa los primeros nodos
        Nodo nodo0 = new Nodo("0");
        Nodo nodo1 = new Nodo("1");
        nodos.add(nodo0);
        nodos.add(nodo1);
        // No hay transición inicial entre 0 y 1, pues son valores base
        
        fibo(n);

        // Grafico.multiGraph = new MultiGraph("Fibo");
    }

    private void fibo(int n) {
        System.out.printf("Estado: %s, Posición Cabeza: %d, Elementos de la Cinta: %s\n", 0, 1, "["+fiboList.get(0)+"]");
        for (int i = fiboList.size(); i <= n; i++) {
            confiSim(i);
            BigInteger nValue = fiboList.get(i - 1).add(fiboList.get(i - 2));
            fiboList.add(nValue);

            Nodo nuevoNodo = new Nodo(nValue.toString());
            nodos.add(nuevoNodo);

            Transicion transicion1 = new Transicion(nodos.get(i - 2), nValue.toString(), nuevoNodo);
            Transicion transicion2 = new Transicion(nodos.get(i - 1), nValue.toString(), nuevoNodo);
            transiciones.add(transicion1);
            transiciones.add(transicion2);
        }
    }

    public void result() {
        System.out.println("\nEl resultado es: " + fiboList.get(n) + "\n");
    }

    public void txtSaver() {
        try {
            PrintWriter writer = new PrintWriter("trianguloFibonacci.txt");
            int fiboNum = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i && fiboNum <= n; j++) {
                    writer.print(fiboList.get(fiboNum++) + " ");
                }
                writer.println(); // Esto escribe un salto de línea en el archivo
            }
            writer.close(); // Es importante cerrar el archivo al final para asegurarse de que todo se guarde correctamente
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear o escribir en el archivo: " + e.getMessage());
        }
    }

    private void confiSim(int ind) {
        int indice = ind-1;
        // if (indice < 2) return; // No hay necesidad de mostrar configuración para los dos primeros números base
    
        // El estado actual sería el último Nodo añadido
        Nodo estadoActual = nodos.get(indice);
        // La posición de la cabeza puede interpretarse como el índice actual en la lista de nodos
        int posicionCabeza = indice;
        // Los elementos de la cinta serían los valores de los Nodos hasta el momento
        String elementosCinta = fiboList.subList(0, indice + 1).toString();
    
        System.out.printf("Estado: %s, Posición Cabeza: %d, Elementos de la Cinta: %s\n", 
                          estadoActual.getID(), ++posicionCabeza, elementosCinta);
    }
    
    
}
