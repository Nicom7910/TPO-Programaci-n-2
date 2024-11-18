package org.example.Ejercicio6_4;

public class Main6_4 {
    public static void main(String[] args) {
        StaticRepeatedSet repeatedSet = new StaticRepeatedSet();


        repeatedSet.add(5, 3); // Agregar 5 con cantidad 3
        repeatedSet.add(2, 2); // Agregar 2 con cantidad 2
        repeatedSet.add(5, 2); // Incrementar la cantidad de 5 en 2


        System.out.println("Conjunto actual:");
        repeatedSet.printSet(); // { (5, 5) (2, 2) }


        repeatedSet.remove(5, 3); // Reducir la cantidad de 5 en 3
        System.out.println("Después de remover 3 de 5:");
        repeatedSet.printSet(); // { (5, 2) (2, 2) }


        System.out.println("Cantidad de 5: " + repeatedSet.getQuantity(5)); // 2
        System.out.println("Cantidad de 2: " + repeatedSet.getQuantity(2)); // 2


        System.out.println("¿Contiene 5? " + repeatedSet.contains(5)); // true
        System.out.println("¿Contiene 3? " + repeatedSet.contains(3)); // false


        repeatedSet.remove(5, 2);
        repeatedSet.remove(2, 2);
        System.out.println("¿Está vacío? " + repeatedSet.isEmpty()); // true
    }
}
