package dsa;

import java.util.*;
import java.util.stream.Collectors;

public class UncommonWords {
    public static void main(String[] args) {

    }

    public static String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();

        String[] first = A.split(" ");
        String[] second = B.split(" ");

        for (String s : first) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        for (String s : second) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        List<String> unique = new ArrayList<>();

        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                unique.add(s);
            }
        }
        String[] strings = unique.toArray(new String[0]);

        return strings;
    }
}
