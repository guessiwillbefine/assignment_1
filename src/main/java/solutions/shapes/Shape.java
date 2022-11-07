package solutions.shapes;

import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;

/**
 * Solution for third assignment. This is base class for all 3D figures.
 */
public abstract class Shape implements Comparable<Shape> {
    final NumberFormat formatter = NumberFormat.getInstance();
    /**
     * constant for comparing double values
     */
    static final double DELTA = 0.0001;

    /**
     * @return volume of current Shape instance (double value)
     */
    public abstract double getVolume();

    /**
     * @return area of current Shape instance (double value)
     */
    public abstract double getArea();

    /**
     * sorting method
     *
     * @param shapes - List of Shape inheritors
     */
    public static void sort(List<Shape> shapes) {
//      shapes.sort(Comparator.comparing(Shape::getVolume)); <--- or like this
        Collections.sort(shapes);
    }

    /***same as Shape#sort, but makes sort in reversed order
     * @param shapes - List of Shape inheritors*/
    public static void sortReversed(List<Shape> shapes) {
//      shapes.sort(Comparator.comparing(Shape::getVolume)); <--- or like this
        Collections.sort(shapes);
        Collections.reverse(shapes);
    }

    /**
     * @param shape the object to be compared.
     * @return 0 if object are equal by volume, 1 if this.getVolume() if greater than comparing
     */
    @Override
    public int compareTo(Shape shape) {
        return Double.compare(getVolume(), shape.getVolume());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return String.format("object [ %s ] volume : %s ", this.getClass().getSimpleName(), formatter.format(getVolume()));
    }
}
