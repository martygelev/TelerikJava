
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;


class PartitionToEqualSubsets {
    static void fakeInput() {
        String input = "4, 1, 2, 2, 1, 4, 1, 4, 1\n" +
                "4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = IntStream.of(nums).sum();

        if (k <= 0 || sum % k != 0)
            return false;

        boolean[] visited = new boolean[nums.length];

        return canPartition(nums, visited, 0, k,
                0, 0, sum / k);
    }

    static boolean canPartition(int[] nums, boolean[] visited, int startIndex, int k,
                                int currentSum, int currentNum, int target) {
        if (k == 1)
            return true;

        if (currentSum == target && currentNum > 0)
            return canPartition(nums, visited, 0, k - 1,
                    0, 0, target);

        for (int i = startIndex; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;

                if (canPartition(nums, visited, i + 1, k,
                        currentSum + nums[i], currentNum++, target))
                    return true;

                visited[i] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(bf.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int k = Integer.parseInt(bf.readLine());

        System.out.println(canPartitionKSubsets(nums, k));
    }
}