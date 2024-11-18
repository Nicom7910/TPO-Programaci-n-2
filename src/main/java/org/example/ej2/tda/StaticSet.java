package ej2.tda;
import java.util.Random;

public class StaticSet<T> implements Set<T> {

    private static final int MAX = 10000;

    private final Object[] array; // Usamos Object para manejar genéricos
    private int count;
    private final Random random;

    public StaticSet() {
        this.array = new Object[MAX];
        this.count = 0;
        this.random = new Random();
    }

    @Override
    public void add(T a) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i].equals(a)) {
                return;
            }
        }
        this.array[this.count] = a;
        this.count++;
    }

    @Override
    public T choose() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }
        int i = random.nextInt(count);
        return (T) this.array[i]; // Cast a T
    }

    @Override
    public void remove(T a) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i].equals(a)) {
                this.array[i] = this.array[this.count - 1];
                this.count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}

