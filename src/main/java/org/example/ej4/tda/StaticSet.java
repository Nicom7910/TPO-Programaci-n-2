package org.example.ej4.tda;

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

    public void add(int a) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i] == a) {
                return;
            }
        }
        this.array[this.count] = a;
        this.count++;
    }

    //No se agrega a la interface por que se puede hacer con los metodos originales de la estructura
    public StaticSet addAll(StaticSet otherSet) {
        for (int i = 0; i < otherSet.count; i++) {
            this.add(otherSet.array[i]);
        }
        return this;
    }

    @Override
    public int choose() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }
        int i = random.nextInt(count);
        return this.array[i];
    }

    @Override
    public void remove(int a) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i] == a) {
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

    // Clase interna para implementar el patrón Builder. No se agrega a la interface por que se puede hacer con los metodos originales de la estructura
    public static class Builder {
        private final StaticSet staticSet;

        public Builder() {
            this.staticSet = new StaticSet();
        }

        public Builder add(int value) {
            this.staticSet.add(value);
            return this;
        }

        public Builder addAll(StaticSet otherSet) {
            this.staticSet.addAll(otherSet);
            return this;
        }

        public StaticSet build() {
            return this.staticSet;
        }
    }
}
