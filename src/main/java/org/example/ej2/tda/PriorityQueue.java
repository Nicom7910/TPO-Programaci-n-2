package org.example.ej2.tda;

public interface PriorityQueue<T> {
    T getFirst();
    int getPriority();
    void remove();
    void add(T value, int priority);
    boolean isEmpty();
}
