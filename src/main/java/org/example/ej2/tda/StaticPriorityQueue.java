package ej2.tda;

import ej2.tda.*;

public class StaticPriorityQueue<T> implements PriorityQueue<T> {

    private static final int MAX = 10000;

    private final Object[] values; // Usamos Object para manejar genéricos
    private final int[] priorities;
    private int count;

    public StaticPriorityQueue() {
        this.values = new Object[MAX];
        this.priorities = new int[MAX];
        this.count = 0;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        return (T) values[0]; // Cast a T
    }

    @Override
    public int getPriority() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener la prioridad de una cola vacía");
        }
        return priorities[0];
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede eliminar de una cola vacía");
        }
        for (int i = 0; i < count - 1; i++) {
            this.values[i] = this.values[i + 1];
            this.priorities[i] = this.priorities[i + 1];
        }
        count--;
    }

    @Override
    public void add(T value, int priority) {
        if (this.count == MAX) {
            throw new RuntimeException("La cola está llena");
        }

        if (this.isEmpty()) {
            this.values[0] = value;
            this.priorities[0] = priority;
            this.count++;
            return;
        }

        if (this.priorities[count - 1] <= priority) {
            this.values[count] = value;
            this.priorities[count] = priority;
            this.count++;
            return;
        }

        if (this.priorities[0] > priority) {
            for (int i = this.count; i > 0; i--) {
                this.values[i] = this.values[i - 1];
                this.priorities[i] = this.priorities[i - 1];
            }
            this.values[0] = value;
            this.priorities[0] = priority;
            this.count++;
            return;
        }

        int index = -1;
        for (int i = 1; i < this.count; i++) {
            if (this.priorities[i - 1] <= priority && this.priorities[i] > priority) {
                index = i;
                break;
            }
        }
        for (int i = this.count; i > index; i--) {
            this.values[i] = this.values[i - 1];
            this.priorities[i] = this.priorities[i - 1];
        }

        this.values[index] = value;
        this.priorities[index] = priority;
        this.count++;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}
