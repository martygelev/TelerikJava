package ok;

public class findErrorNumber {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4, 5, 6};

        int[] result = findErrorNums(arr);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];

        for (int i : nums) {
            if (nums[Math.abs(i) - 1] < 0) {
                res[0] = Math.abs(i);
                break;
            } else {
                nums[Math.abs(i) - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res[1] = i + 1;
                break;
            }
        }

        return res;
    }
}
