package solutions.posotives;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Solution for the 1st part of 1st assignment
 * @author storozhukk (telegram)
 *
 * tests for this class are in src/test/java/org/example/PositiveValuesTest.java
 */
public class Positives {

    /**private constructor because it's no use to create instances
       of current class - we have only static methods */
    private Positives(){}

    /**
     * @param arr - integer array
     * @return sorted with reverse order array of only positive values. If param array length is 0, will return this array back
     * if all values of given array are less than 0, it will also return an empty array
     */
    public static int[] findElements(int[] arr) {
        if (arr == null) throw new NullPointerException();
        else if (arr.length == 0) return arr;
        return Arrays.stream(arr)
                .boxed()
                .filter(Positives::isPositive)
                .sorted(Comparator.reverseOrder())
                .mapToInt(x->x)
                .toArray();
    }

    /**
     * @return boolean is given value positive or not
     */
    private static boolean isPositive(int value) {
        return value >= 0;
    }
}
