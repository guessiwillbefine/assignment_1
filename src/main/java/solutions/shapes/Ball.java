package solutions.shapes;

import java.util.Objects;

/**
 * Shape extension by Ball class
 */
public class Ball extends Shape{
    private final double radius;

    /**
     * @param radius - radius of given ball
     */
    public Ball(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (3.0/4.0 * Math.PI * Math.pow(radius, 3));
    }

    @Override
    public double getArea() {
        return 3.0/4.0 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ball ball = (Ball) o;
        return this.getVolume() - ball.getVolume() < DELTA;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }

}
