package Ejercicio5_2;

import java.util.ArrayList;
import java.util.List;

public class Montecarlo {
    private final double squareSize; // Tamaño del lado del cuadrado
    private final List<Coordinate> coordinates; // Lista de coordenadas válidas

    public Montecarlo(double squareSize) {
        this.squareSize = squareSize;
        this.coordinates = new ArrayList<>();
    }

    /**
     * Agrega una coordenada al conjunto solo si está dentro de la región cuadrada.
     *
     * @param coordinate La coordenada que se desea agregar.
     * @return true si la coordenada fue agregada, false en caso contrario.
     */
    public boolean addCoordinate(Coordinate coordinate) {
        if (coordinate.getX() >= 0 && coordinate.getX() <= squareSize &&
                coordinate.getY() >= 0 && coordinate.getY() <= squareSize) {
            coordinates.add(coordinate);
            return true;
        }
        return false;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    /**
     * Aproxima el valor de π usando el Método de Montecarlo.
     *
     * @return La aproximación de π.
     */
    public double approximatePi() { // Complejidad O(n), donde n es el número de coordenadas.
        int insideCircle = 0;
        for (Coordinate coordinate : coordinates) {
            if (coordinate.distanceToOrigin() <= squareSize) {
                insideCircle++;
            }
        }
        return 4.0 * insideCircle / coordinates.size();
    }
}
