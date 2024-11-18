package org.example.Ejercicio3;

public class MainReverse {
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


        StaticQueueOfQueue queueOfQueue = new StaticQueueOfQueue();
        queueOfQueue.addQueue(queue1);
        queueOfQueue.addQueue(queue2);
        queueOfQueue.addQueue(queue3);

        System.out.println("Original:");
        queueOfQueue.printQueueOfQueue();

        StaticQueueOfQueue reversedQueueOfQueue = queueOfQueue.reverseWithDepth();

        System.out.println("Invertida:");
        reversedQueueOfQueue.printQueueOfQueue();
    }
}