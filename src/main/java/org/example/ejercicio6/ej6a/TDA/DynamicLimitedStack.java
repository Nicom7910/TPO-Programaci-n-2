package org.example.ejercicio6.ej6a.TDA;

public class DynamicLimitedStack extends DynamicStack {
    private int maxCapacity;  // Capacidad máxima de la pila
    private int currentSize;  // Número de elementos actuales

    // Constructor que inicializa la pila con una capacidad máxima
    public DynamicLimitedStack(int maxCapacity) {
        super(); // Llama al constructor de DynamicStack
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que cero.");
        }
        this.maxCapacity = maxCapacity;
        this.currentSize = 0; // Inicialmente la pila está vacía
    }

    @Override
    public void add(int value) {
        if (isFull()) {
            throw new IllegalStateException("La pila ha alcanzado su capacidad máxima.");
        }
        super.add(value); // Llama al método `add` de DynamicStack
        currentSize++;    // Incrementa el tamaño actual
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacía.");
        }
        super.remove(); // Llama al método `remove` de DynamicStack
        currentSize--;  // Decrementa el tamaño actual
    }

    public boolean isFull() {
        return currentSize >= maxCapacity; // Verifica si la pila está llena
    }

    public int size() {
        return currentSize; // Devuelve el tamaño actual de la pila
    }

    public int getMaxCapacity() {
        return maxCapacity; // Devuelve la capacidad máxima de la pila
    }
}
