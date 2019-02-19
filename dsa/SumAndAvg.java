package ok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumAndAvg {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        if (line.equals("")) {
            System.out.println(String.format("Sum=%d; Average=%.2f", 0, 0d));
            return;
        }
        int sum = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).sum();
        double average = Arrays.stream(line.split("\\s+")).mapToDouble(Double::parseDouble).average().orElse(0);
        System.out.println(String.format("Sum=%d; Average=%.2f", sum, average));
    }
}
