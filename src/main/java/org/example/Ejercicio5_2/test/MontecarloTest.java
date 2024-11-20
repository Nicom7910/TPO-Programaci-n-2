package Ejercicio5_2.test;
import Ejercicio5_2.Montecarlo;
import Ejercicio5_2.Coordinate;

import java.util.Random;

public class MontecarloTest {
    public static void main(String[] args) {
        // Crear el TDA Montecarlo con un cuadrado de lado 1
        Montecarlo montecarlo = new Montecarlo(1.0);
        Random random = new Random();

        // Generar 1000 coordenadas aleatorias
        int totalCoordinates = 1000;
        while (montecarlo.getCoordinates().size() < totalCoordinates) {  // Complejidad O(k) donde k es el número de puntos generados.
            double x = random.nextDouble(); // Coordenada x aleatoria entre 0 y 1
            double y = random.nextDouble(); // Coordenada y aleatoria entre 0 y 1
            montecarlo.addCoordinate(new Coordinate(x, y));
        }

        // Aproximar el valor de π
        double piApproximation = montecarlo.approximatePi(); // Complejidad
        System.out.println("Aproximación de π: " + piApproximation);
    }
}

// La complejidad total es la suma de componentes O(k+n) = O(k)