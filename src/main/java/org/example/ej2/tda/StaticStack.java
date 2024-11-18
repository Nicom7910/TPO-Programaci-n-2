package org.example.ej2.tda;

public class StaticStack<T> implements Stack<T> {

    private static final int MAX = 10000;

    private final Object[] array; // Usamos Object para manejar genéricos
    private int count;

    public StaticStack() {
        this.array = new Object[MAX];
        this.count = 0;
    }

    @Override
    public T getTop() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía");
        }
        return (T) array[this.count - 1]; // Cast a T
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede eliminar de una pila vacía");
        }
        count--;
    }

    @Override
    public void add(T value) {
        if (this.count == MAX) {
            throw new RuntimeException("La pila está llena");
        }
        this.array[this.count] = value;
        this.count++;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}

