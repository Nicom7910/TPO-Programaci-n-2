package org.example.ejercicio6.ej6b.TDA;
import java.util.HashSet;

public class UniversalSet implements Set {

    public HashSet<Integer> universalSet; // Representa el superconjunto

    // Constructor que inicializa el superconjunto con un conjunto de valores
    public UniversalSet() {
        this.universalSet = new HashSet<>();
    }

    @Override
    public void add(int a) {
        // Agregar el elemento solo si no existe
        universalSet.add(a);
    }

    @Override
    public void remove(int a) {
        // Remover el elemento si existe
        universalSet.remove(a);
    }

    @Override
    public int choose() {
        // Elegir un elemento arbitrario del conjunto (puedes usar iteradores)
        if (this.isEmpty()) {
            throw new RuntimeException("El conjunto está vacío. No se puede elegir un elemento.");
        }
        return universalSet.iterator().next(); // Devuelve un elemento cualquiera
    }

    @Override
    public boolean isEmpty() {
        return universalSet.isEmpty();
    }

    // Método para verificar si otro conjunto es subconjunto del superconjunto
    public boolean isSubset(Set otherSet) {
        UniversalSet tempOtherSet = (UniversalSet) otherSet; // Se asume una implementación compatible
        for (int element : tempOtherSet.universalSet) {
            if (!universalSet.contains(element)) {
                return false; // Si algún elemento no está, no es subconjunto
            }
        }
        return true;
    }

    // Método para calcular el complemento de un conjunto recibido
    public UniversalSet complement(Set otherSet) {
        // Verificar que el conjunto recibido es subconjunto
        if (!isSubset(otherSet)) {
            throw new IllegalArgumentException("El conjunto recibido no es subconjunto del superconjunto.");
        }

        // Crear un nuevo conjunto con el complemento
        UniversalSet complementSet = new UniversalSet();
        for (int element : universalSet) {
            UniversalSet tempOtherSet = (UniversalSet) otherSet;
            if (!tempOtherSet.universalSet.contains(element)) {
                complementSet.add(element); // Agregar los elementos que no están en el subconjunto
            }
        }
        return complementSet;
    }
}