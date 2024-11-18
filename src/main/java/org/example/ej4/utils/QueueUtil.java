package ej4.utils;

import ej4.tda.Queue;
import ej4.tda.StaticQueue;
import ej4.tda.*;

public class QueueUtil {

    public static Queue copy(Queue queue) {
        Queue aux = new StaticQueue();
        Queue copy = new StaticQueue();
        while(!queue.isEmpty()) {
            aux.add(queue.getFirst());
            queue.remove();
        }

        while(!aux.isEmpty()) {
            copy.add(aux.getFirst());
            queue.add(aux.getFirst());
            aux.remove();
        }

        return copy;
    }

    public static void print(Queue queue) {
        Queue copy = copy(queue);
        while(!copy.isEmpty()) {
            int element = copy.getFirst();
            System.out.println(element);
            copy.remove();
        }
    }


}
