package solutions.shapes;

import java.util.Objects;

/**
 * Shape extension by Cylinder class
 */
public class Cylinder extends Shape {
    private final double height;
    private final double radius;

    /**
     * @param height - cylinder height
     * @param radius - cylinder radius
     */
    public Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius,2) * height;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * radius * height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cylinder cylinder = (Cylinder) o;
        return this.getVolume() - cylinder.getVolume() < DELTA;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), height, radius);
    }

}
