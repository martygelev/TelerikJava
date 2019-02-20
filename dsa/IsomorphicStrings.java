package dsa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "ggg";
        String t = "all";

        boolean isomorphic = isIsomorphic(s, t);
        System.out.println(isomorphic);

    }

    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        } else if (s.equals("") && t.equals("")) {
            return true;
        } else if (s.isEmpty()) {
            return false;
        } else if (t.isEmpty()) {
            return false;
        }

        String[] s1Arr = s.split("");
        String[] s2Arr = t.split("");

        for (int i = 0; i < s1Arr.length - 1; i++) {
            if (s1Arr[i].equals(s1Arr[i + 1]) && s2Arr[i].equals(s2Arr[i + 1])) {
                continue;
            } else if (!(s1Arr[i].equals(s1Arr[i + 1])) && !(s2Arr[i].equals(s2Arr[i + 1]))) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
