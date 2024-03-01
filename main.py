import time
import matplotlib.pyplot as plt
import numpy as np
from scipy.optimize import curve_fit

class Transition:
    def __init__(self, current_state, current_symbol, new_state, new_symbol, direction):
        self.current_state = current_state
        self.current_symbol = current_symbol
        self.new_state = new_state
        self.new_symbol = new_symbol
        self.direction = direction  # 1: right, -1: left, 0: stay

class TuringMachine:
    def __init__(self):
        self.transitions = {}
        self.tape = list()
        self.current_state = "q0"
        self.current_position = 0

    def construct(self, filename):
        with open(filename, "r") as file:
            for line in file:
                line = line.strip()
                if line:
                    (
                        current_state,
                        new_state,
                        current_symbol,
                        new_symbol,
                        direction,
                    ) = line.split()
                    self.transitions[(current_state, current_symbol)] = (
                        new_state,
                        new_symbol,
                        int(direction),
                    )

    def simulate(self, init_tape):
        self.tape = list(init_tape + "_")
        while self.current_state != "qAccept":
            if (self.current_position < 0) or (self.current_position >= len(self.tape)):
                self.tape.append("_")
            if (
                self.current_state,
                self.tape[self.current_position],
            ) not in self.transitions:
                break
            self.step()

    def step(self):
        current_symbol = self.tape[self.current_position]
        new_state, new_symbol, direction = self.transitions[
            (self.current_state, current_symbol)
        ]
        self.tape[self.current_position] = new_symbol
        self.current_state = new_state
        self.current_position += direction


def exponential_function(x, a, b, c):
    return a * np.exp(b * x) + c

def main():
    machine = TuringMachine()
    machine.construct("machine.txt")

    input_lengths = []
    average_execution_times = []

    repetitions = 100000

    for i in range(1, 1000, 100):
        entry = "1" * i + "0"
        input_lengths.append(len(entry))

        execution_times = []

        for _ in range(repetitions):
            start_time = time.time()
            machine.simulate(entry)
            end_time = time.time()

            execution_times.append(end_time - start_time)

        average_execution_time = sum(execution_times) / repetitions
        average_execution_times.append(average_execution_time)

        print(f"Average Time taken: {average_execution_time} seconds\n")

    input_lengths = np.array(input_lengths)
    average_execution_times = np.array(average_execution_times)

    # Polynomial Fit
    poly_coeffs = np.polyfit(input_lengths, average_execution_times, 2)
    poly_fit_func = np.poly1d(poly_coeffs)
    poly_fit_values = poly_fit_func(input_lengths)

    # Intento Exponential Fit con un manejo de error mejorado
    try:
        exp_coeffs, _ = curve_fit(exponential_function, input_lengths, average_execution_times, p0=(1, 0.001, 1), maxfev=10000)
        exp_fit_values = exponential_function(input_lengths, *exp_coeffs)
    except RuntimeError as e:
        print("Error al realizar el ajuste exponencial:", e)
        exp_fit_values = [np.nan] * len(input_lengths)

    plt.figure(figsize=(10, 6))
    plt.scatter(input_lengths, average_execution_times, color='blue', label='Original Data')
    plt.plot(input_lengths, poly_fit_values, 'r-', label='Polynomial Fit')
    plt.plot(input_lengths, exp_fit_values, 'g--', label='Exponential Fit')  # Corregido para evitar el aviso de linestyle
    plt.title('Fit to Turing Machine Execution Time')
    plt.xlabel('Input Size (Number of Characters)')
    plt.ylabel('Average Time taken (seconds)')
    plt.legend()
    plt.grid(True)
    plt.show()

if __name__ == "__main__":
    main()