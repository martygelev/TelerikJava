package ok;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String arr = "cbacdcbc";
        String res = removeDuplicateLetters(arr);
        System.out.println(res);

    }

    public static String removeDuplicateLetters(String s) {

        String s1 = Stream.of(s)
                .map(String::chars)
                .flatMap(intStream -> intStream.mapToObj(charCode -> new String(new char[]{(char) charCode})))
                .distinct().
                        sorted().
                        collect(Collectors.joining(""));

        return s1;
    }
}
