package ok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GreaterMonkey {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] bag1Str = in.readLine().split(",");
        String[] bag2Str = in.readLine().split(",");
        int[] bag1 = new int[bag1Str.length];
        int[] bag2 = new int[bag2Str.length];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bag2Str.length; i++) {
            if (i<bag1Str.length){
                bag1[i] = Integer.parseInt(bag1Str[i]);
                bag2[i] = Integer.parseInt(bag2Str[i]);
            }else {
                bag2[i] = Integer.parseInt(bag2Str[i]);
            }
        }
        HashSet<Integer> used = new HashSet<>();
        int counter = 0;
        for (int i = 0; i < bag1.length; i++) {
            for (int j = i; j < bag2.length; j++) {
                if (used.contains(bag2[j])){
                    continue;
                }
                if (bag1[i]<bag2[j]){
                    sb.append(bag2[j]);
                    // sb.append(",");
                    used.add(bag1[i]);
                    used.add(bag2[j]);
                    counter++;
                    break;
                }
            }
            if (counter==i){
                sb.append("-1");
                used.add(bag1[i]);
                counter++;
            }
            sb.append(",");

        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
