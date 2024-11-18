package org.example.Ejercicio6_3;

public class Main6_3 {
    public static void main(String[] args) {
        CyclicDynamicQueue queue = new CyclicDynamicQueue();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println("Cola inicial:");
        queue.printQueue(); // [ 1 2 3 ]

        System.out.println("Primer elemento: " + queue.getFirst()); // 1

        queue.remove();
        System.out.println("Después de eliminar el primer elemento:");
        queue.printQueue(); // [ 2 3 ]

        queue.add(4);
        System.out.println("Después de agregar 4:");
        queue.printQueue(); // [ 2 3 4 ]
    }
}
