package com.example.Maquina;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Maquina {
    private List<Integer> fiboList;
    private int n;

    public Maquina(int n) {
        this.n = n;
        this.fiboList = new ArrayList<>();
        this.fiboList.add(0);
        this.fiboList.add(1);
        fibo(n);
    }

    private void fibo(int n) {
        // Comenzar a calcular desde el tercer elemento si n es mayor que 1.
        for (int i = fiboList.size(); i <= n; i++) {
            int nValue = fiboList.get(i - 1) + fiboList.get(i - 2);
            fiboList.add(nValue);
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

}
