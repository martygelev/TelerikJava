package dsa;

import java.util.List;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        int single = singleNumber(nums);
        System.out.println(single);
    }

    public static int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == -444) {
                continue;
            }
            int single = 0;
            for (int k = i + 1; k < nums.length; k++) {
                single = 0;
                if (num == nums[k]) {
                    nums[i] = -444;
                    nums[k] = -444;
                    single++;
                    break;
                }
            }
            if (single == 0) {
                return num;
            }
        }
        return 0;
    }
}
