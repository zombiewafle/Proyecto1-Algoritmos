package com.example.Maquina;

import java.util.LinkedList;
import java.util.Queue;
import com.example.Celda.Celda;
import com.example.Cinta.Cinta;

public class Maquina {
    public Cinta cinta;
    public String estado;
    public Celda raiz;

    public Maquina() {
        this.cinta = new Cinta();
        this.estado = "inicial";
        this.raiz = null;
    }

    public void construirArbol(int n) {
        raiz = FiboAlg(n);
    }

    public Celda FiboAlg(Integer n) {
        if (n <= 1) {
            return new Celda(n);
        }
        Celda nodo = new Celda(0); // Suponiendo que Celda maneja valores Fibonacci y conexiones a otros nodos
        nodo.setAnterior(FiboAlg(n - 1));
        nodo.setSiguiente(FiboAlg(n - 2));
        nodo.setValor(nodo.getAnterior().getValor() + nodo.getSiguiente().getValor());
        return nodo;
    }

    public static void printTree(Celda root) {
        if (root == null) return;

        Queue<Celda> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        int levelMaxWidth = (int)Math.pow(2, level); // Ancho máximo del nivel actual

        while (!queue.isEmpty()) {
            int levelNodes = queue.size();
            while (levelNodes > 0) {
                Celda currentNode = queue.poll();
                
                if (currentNode != null) {
                    System.out.print(currentNode.getValor() + " ");
                    queue.add(currentNode.getAnterior());
                    queue.add(currentNode.getSiguiente());
                } else {
                    // Agregar placeholders para mantener la estructura al imprimir
                    System.out.print("  ");
                    queue.add(null);
                    queue.add(null);
                }
                levelNodes--;
            }
            System.out.println();
            level++;
            if (level == levelMaxWidth) {
                break; // Detener si hemos alcanzado la anchura máxima del nivel para visualización
            }
        }
    }

    public static void main(String[] args) {
        Maquina maquina = new Maquina();
        maquina.construirArbol(4); // Ajuste según la profundidad deseada
        printTree(maquina.raiz);
    }
}
