# Proyecto1-Algoritmos

# Simulador de Máquina de Turing

Este proyecto implementa un simulador básico de una Máquina de Turing en Python. La Máquina de Turing es una de las piezas fundamentales en la teoría de la computación y puede simular cualquier algoritmo de computadora.

## Descripción

El simulador permite definir una Máquina de Turing a través de un conjunto de transiciones especificadas en un archivo de texto. Luego, el simulador puede ejecutar esta máquina con una cinta de entrada dada y mostrar el resultado de la ejecución.

## Requisitos Previos

Para ejecutar este simulador, necesitarás:

- Python 3.6 o superior.
- Matplotlib (para la generación de gráficos de tiempos de ejecución).
- SciPy (para ajustes de curvas).

Puedes instalar Matplotlib y SciPy utilizando pip:

```bash
pip install matplotlib scipy numpy
```
## Cómo Ejecutar

1. Clona este repositorio en tu máquina local usando:
   ```bash
   git clone https://github.com/zombiewafle/Proyecto1-Algoritmos.git

2. Navega al directorio del proyecto:
   ```bash
   cd Proyecto1-Algoritmos/

4. Ejecutar el programa:
   ```bash
   python3 main.py machine.txt
   ```
   
   o
   
   ```bash
   python main.py machine.txt

6. Configurar parametros de ejecución:
   Es posible modificar el número de repeticiones que se hara el loop principal del programa, cambiando el valor de la variable repeticiones, además de que tan larga será la muestra en el loop for i in range(1, 100, 10):
