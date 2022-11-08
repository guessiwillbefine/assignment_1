package solutions;

import solutions.posotives.Positives;
import solutions.tags.TagCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class TagCounterTest {

    @Test
    void blankTestShouldReturnEmptyMap() {
        Assertions.assertEquals(Collections.emptyMap(), TagCounter.topFiveTags(Collections.emptyList()));
        assertEquals(Collections.emptyMap(), TagCounter.topFiveTags(List.of("text with no tags, so method will return empty Map")));
    }

    @Test
    void duplicatesCountsAsOne() {
        assertEquals(Map.of("#tag", 1L), TagCounter.topFiveTags(List.of("#tag #tag", "#tag #tag")));
    }

    @Test
    void splitTagsAlsoWorks() {
        List<String> text = List.of("#tag1#tag1#tag2", "#tag1#tag2#tag3");
        Map<String, Long> expected = new LinkedHashMap<>();
        expected.put("#tag1", 2L);
        expected.put("#tag2", 2L);
        expected.put("#tag3", 1L);
        assertEquals(expected, TagCounter.topFiveTags(text));
    }

    @Test
    void testNullArgs(){
        assertThrows(NullPointerException.class, () -> TagCounter.topFiveTags(null));
    }

    @Test
    void validInputTest() {
        List<String> text = List.of(
                "#tag1 #tag2 #tag3 #tag1 #tag1 #tag2 #tag3 #tag4 #tag1 #tag1 #tag4",
                "",
                " #tag5 #tag5 #tag6 #tag5 #tag6 ",
                "text without tags",
                "#tag2 #tag2 #tag31 #tag2 #tag5");

        Map<String, Long> expected = new LinkedHashMap<>();
        expected.put("#tag2", 4L);
        expected.put("#tag1", 3L);
        expected.put("#tag5", 3L);
        expected.put("#tag3", 2L);
        expected.put("#tag4", 2L);
        assertEquals(expected, TagCounter.topFiveTags(text));
    }

    @Test
    void SortByNaturalOrderIfEqual() {
        List<String> text = List.of("#a", "#b", "#c", "#b", "#c", "#a");
        Map<String, Long> expected = new LinkedHashMap<>();
        expected.put("#a", 2L);
        expected.put("#b", 2L);
        expected.put("#c", 2L);
        assertEquals(expected, TagCounter.topFiveTags(text));
    }
}
