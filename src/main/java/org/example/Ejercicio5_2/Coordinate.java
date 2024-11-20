package org.example.Ejercicio5_2;

public class Coordinate {
    private final double x;
    private final double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Calcula la distancia de esta coordenada al origen (0, 0).
     * @return La distancia al origen.
     */
    public double distanceToOrigin() { // Complejidad O(1);
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
