import java.util.Scanner;

public class ElectronVotesGO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = Integer.parseInt(in.nextLine());
        int n = Integer.parseInt(in.nextLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(in.nextLine());
        }

        long count = DynamicProgrammingSolution(nums, k);

        System.out.println(count);
    }

    private static long DynamicProgrammingSolution(int[] nums, int k) {
        int[] combinations = new int[(100 * 1000) + 1];
        int maxSum = 0;

        combinations[0] = 1;

        for (int num : nums) {
            for (int j = maxSum; j >= 0; j--) {
                if (combinations[j] > 0) {
                    combinations[j + num] += combinations[j];
                    maxSum = Math.max(maxSum, j + num);
                }
            }
        }

        long numberOfSolutions = 0;
        for (int i = k; i <= maxSum; i++) {
            numberOfSolutions += combinations[i];
        }

        return numberOfSolutions;


    }


}