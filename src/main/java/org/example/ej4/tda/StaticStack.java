package ej4.tda;

public class StaticStack implements Stack {


    private static final int MAX = 10000;
    private final int[] array;
    private int count;

    public StaticStack() {
        this.array = new int[MAX];
        this.count = 0;
    }

    public void add(int value) {
        if (this.count == MAX) {
            throw new RuntimeException("La pila está llena");
        }
        this.array[this.count] = value;
        this.count++;
    }

    public StaticStack addAll(StaticStack otherStack) {
        for (int i = 0; i < otherStack.count; i++) {
            this.add(otherStack.array[i]);
        }
        return this;
    }

    @Override
    public int getTop() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía");
        }
        return array[this.count - 1];
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede remover elementos de una pila vacía");
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    // Clase interna para implementar el patrón Builder
    public static class Builder {
        private final StaticStack staticStack;

        public Builder() {
            this.staticStack = new StaticStack();
        }

        public Builder add(int value) {
            this.staticStack.add(value);
            return this;
        }

        public Builder addAll(StaticStack otherStack) {
            this.staticStack.addAll(otherStack);
            return this;
        }

        public StaticStack build() {
            return this.staticStack;
        }
    }
}
