package ejercicio6.ejercicio6.ej6a.Util;
import ejercicio6.ejercicio6.ej6a.TDA.DynamicLimitedStack;

public class Main6a {
    public static void main(String[] args) {
        // Crear una pila con capacidad máxima de 3
        DynamicLimitedStack stack = new DynamicLimitedStack(3);

        // Agregar elementos
        stack.add(10);
        stack.add(20);
        stack.add(30);

        System.out.println("¿La pila está llena? " + stack.isFull()); // true
        System.out.println("Tamaño actual: " + stack.size());         // 3

        try {
            stack.add(40); // Esto debería lanzar una excepción
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage()); // "La pila ha alcanzado su capacidad máxima."
        }

        // Eliminar un elemento y verificar el estado
        stack.remove();
        System.out.println("Elemento en el tope: " + stack.getTop()); // 20
        System.out.println("¿La pila está llena? " + stack.isFull()); // false
        System.out.println("Tamaño actual: " + stack.size());         // 2
    }
}