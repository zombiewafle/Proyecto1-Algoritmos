package com.example;

import com.example.Maquina.Maquina;

public class App 
{
    public static void main(String[] args) {
        Maquina maquina = new Maquina();
        maquina.construirArbol(30); // Asumiendo que quieres construir un árbol para n = 5
        Maquina.printTree(maquina.raiz); // Imprime el árbol empezando por la raíz
    }
}
