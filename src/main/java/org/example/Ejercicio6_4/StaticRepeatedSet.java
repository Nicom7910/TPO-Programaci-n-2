package org.example.Ejercicio6_4;

public class StaticRepeatedSet {

    private static final int MAX = 10000;

    private final int[] elements;
    private final int[] quantities;
    private int count;

    public StaticRepeatedSet() {
        this.elements = new int[MAX];
        this.quantities = new int[MAX];
        this.count = 0;
    }


    public void add(int element, int quantity) {
        for (int i = 0; i < this.count; i++) {
            if (this.elements[i] == element) {
                this.quantities[i] += quantity; // Incrementar la cantidad
                return;
            }
        }

        if (this.count == MAX) {
            throw new RuntimeException("El conjunto está lleno");
        }
        this.elements[this.count] = element;
        this.quantities[this.count] = quantity;
        this.count++;
    }


    public void remove(int element, int quantity) {
        for (int i = 0; i < this.count; i++) {
            if (this.elements[i] == element) {
                this.quantities[i] -= quantity;
                if (this.quantities[i] <= 0) {

                    this.elements[i] = this.elements[this.count - 1];
                    this.quantities[i] = this.quantities[this.count - 1];
                    this.count--;
                }
                return;
            }
        }
    }


    public int getQuantity(int element) {
        for (int i = 0; i < this.count; i++) {
            if (this.elements[i] == element) {
                return this.quantities[i];
            }
        }
        return 0;
    }


    public boolean contains(int element) {
        for (int i = 0; i < this.count; i++) {
            if (this.elements[i] == element) {
                return true;
            }
        }
        return false;
    }


    public boolean isEmpty() {
        return this.count == 0;
    }


    public void printSet() {
        System.out.print("{ ");
        for (int i = 0; i < this.count; i++) {
            System.out.print("(" + this.elements[i] + ", " + this.quantities[i] + ") ");
        }
        System.out.println("}");
    }
}
