package org.example.Ejercicio3;

public class MainConcatenate {
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

        System.out.println("METODO CONCATENATE");

        StaticQueueOfQueue queueOfQueue1 = new StaticQueueOfQueue();
        queueOfQueue1.addQueue(queue1);
        queueOfQueue1.addQueue(queue2);

        System.out.println("QueueOfQueue 1 (Original):");
        queueOfQueue1.printQueueOfQueue();

        StaticQueueOfQueue queueOfQueue2 = new StaticQueueOfQueue();
        queueOfQueue2.addQueue(queue3);
        System.out.println("QueueOfQueue 2 (Original):");
        queueOfQueue2.printQueueOfQueue();


        System.out.println("Resultado:");
        QueueOfQueue concatenated = queueOfQueue1.concatenate(queueOfQueue2);

        System.out.print("[ ");
        while (!concatenated.isEmpty()) {
            Queue queue = concatenated.getFirstQueue();
            while (!queue.isEmpty()) {
                System.out.print(queue.getFirst() + " ");
                queue.remove();
            }
            concatenated.removeQueue();
        }
        System.out.print("]");

    }
}