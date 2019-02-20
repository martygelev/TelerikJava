import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class NextGreaterNumber {
    public static void main(String[] args) {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};

        int result[] = Solution.nextGreaterElement(nums1, nums2);
        for (int i : result) {
            System.out.printf("%d ", i);
        }
    }

    static class Solution {
        public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> values = new HashMap<>(); // To contain the answers
            Stack<Integer> lesserElems = new Stack<>(); // To contain decreasing sequence of numbers

            for (int num : nums2) {
                while (!lesserElems.empty() && num > lesserElems.peek()) {
                    values.put(lesserElems.pop(), num);
                }
                lesserElems.push(num);
            }

            int[] result = new int[nums1.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = values.getOrDefault(nums1[i], -1);
            }
            return result;
        }
    }
}