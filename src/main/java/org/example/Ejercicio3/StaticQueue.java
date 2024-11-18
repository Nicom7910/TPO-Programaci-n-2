package org.example.Ejercicio3;

public class StaticQueue implements Queue {

    private static final int MAX = 10000;

    private final int[] array;
    private int count;

    public StaticQueue() {
        this.array = new int[MAX];
        this.count = 0;
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope una cola vacia");
        }
        for (int i = 0; i < count - 1; i++) {
            this.array[i] = this.array[i+1];
        }
        count--;
    }

    @Override
    public void add(int value) {
        if(this.count == MAX) {
            throw new RuntimeException("La pila esta llena");
        }
        this.array[this.count] = value;
        this.count++;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    public int getFirst() {
        if (count == 0) {
            System.out.println("Error, no se puede obtener el primero de una cola vacia");
        }
        return this.array[0];
    }
}