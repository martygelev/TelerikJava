package ok;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class CokiSkoki {
    public static void main(String[] args) {
        int[] buildings = readInput();
        int[] jumps = new int[buildings.length];
        Stack<Integer> peeksIndexes = new Stack<>();

        for (int i = buildings.length-1; i >=0; i--) {
            while(!peeksIndexes.isEmpty() && buildings[peeksIndexes.peek()]<=buildings[i]){
                int peek = peeksIndexes.pop();
                jumps[peek]=peeksIndexes.size();
            }
            peeksIndexes.push(i);
        }

        remainingElementsJumps(jumps, peeksIndexes);
        printJumps(jumps);
    }

    private static void remainingElementsJumps(int[] jumps, Stack<Integer> peeksIndexes) {
        while(!peeksIndexes.isEmpty()){
            int peek = peeksIndexes.pop();
            jumps[peek]=peeksIndexes.size();
        }
    }

    public static int[] readInput(){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] jumps = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        return jumps;
    }

    private static void printJumps(int[] jumps){
        int maxElement = Arrays.stream(jumps).max().getAsInt();
        System.out.println(maxElement);

        for (int i = 0; i < jumps.length-1; i++) {
            System.out.print(jumps[i]+" ");
        }
        System.out.print(jumps[jumps.length-1]);
    }
}
