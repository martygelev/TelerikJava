package DDD;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
Scanner in = new Scanner(System.in);

        String[] arr = in.nextLine().split(" ");

        Map<String,Integer> map = new HashMap<>();

        for (String element : arr) {
                if (!map.containsKey(element))
                {
                    map.put(element,0);
                }
               map.put(element,map.get(element)+1) ;
        }

        for (Map.Entry<String, Integer> kvp : map.entrySet()) {

            System.out.println(kvp.getKey() + " - " + kvp.getValue() + " times");
        }
    }
}
