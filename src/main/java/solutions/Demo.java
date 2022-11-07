package solutions;

import solutions.posotives.Positives;
import solutions.shapes.Ball;
import solutions.shapes.Cube;
import solutions.shapes.Cylinder;
import solutions.shapes.Shape;
import solutions.tags.TagCounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demo class
 */
public class Demo {
    /**
     * example of all assignments
     */
    public static void main(String[] args) {
        System.out.println("-----------only positive numbers with reverse sorting----------------");
        int[] values = new int[]{1, 2, -3, 4, -142, 13, 1, 234, -123};
        String result = Arrays.stream(Positives.findElements(values)).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(result);

        System.out.println("----------tag counting ----------------------------------------------");
        System.out.println(TagCounter.topFiveTags(
                List.of(
                        "#hashtag1 #hashtag2 #hashtag1 #hashtag1 #hashtag2",
                        "#hashtag1 text without any tags will be ",
                        "skipped #hashtag1 #hashtag2 #hashtag3 #hashtag5#hashtag5#hashtag5",
                        "#hashtag5#hashtag5 #hashtag1 #hashtag1 #hashtag21 #hashtag123 #hashtag21")));

        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Cube(3));
        shapes.add(new Ball(5));
        shapes.add(new Cylinder(4, 2));

        shapes.add(new Cube(2));
        shapes.add(new Cylinder(4, 12));
        shapes.add(new Ball(4));

        shapes.add(new Cube(1));
        shapes.add(new Cylinder(4, 1));
        shapes.add(new Ball(6));

        System.out.println("----------------sorting 3d shapes------------------------------------");
        Shape.sort(shapes);
        shapes.forEach(System.out::println);

        System.out.println("----------------reverse sorting 3d shapes---------------------------");
        Shape.sortReversed(shapes);
        shapes.forEach(System.out::println);
    }
}
