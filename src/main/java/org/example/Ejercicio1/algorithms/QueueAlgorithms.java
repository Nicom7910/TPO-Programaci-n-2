package org.example.Ejercicio1.algorithms;


import org.example.Ejercicio1.definition.IQueue;
import org.example.Ejercicio1.definition.IStack;
import org.example.Ejercicio1.normal.Queue;
import org.example.Ejercicio1.normal.Stack;

public class QueueAlgorithms {

    public static void print(IQueue queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.getFirst());
            queue.remove();
        }
    }

    public static IQueue copy(IQueue queue) {
        IQueue copy = new Queue();
        IQueue aux = new Queue();
        while (!queue.isEmpty()) {
            aux.add(queue.getFirst());
            copy.add(queue.getFirst());
            queue.remove();
        }
        while (!aux.isEmpty()) {
            queue.add(aux.getFirst());
            aux.remove();
        }
        return copy;
    }

    public static void revert(IQueue queue) {
        IStack aux = new Stack();
        while (!queue.isEmpty()) {
            aux.add(queue.getFirst());
            queue.remove();
        }
        while (!aux.isEmpty()) {
            queue.add(aux.getTop());
            aux.remove();
        }
    }

}


