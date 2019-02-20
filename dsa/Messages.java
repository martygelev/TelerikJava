package dsa;

import java.util.Arrays;
import java.util.Scanner;

public class Messages {
    static String[] numSystem = {"cad", "xoz", "nop", "cyk", "min", "mar", "kon", "iva", "ogi", "yan"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str1 = in.nextLine();
        String str2 = in.nextLine();
        String str3 = in.nextLine();

        long numOne = decript(str1);
        long num2 = decript(str3);
        long res = (str2 == "+" ? numOne : numOne - num2);

        String result = encriot(res);
        System.out.println(result);

    }

    public static String encriot(long num) {
        String res = "";
        int dig = 0;
        while (num > 0) {
            dig = (int) (num % 10);
            res = numSystem[dig] + res;
            num /= 10;

        }
        return res;
    }

    public static long decript(String str) {
        long res = 0;
        String dig;
        for (int k = 0; k < str.length(); k += 3) {
            dig = str.substring(k, 3);
            res = res * 10 + Arrays.asList(numSystem).indexOf(dig);
        }
        return res;
    }
}
