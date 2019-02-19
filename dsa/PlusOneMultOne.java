package dsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class PlusOneMultOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Queue<Integer> queue = new LinkedList<>();
        int index = 0;
        queue.add(n);

        while (!queue.isEmpty()){
            index += 1;
            int current = queue.poll();
            if (index==m){
                System.out.println(current);
                break;
            }else {
                queue.add(current+1);
                queue.add(2*current +1);
                queue.add(current+2);
            }

        }
    }
}