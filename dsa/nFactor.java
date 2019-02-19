import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

 class NFactorial {
    public static BigInteger nFactorial(int n){
        BigInteger result;

        if(n==1 || n==0){
            result = BigInteger.ONE;
            return result;
        }
        BigInteger factorial = nFactorial(n-1);
        result = BigInteger.valueOf(n).multiply(factorial);
        return result;
    }


    private static int convert(String s) {
        int value = 0;
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                flag = -1;
            } else {
                value = value * 10 + (s.charAt(i) - '0');
            }
        }
        if (flag == -1) {
            return -value;
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int n = convert(input[0]);
        BigInteger result = nFactorial(n);
        System.out.println(result);
    }
}
