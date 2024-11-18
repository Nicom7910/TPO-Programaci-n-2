package ej2.tda;

public class StaticQueue<T> implements Queue<T> {

    private static final int MAX = 10000;

    private final Object[] array; // Usamos Object para manejar genéricos
    private int count;

    public StaticQueue() {
        this.array = new Object[MAX];
        this.count = 0;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        return (T) array[0]; // Cast a T
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede eliminar de una cola vacía");
        }
        for (int i = 0; i < count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        count--;
    }

    @Override
    public void add(T value) {
        if (this.count == MAX) {
            throw new RuntimeException("La cola está llena");
        }
        this.array[this.count] = value;
        this.count++;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}
