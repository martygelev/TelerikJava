
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

 class DogeCoin {
    public static int collectCoins = 0;
    public static int bestCollection = 0;
    public static ArrayList<Integer> numbers = new ArrayList<>();
    public static int[][] matrix;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int R = Integer.parseInt(parts[0]);
        int C = Integer.parseInt(parts[1]);
        int coins = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < coins; i++) {
            String[] parts2 = scanner.nextLine().split(" ");
            int first = Integer.parseInt(parts2[0]);
            int second = Integer.parseInt(parts2[1]);
            numbers.add(first);
            numbers.add(second);
        }
        matrix = new int[R][C];
        for (int i = 0; i < numbers.size()-1; i+=2) {
            int row = numbers.get(i);
            int col = numbers.get(i+1);
            matrix[row][col]++;
        }

        solve(0,0);
        System.out.println(bestCollection);

    }
    public static int solve(int row, int col){
        if(col>=matrix[0].length || row>=matrix.length){
            return collectCoins;
        }
        if(row==matrix.length-1 && col==matrix[0].length-1){
            if(collectCoins>=bestCollection){
                bestCollection=collectCoins;
            }
            return collectCoins;
        }
        else{
            collectCoins+=matrix[row][col];
            solve(row,col+1);
            solve(row+1,col);
            return collectCoins;
        }
    }
}