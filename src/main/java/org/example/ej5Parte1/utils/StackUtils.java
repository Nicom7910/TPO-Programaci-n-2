package ej5Parte1.utils;

import ej5Parte1.tda.*;

public class StackUtils {
    public static StaticStack generarStackOrdenadoYFiltrado(StaticStack inputStack) {
        StaticSet uniqueSet = new StaticSet();

        while (!inputStack.isEmpty()) {
            uniqueSet.add(inputStack.getTop());
            inputStack.remove();
        }

        StaticStack orderedStack = new StaticStack();

        while (!uniqueSet.isEmpty()) {
            int min = encontrarMinimo(uniqueSet);
            orderedStack.add(min);
        }

        StaticStack finalStack = new StaticStack();

        while (!orderedStack.isEmpty()) {
            finalStack.add(orderedStack.getTop());
            orderedStack.remove();
        }

        return finalStack;
    }

    private static int encontrarMinimo(StaticSet set) {
        StaticSet tempSet = new StaticSet();
        int min = Integer.MAX_VALUE;

        while (!set.isEmpty()) {
            int element = set.choose();
            set.remove(element);
            if (element < min) {
                min = element;
            }
            tempSet.add(element);
        }

        while (!tempSet.isEmpty()) {
            int element = tempSet.choose();
            tempSet.remove(element);
            if (element != min) {
                set.add(element);
            }
        }

        return min;
    }
}
