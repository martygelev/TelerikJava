package ok;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Expressionagain {
    public static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer num = Integer.parseInt(in.nextLine());
        int sumToSearch = Integer.parseInt(in.nextLine());

        int lastDigit = (num) % 10;
        num /= 10;
        int second = num % 10;
        num /= 10;
        int first = num % 10;

        int val = first * second * lastDigit;
        if (!map.containsKey(val)) {
            map.put(val, 1);
        } else {
            int value = map.get(val);
            map.remove(val);
            map.put(val, value);
        }

    }
}
/*
1*2*3 = 6
1*2+3 = 5
1*2-3 = -1
1*23  = 23
1+2*3 = 9
1+2+3 = 6
1+2-3 = 0
1+23  = 24
1-2*3 = -3
1-2+3 = 2
1-2-3 = -4
1-23  = -22
12*3  = 36
12+3  = 15
12-3  = 9
123   = 123

 */