import java.util.Scanner;

public class AandB {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = Integer.parseInt(in.nextLine());
        String values = in.nextLine();
        char first = values.toCharArray()[0];
        char second = values.toCharArray()[2];

        char[] set1 = new char[2];
        set1[0] = first;
        set1[1] = second;
        printAllKLengthRec(set1, "", set1.length, k);
    }

    static void printAllKLengthRec(char[] set, String prefix, int n, int k) {
        if (k == 0) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < n; ++i) {
            String newPrefix = prefix + set[i];
            printAllKLengthRec(set, newPrefix, n, k - 1);
        }
    }

}
