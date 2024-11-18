package Ejercicio1.tests;

import Ejercicio1.normal.QueueOfStacks;
import Ejercicio1.normal.Stack;

public class QueueOfStacksTest {

    public static void main(String[] args) {
        // Prueba 1: Cálculo de la traza
        System.out.println("=== Prueba 1: Cálculo de la traza ===");
        QueueOfStacks matrix1 = createMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        System.out.println("Traza esperada: 15");
        System.out.println("Traza calculada: " + matrix1.calculateTrace());

        // Prueba 2: Trasposición de la matriz
        System.out.println("\n=== Prueba 2: Trasposición ===");
        QueueOfStacks transposed = matrix1.transpose();
        System.out.println("Matriz original:");
        printMatrix(matrix1);
        System.out.println("Matriz traspuesta:");
        printMatrix(transposed);

        // Prueba 3: Suma de matrices
        System.out.println("\n=== Prueba 3: Suma de matrices ===");
        QueueOfStacks matrix2 = createMatrix(new int[][]{
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        });
        QueueOfStacks sumMatrix = matrix1.sumMatrices(matrix2);
        System.out.println("Matriz 1:");
        printMatrix(matrix1);
        System.out.println("Matriz 2:");
        printMatrix(matrix2);
        System.out.println("Suma esperada:");
        System.out.println("10 10 10");
        System.out.println("10 10 10");
        System.out.println("10 10 10");
        System.out.println("Matriz suma calculada:");
        printMatrix(sumMatrix);
    }

    /**
     * Crea una matriz como instancia de QueueOfStacks a partir de un arreglo bidimensional.
     *
     * @param values Arreglo bidimensional que representa los valores de la matriz.
     * @return Una instancia de QueueOfStacks con los valores de la matriz.
     */
    private static QueueOfStacks createMatrix(int[][] values) {
        QueueOfStacks queueOfStacks = new QueueOfStacks();
        for (int[] row : values) {
            Stack stack = new Stack();
            for (int value : row) {
                stack.add(value);
            }
            queueOfStacks.addStack(stack);
        }
        return queueOfStacks;
    }

    /**
     * Imprime una matriz representada por QueueOfStacks.
     *
     * @param matrix La matriz que se desea imprimir.
     */
    private static void printMatrix(QueueOfStacks matrix) {
        QueueOfStacks copy = matrix.transpose().transpose(); // Copia indirecta para no modificar la original
        while (!copy.isEmpty()) {
            Stack stack = (Stack) copy.getFirstStack();
            while (!stack.isEmpty()) {
                System.out.print(stack.getTop() + " ");
                stack.remove();
            }
            System.out.println();
            copy.removeFirstStack();
        }
    }
}
