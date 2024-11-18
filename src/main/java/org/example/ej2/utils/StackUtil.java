package ej2.utils;

import ej2.tda.*;

public class StackUtil {
    public static <T> void reverseStack(StaticStack<T> stack) {
        StaticStack<T> aux = new StaticStack<>();
        StaticStack<T> aux1 = new StaticStack<>();

        while (!stack.isEmpty()) {
            aux.add(stack.getTop());
            stack.remove();
        }

        while (!aux.isEmpty()) {
            aux1.add(aux.getTop());
            aux.remove();
        }

        while (!aux1.isEmpty()) {
            stack.add(aux1.getTop());
            aux1.remove();
        }
    }
}
