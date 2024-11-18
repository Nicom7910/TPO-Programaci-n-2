package org.example.Ejercicio3;

public class MainFlat {
    public static void main(String[] args) {

        StaticQueue queue1 = new StaticQueue();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);

        StaticQueue queue2 = new StaticQueue();
        queue2.add(4);
        queue2.add(5);
        queue2.add(6);

        StaticQueue queue3 = new StaticQueue();
        queue3.add(7);
        queue3.add(8);
        queue3.add(9);


        StaticQueueOfQueue queueOfQueueFLAT = new StaticQueueOfQueue();
        queueOfQueueFLAT.addQueue(queue1);
        queueOfQueueFLAT.addQueue(queue2);
        queueOfQueueFLAT.addQueue(queue3);

        System.out.println("METODO FLAT");

        System.out.println("Original:");
        queueOfQueueFLAT.printQueueOfQueue();

        System.out.println("Resultado:");
        Queue flatQueue = queueOfQueueFLAT.flat();
        System.out.print("[ ");
        while (!flatQueue.isEmpty()) {
            System.out.print(flatQueue.getFirst() + " ");
            flatQueue.remove();
        }
        System.out.print("]");
    }
}