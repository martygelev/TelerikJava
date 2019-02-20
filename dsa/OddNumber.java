package ok;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class OddNumber {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        long numbersCount = Long.parseLong(in.readLine());
        Map<Long, Integer> oddNumbers = new HashMap<>();
        for (int i = 0; i < numbersCount; i++) {
            Long currentNumber = Long.parseLong(in.readLine());
            if (!oddNumbers.containsKey(currentNumber)) {
                oddNumbers.put(currentNumber, 1);
            } else {
                int value = oddNumbers.get(currentNumber);
                value++;
                oddNumbers.put(currentNumber, value);
            }
        }
        for (long key : oddNumbers.keySet()) {
            int value = oddNumbers.get(key);
            if (value % 2 != 0) {
                System.out.println(key);
            }
        }
    }
}
