import java.math.BigInteger;
import java.util.Scanner;

public class HandShake {
    static BigInteger[] factorials;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(in.nextLine());
        factorials = new BigInteger[numberOfPeople + 1];
        int catalan = numberOfPeople / 2;
        factorials[0] = BigInteger.ONE;
        factorials[1] = BigInteger.ONE;
        System.out.println(Catalan(catalan));
    }

    static BigInteger Catalan(int number)
    {
        return Factorial(2 * number).divide (Factorial(number + 1).multiply(Factorial(number)));
    }

    static BigInteger Factorial(int number)
    {
        if (!factorials[number].equals(BigInteger.ZERO))
        {
            return factorials[number];
        }
        else
        {
            factorials[number] = Factorial(number - 1).multiply((BigInteger.valueOf(number)));
            return factorials[number];
        }
    }
}
