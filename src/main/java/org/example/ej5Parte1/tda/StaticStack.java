package org.example.ej5Parte1.tda;

public class StaticStack implements Stack {

    private static final int MAX = 10000;

    private final int[] array;
    private int count;

    public StaticStack() {
        this.array = new int[MAX];
        this.count = 0;
    }

    @Override
    public int getTop() {//O(c)
        if(isEmpty()) { //O(c)
            throw new RuntimeException("No se puede obtener el tope una pila vacia");//O(c)
        }
        return array[this.count - 1]; //O(c)
    }

    @Override
    public void remove() {//O(c)
        if(isEmpty()) { //O(c)
            throw new RuntimeException("No se puede obtener el tope una pila vacia");//O(c)
        }
        count--;//O(c)
    }

    @Override
    public void add(int value) { //O(c)
        if(this.count == MAX) { //O(c)
            throw new RuntimeException("La pila esta llena"); //O(c)
        }
        this.array[this.count] = value; //O(c)
        this.count++; //O(c)
    }

    @Override
    public boolean isEmpty() { // C
        return this.count == 0; // C
    }
}
