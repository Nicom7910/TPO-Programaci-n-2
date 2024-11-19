package org.example.ej5Parte1.utils;

import org.example.ej5Parte1.tda.*;

public class StackUtils {

    //La complejidad del algoritmo entero es O(N^3).
    public static StaticStack generarStackOrdenadoYFiltrado(StaticStack inputStack) { // O(C) + O(N) + O(C) + O(N^3) + O(C) + O(N) + O(c) = O(N^3)
        StaticSet uniqueSet = new StaticSet(); //O(C)

        while (!inputStack.isEmpty()) { // C+ N + = O(N)
            uniqueSet.add(inputStack.getTop()); // C+ N = O(N)
            inputStack.remove(); //O(c)
        }

        StaticStack orderedStack = new StaticStack(); // O(C)

        while (!uniqueSet.isEmpty()) { //O(N^3)
            int min = encontrarMinimo(uniqueSet); //O(N^2)
            orderedStack.add(min); // O(C)
        }

        StaticStack finalStack = new StaticStack(); // O(C)

        while (!orderedStack.isEmpty()) {  //O(N)
            finalStack.add(orderedStack.getTop()); //O(c)
            orderedStack.remove(); //O(c)
        }

        return finalStack; //O(c)
    }

    private static int encontrarMinimo(StaticSet set) {  // O(C)+ O(C) +  O(N^2) +  O(N^2) + O(C) = O(N^2)
        StaticSet tempSet = new StaticSet(); // O(C)
        int min = Integer.MAX_VALUE; // O(C)

        while (!set.isEmpty()) { // O(C) + O(N) +  O(C) + O(C) + O(N) = O(N) -> O(N^2)
            int element = set.choose(); // O(C)
            set.remove(element); // O(N)
            if (element < min) { // O(C)
                min = element;  // O(C)
            }
            tempSet.add(element); // O(N)
        }

        while (!tempSet.isEmpty()) {  // O(C) + O(N) +  O(C) + O(N) = O(N) -> O(N^2)
            int element = tempSet.choose(); // O(C)
            tempSet.remove(element); // O(N)
            if (element != min) { // O(C)
                set.add(element); // O(N)
            }
        }

        return min; // O(C)
    }
}
