package ej2.tda;

public interface Queue<T> {
    T getFirst();
    void remove();
    void add(T value);
    boolean isEmpty();
}

