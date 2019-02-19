import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Tribonacci {
    public static BigInteger tribonacci(int n, ArrayList<BigInteger> mem) {
        BigInteger result = new BigInteger(String.valueOf(0));

        if (mem.get(n) != null) {
            result = mem.get(n);
        } else {
            result = result.add(tribonacci(n - 1, mem))
                    .add(tribonacci(n - 2, mem))
                    .add(tribonacci(n - 3, mem));
            mem.set(n, result);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int n = in.nextInt();

        ArrayList<BigInteger> mem = new ArrayList<>(Collections.nCopies(n + 1, null));
        mem.add(1, BigInteger.valueOf(n1));
        mem.add(2, BigInteger.valueOf(n2));
        mem.add(3, BigInteger.valueOf(n3));

        System.out.println(tribonacci(n, mem));
    }
}