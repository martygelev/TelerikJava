import java.util.Stack;

public class LargestRectangle {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};

        int best = Solution.largestRectangleArea(heights);
        System.out.println(best);
    }


    static class Solution {
        public static int largestRectangleArea(int[] heights) {
            return findArea(heights, 0, heights.length - 1);
        }

        public static int findArea(int[] heights, int start, int end) {
            if (heights.length == 0) {
                return 0;
            }
            int indexOfMin = getIndexOfMin(heights, start, end);

            int left = 0;
            if (start <= indexOfMin - 1) {
                left = findArea(heights, start, indexOfMin - 1);
            }
            int current = heights[indexOfMin] * (end - start + 1);
            int right = 0;
            if (indexOfMin + 1 < end) {
                right = findArea(heights, indexOfMin + 1, end);
            }
            return Math.max(left, Math.max(current, right));
        }

        private static int getIndexOfMin(int[] heights, int start, int end) {
            int minIndex = start;
            for (int i = start; i < end + 1; i++) {
                if (heights[i] < heights[minIndex]) {
                    minIndex = i;
                }
            }
            return minIndex;
        }
    }
}