package com.telerikacademy.tasks.Recursion;

public class Bat {
    public String parenBit(String str) {

        if (str.charAt(0) == '('
                && str.charAt(str.length() - 1) == ')') {
            return str;
        }

        if (str.charAt(0) != '(') {
            return parenBit(str.substring(1));
        }

        if (str.charAt(str.length() - 1) != ')') {
            return parenBit(str.substring(0, str.length() - 1));
        }



        if (str.equals("")) {
            return str;
        }
        if (str.charAt(0) == '(') {
            if (str.charAt(str.length() - 1) == ')') {
                return  str;
            } else
                return parenBit(str.substring(0, str.length() - 1));
        }
        return parenBit(str.substring(1));

    }

    public boolean groupSum(int start, int[] nums, int target) {

        if (start == nums.length) {
            return target == 0;
        }

        return groupSum(start + 1, nums, target - nums[start])
                || groupSum(start + 1, nums, target);
    }
}
