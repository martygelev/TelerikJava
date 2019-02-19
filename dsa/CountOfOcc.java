package dsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfOcc {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] numbersIntStr = input.readLine().split("\\s+");

        List<Integer> numbers = new ArrayList<>();
        for (String aNumbersIntStr : numbersIntStr) {
            numbers.add(Integer.parseInt(aNumbersIntStr));
        }

        Map<Integer, Integer> countOfNumbers = getOddCountOfNumbers(numbers);
        for (Map.Entry<Integer, Integer> pair : countOfNumbers.entrySet()) {
            System.out.printf("%d -> %d times\r\n", pair.getKey(), pair.getValue());
        }
    }

    private static Map<Integer, Integer> getOddCountOfNumbers(List<Integer> numbers) {
        Map<Integer, Integer> numbersWithCount = new HashMap<>();
        for (Integer num : numbers) {
            if (! numbersWithCount.containsKey(num)) {
                numbersWithCount.put(num, 1);
            } else {
                numbersWithCount.put(num, numbersWithCount.get(num) + 1);
            }
        }

        return numbersWithCount;
    }
}
