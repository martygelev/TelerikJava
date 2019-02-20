package dsa;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class findDifferenceStr {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        char res = findTheDifference(s, t);
        System.out.println(res);
    }

    public static char findTheDifference(String s, String t) {

        String sChange = Stream.of(s)
                .map(String::chars)
                .flatMap(intStream -> intStream.mapToObj(charCode -> new String(new char[]{(char) charCode})))
                .sorted().toString();

        String tChange = Stream.of(t)
                .map(String::chars)
                .flatMap(intStream -> intStream.mapToObj(charCode -> new String(new char[]{(char) charCode})))
                .sorted().toString();


        for (int i = 0; i < tChange.length() - 1; i++) {
            if (sChange.toCharArray()[i] != tChange.toCharArray()[i]) {
                char res = tChange.charAt(i);
                return res;
            }
        }
        return tChange.toCharArray()[sChange.length()];
    }
}

