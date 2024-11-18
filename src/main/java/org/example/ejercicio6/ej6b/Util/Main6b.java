package ejercicio6.ejercicio6.ej6b.Util;
import ejercicio6.ejercicio6.ej6b.TDA.UniversalSet;

public class Main6b {
    public static void main(String[] args) {
        // Crear un superconjunto
        UniversalSet universalSet = new UniversalSet();
        universalSet.add(1);
        universalSet.add(2);
        universalSet.add(3);
        universalSet.add(4);
        universalSet.add(5);

        // Crear un subconjunto
        UniversalSet subset = new UniversalSet();
        subset.add(2);
        subset.add(3);

        // Verificar si es subconjunto
        System.out.println("¿Es subconjunto? " + universalSet.isSubset(subset)); // true

        // Calcular el complemento
        UniversalSet complement = universalSet.complement(subset);
        System.out.println("Complemento del subconjunto: " + complement.universalSet); // [1, 4, 5]

        // Intentar calcular el complemento de un conjunto que no es subconjunto
        UniversalSet invalidSubset = new UniversalSet();
        invalidSubset.add(6);
        try {
            universalSet.complement(invalidSubset);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // "El conjunto recibido no es subconjunto del superconjunto."
        }
    }
}
