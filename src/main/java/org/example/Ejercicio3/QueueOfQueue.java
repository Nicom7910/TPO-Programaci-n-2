package org.example.Ejercicio3;

public interface QueueOfQueue {

    void addQueue(Queue queue); // Agregar una cola a la QueueOfQueue

    Queue getFirstQueue(); // Obtener la primera cola

    void removeQueue(); // Eliminar la primera cola

    boolean isEmpty(); // Verificar si está vacía

    //QueueOfQueue concatenate(QueueOfQueue... queues); // Concatenar múltiples QueueOfQueue
}