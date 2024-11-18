package org.example.Ejercicio6_3;


public class CyclicDynamicQueue {
    private DoublyNode head;
    private DoublyNode tail;
    private int size;

    public CyclicDynamicQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(int value) {
        DoublyNode newNode = new DoublyNode(value);
        if (this.isEmpty()) {
            head = newNode;
            tail = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
        size++;
    }


    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede eliminar de una cola vacía");
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        size--;
    }


    public int getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primer elemento de una cola vacía");
        }
        return head.value;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }


    public void printQueue() {
        if (this.isEmpty()) {
            System.out.println("La cola está vacía");
            return;
        }
        DoublyNode current = head;
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println("]");
    }
}

