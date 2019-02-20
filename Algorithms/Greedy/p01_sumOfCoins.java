import java.util.Map;
import java.util.Scanner;

public class p01_sumOfCoins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);

            int targetSum = Integer.parseInt(in.nextLine().substring(5));

            Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);
            System.out.println("Number of coins to take: " +);
        }

        public static Map<Integer, Integer> chooseCoins ( int[] coins, int targetSum){
            while (targetSum > 0) {

            }
            return null;
        }
    }