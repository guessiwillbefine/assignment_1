package solutions.shapes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import solutions.posotives.Positives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShapesSorterTest {

    @Test
    void testNullArgs(){
        assertThrows(NullPointerException.class, () -> Shape.sort(null));
        assertThrows(NullPointerException.class, () -> Shape.sortReversed(null));
    }
    @Test
    void testEmptyList() {
        List<Shape> shapes = new ArrayList<>();
        Shape.sort(shapes);
        assertEquals(Collections.emptyList(), shapes);
    }

    @ParameterizedTest
    @MethodSource("TestCases")
    void testSorting(List<Shape> expected) {
        List<Shape> actual = new ArrayList<>(List.copyOf(expected));
        Collections.shuffle(actual);
        Shape.sort(actual);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("TestCases")
    void testReversedSorting(List<Shape> args) {
        List<Shape> actual = new ArrayList<>(List.copyOf(args));
        List<Shape> expected = new ArrayList<>(List.copyOf(args));
        Collections.shuffle(actual);
        Shape.sortReversed(actual);
        Collections.reverse(expected);
        assertEquals(expected, actual);
    }


    public static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                new Cube(4),
                                new Cylinder(3, 4),
                                new Cube(124),
                                new Ball(212))),

                Arguments.of(
                        List.of(
                                new Ball(3),
                                new Cylinder(3, 4),
                                new Cube(14),
                                new Ball(12))),

                Arguments.of(
                        List.of(
                                new Ball(3),
                                new Cube(4),
                                new Cylinder(3, 4),
                                new Cube(124))),

                Arguments.of(
                        List.of(
                                new Ball(3),
                                new Cube(4),
                                new Cylinder(3, 11),
                                new Cylinder(5, 13)))
        );
    }
}
