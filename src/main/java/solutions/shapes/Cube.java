package solutions.shapes;

import java.util.Objects;
/**
 * Shape extension by Cube class
 */
public class Cube extends Shape {
    private final double side;


    /**
     *
     * @param firstSide - side of given cube
     */
    public Cube(double firstSide) {
        this.side = firstSide;

    }

    @Override
    public double getVolume() {
        return Math.pow(side, 3);
    }

    @Override
    public double getArea() {
        return 6 * Math.pow(side, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return this.getVolume() - cube.getVolume() < DELTA;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }

}
