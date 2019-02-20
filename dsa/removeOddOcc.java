package ok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class removeOddOcc {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] numbersIntStr = input.readLine().split("\\s+");

        List<Integer> numbers = new ArrayList<>();
        for (String aNumbersIntStr : numbersIntStr) {
            numbers.add(Integer.parseInt(aNumbersIntStr));
        }

        Map<Integer, Integer> countOfNumbers = getOddCountOfNumbers(numbers);
        for (Map.Entry<Integer, Integer> pair : countOfNumbers.entrySet()) {
            if (pair.getValue() % 2 != 0) {
                removeAll(numbers, pair.getKey());
            }
        }

        for (Integer number : numbers) {
            System.out.printf("%d ", number);
        }

        System.out.println();
    }

    private static void removeAll(List<Integer> numbers, Integer number) {
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i).equals(number)) {
                numbers.remove(i);
            }
        }
    }


    private static Map<Integer, Integer> getOddCountOfNumbers(List<Integer> numbers) {
        Map<Integer, Integer> numbersWithCount = new HashMap<>();
        for (Integer num : numbers) {
            if (!numbersWithCount.containsKey(num)) {
                numbersWithCount.put(num, 1);
            } else {
                numbersWithCount.put(num, numbersWithCount.get(num) + 1);
            }
        }

        return numbersWithCount;
    }
}
