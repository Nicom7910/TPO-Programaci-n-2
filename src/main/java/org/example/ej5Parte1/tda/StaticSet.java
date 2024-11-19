package org.example.ej5Parte1.tda;

import java.util.Random;

public class StaticSet implements Set {

    private static final int MAX = 10000;


    private final int[] array;
    private int count;
    private final Random random;

    public StaticSet() {
        this.array = new int[MAX];
        this.count = 0;
        this.random = new Random();
    }

    @Override
    public void add(int a) { // O(n) + O(c) +O(c) +O(c) = O(n)
        for(int i = 0; i < this.count; i++) {  // O(n)
            if(this.array[i] == a) { // O(c)
                return; //O( c)
            }
        }
        this.array[this.count] = a; //O( c)
        this.count++; //O( c)
    }

    @Override
    public int choose() { // O(C)
        if(this.isEmpty()) {  // O(C)
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío"); // O(C)
        }
        int i = random.nextInt(count); // O(C)
        return this.array[i]; // O(C)
    }

    @Override
    public void remove(int a) {// O(N) + O(C) + O(C) + O(C) = O(N)
        for(int i = 0; i < this.count; i++) { // O(N)
            if(this.array[i] == a) { // O(C)
                this.array[i] = this.array[this.count-1];// O(C)
                this.count--;// O(C)
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}
