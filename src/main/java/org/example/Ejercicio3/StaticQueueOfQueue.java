package org.example.Ejercicio3;


public class StaticQueueOfQueue implements QueueOfQueue {

    private static final int MAX = 10000;

    private final Queue[] array;
    private int count;

    public StaticQueueOfQueue() {
        this.array = new Queue[MAX];
        this.count = 0;
    }

    @Override
    public void addQueue(Queue queue) {
        if (this.count == MAX) {
            throw new RuntimeException("La QueueOfQueue está llena");
        }
        this.array[this.count] = queue;
        this.count++;
    }

    @Override
    public Queue getFirstQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener la primera cola de una QueueOfQueue vacía");
        }
        return this.array[0];
    }

    @Override
    public void removeQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede eliminar de una QueueOfQueue vacía");
        }
        for (int i = 0; i < count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    public QueueOfQueue concatenate(QueueOfQueue... queues) {
        StaticQueueOfQueue result = new StaticQueueOfQueue();


        for (int i = 0; i < this.count; i++) {
            result.addQueue(this.array[i]);
        }


        for (QueueOfQueue queueOfQueue : queues) {
            StaticQueueOfQueue staticQueue = (StaticQueueOfQueue) queueOfQueue;
            for (int i = 0; i < staticQueue.count; i++) {
                result.addQueue(staticQueue.array[i]);
            }
        }

        return result;
    }

    public Queue flat() {
        StaticQueue result = new StaticQueue();

        for (int i = 0; i < this.count; i++) {
            Queue currentQueue = this.array[i];
            while (!currentQueue.isEmpty()) {
                result.add(currentQueue.getFirst());
                currentQueue.remove();
            }
        }

        return result;
    }

    public StaticQueueOfQueue reverseWithDepth() {
        StaticQueueOfQueue reversedQueueOfQueue = new StaticQueueOfQueue();

        for (int i = this.count - 1; i >= 0; i--) {
            Queue currentQueue = this.array[i];
            StaticQueue reversedQueue = new StaticQueue();

            Stack stack = new StaticStack();
            while (!currentQueue.isEmpty()) {
                stack.add(currentQueue.getFirst());
                currentQueue.remove();
            }

            while (!stack.isEmpty()) {
                reversedQueue.add(stack.getTop());
                stack.remove();
            }

            reversedQueueOfQueue.addQueue(reversedQueue);
        }

        return reversedQueueOfQueue;
    }

    public void printQueueOfQueue() {
        for (int i = 0; i < this.count; i++) {
            Queue currentQueue = this.array[i];
            StaticQueue tempQueue = new StaticQueue();

            System.out.print("[ ");

            while (!currentQueue.isEmpty()) {
                int value = currentQueue.getFirst();
                System.out.print(value + " ");
                tempQueue.add(value);
                currentQueue.remove();
            }
            System.out.println("]");


            while (!tempQueue.isEmpty()) {
                currentQueue.add(tempQueue.getFirst());
                tempQueue.remove();
            }
        }
    }

}
