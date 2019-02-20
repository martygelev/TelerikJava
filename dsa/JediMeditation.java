package ok;

import java.util.Scanner;

public class JediMeditation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] med = in.nextLine().split(" ");

        for (String s : med) {
            if (s.charAt(0) == 'M') {
                System.out.print(s + " ");
            }
        }
        for (String s : med) {
            if (s.charAt(0) == 'K') {
                System.out.print(s + " ");
            }
        }
        for (String s : med) {
            if (s.charAt(0) == 'P') {
                System.out.print(s + " ");
            }
        }
    }
}
