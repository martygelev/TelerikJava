package dsa;

import java.util.Scanner;

public class words {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s1 = in.nextLine();
        String s2 = in.nextLine();

        int total = count(s1, s2);

        for (int i = 1; i < s1.length() - 1; i++) {
            String pref = s1.substring(0, i);
            String suff = s1.substring(i, s1.length() - 1);


            total += count(suff, s2) * count(pref, s2);
        }
        System.out.println(total);
    }

    public static int count(String str, String str2) {
        int count = 0;
        int lastIndex = 0;

        while (lastIndex < str2.length()) {
            int index = str2.indexOf(str, lastIndex);
            if (index < 0) {
                break;
            }
            count++;
            lastIndex = index + 1;
        }
        System.out.printf("%s -> %s - count: %d", str, str2, count);
        System.out.println();
        return count;
    }
}
