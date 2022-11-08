package solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import solutions.posotives.Positives;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositiveValuesTest {

    @ParameterizedTest
    @MethodSource("cases")
    void testValidData(int[] input, int[] output) {
        Assertions.assertArrayEquals(output, Positives.findElements(input));
    }
    @Test
    void testNullArgs(){
        assertThrows(NullPointerException.class, () -> Positives.findElements(null));
    }
    @Test
    void invalidInput(){
        int[] arr = new int[0];
        assertEquals(arr, Positives.findElements(arr));
    }

    public static Stream<Arguments> cases(){
        return Stream.of(
                    Arguments.arguments(new int[]{1}, new int[] {1}),
                    Arguments.arguments(new int[]{-1,-2,-3,-3,-4,-5,0,1,2,3,4,5,-4}, new int[] {5,4,3,2,1,0}),
                    Arguments.arguments(new int[]{-1,-2,-3,-3}, new int[] {}),
                    Arguments.arguments(new int[]{-14,1,21,4,-4}, new int[] {21,4,1}),
                    Arguments.arguments(new int[]{0,2,3,4,1,-1,-12354,1,45}, new int[] {45,4,3,2,1,1,0})
        );
    }
}
