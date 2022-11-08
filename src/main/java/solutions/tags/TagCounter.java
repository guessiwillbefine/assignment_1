package solutions.tags;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Solution for 2nd assignment
 */
public class TagCounter {
    /**
     * constant which set up result length
     */
    private static final int TOP_LENGTH = 5;

    /*private constructor because it's no use to create instances
    of current class - we have only static methods */
    private TagCounter() {}
    /**
     * @param texts - List of texts string contain tags to count
     * @return Map sorted by amount of tag repetitions, if equals sort by natural order. if there will be no tags in text will return an empty Map.
     * duplicate tags are counting as one.
     */
    public static Map<String, Long> topFiveTags(List<String> texts) {
        if (texts == null) throw new NullPointerException();
        else if (texts.isEmpty()) return Collections.emptyMap();
        String text = String.join(" ", texts);
        Matcher matcher = Pattern.compile("#\\w+").matcher(text);
        Map<String, Long> temporalMap = new LinkedHashMap<>();
        String previous = "";
        while (matcher.find()) {
            String current = matcher.group();
            if (!previous.equals(current)) {
                if (temporalMap.containsKey(current)) {
                    temporalMap.put(current, temporalMap.get(current) + 1);
                } else {
                    temporalMap.put(current, 1L);
                }
                previous = current;
            }
        }

        Map<String, Long> result = new LinkedHashMap<>();
        temporalMap.entrySet()
                .stream()
                .sorted((o1, o2) ->
                        {
                            if (o1.getValue().equals(o2.getValue())) {
                                return o1.getValue().compareTo(o2.getValue());
                            }
                            return o1.getValue() > o2.getValue() ? -1 : 1;
                        }
                ).limit(TOP_LENGTH)
                .forEach(x -> result.put(x.getKey(), x.getValue()));
        return result;
    }
}