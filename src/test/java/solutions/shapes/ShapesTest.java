package solutions.shapes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static solutions.shapes.Shape.DELTA;

class ShapesTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/balls.csv")
    void testBalls(double radius,
                   double expectedVolume, double expectedArea) {

        Ball testBall = new Ball(radius);
        assertTrue(testBall.getVolume() - expectedVolume < DELTA);
        assertTrue(testBall.getArea() - expectedArea < DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/cubes.csv")
    void testCubes(double side,
                   double expectedVolume, double expectedArea) {

        Cube testCube = new Cube(side);
        assertTrue(testCube.getVolume() - expectedVolume < DELTA);
        assertTrue(testCube.getArea() - expectedArea < DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/cylinders.csv")
    void testCylinder(double radius, double height,
                      double expectedVolume, double expectedArea) {

        Cylinder testCylinder = new Cylinder(radius, height);
        assertTrue(testCylinder.getVolume() - expectedVolume < DELTA);
        assertTrue(testCylinder.getArea() - expectedArea < DELTA);
    }
}
