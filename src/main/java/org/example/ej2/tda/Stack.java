package org.example.ej2.tda;

public interface Stack<T> {
    T getTop();
    void remove();
    void add(T value);
    boolean isEmpty();
}
