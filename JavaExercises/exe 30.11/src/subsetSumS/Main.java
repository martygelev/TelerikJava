package subsetSumS;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sumInput = Integer.parseInt(in.nextLine());
        String[] input = in.nextLine().split(" ");
        int[] inputArray = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            inputArray[i] = Integer.parseInt(input[i]);
        }

        Map<String, Boolean> map = new HashMap<>();

        if (subSetFound(sumInput, inputArray, inputArray.length - 1, map)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private static boolean subSetFound(int sumInput, int[] inputArray, int index, Map<String, Boolean> map) {
        if (sumInput == 0) {
            return true;
        }

        if (index < 0 || sumInput < 0) {
            return false;
        }

        String key = index + "|" + sumInput;

        if (!map.containsKey(key)) {
            boolean exclude = subSetFound(sumInput - inputArray[index], inputArray, index - 1, map);
            boolean include = subSetFound(sumInput, inputArray, index - 1, map);
            map.put(key, include || exclude);
        }

        return map.get(key);
    }
}
