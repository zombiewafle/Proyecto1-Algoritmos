package com.example;

import com.example.Maquina.Maquina;
import java.util.Scanner;


public class App 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crea una instancia de Scanner para leer de la entrada estándar
        
        System.out.println("Ingrese el número de términos de la secuencia de Fibonacci que desea calcular:");
        int n = scanner.nextInt(); // Lee el número entero ingresado por el usuario

        long startTime = System.nanoTime(); 
        Maquina maquina = new Maquina(n);
        maquina.result();
        maquina.txtSaver();
        long endTime = System.nanoTime();   
        long duration = (endTime - startTime);
        System.out.println("Tiempo total de ejecución del programa: " + duration + " nanosegundos");

        // Grafico.multiGraph.setAttribute("ui.stylesheet", "url('/home/zombiewafle/Documentos/lab_a/src/main/java/com/example/Clasess/styles.css')");
        // Grafico.graphCons();
    }
}
