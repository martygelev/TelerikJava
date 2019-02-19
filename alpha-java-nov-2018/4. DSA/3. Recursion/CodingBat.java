package com.telerikacademy.tasks.Recursion;

import java.util.List;
import java.util.stream.Collectors;

public class CodingBat {

    /*
    https://codingbat.com/java/Recursion-1
     */
    public static void main(String[] args) {

        System.out.println(countX("xxxooosssxx"));
    }

    private static int countX(String str) {
        if(str.length() == 1){
            if(str.equals("x")){
                return 1;
            }
            return 0;
        }

        return countX(str.substring(1)) + countX(str.substring(0,1));
    }

    private int countHi(String str) {

        if(str.length() <= 1){
            return 0;
        }

        if (str.substring(0, 2).equals("hi")) {
            return 1 + countHi(str.substring(2));
        }
        return countHi(str.substring(1));
    }

    private String changeXY(String str) {

        if(str.length() <= 0){
            return "";
        }

        if (str.substring(0, 1).equals("x")) {
            return "y" + changeXY(str.substring(1));
        }
        return str.substring(0, 1) + changeXY(str.substring(1));
    }

    private String changePi(String str) {
        if(str.length() < 2){
            return str;
        }

        if (str.substring(0, 2).equals("pi")) {
            return "3.14" + changePi(str.substring(2));
        }
        return str.substring(0, 1) + changePi(str.substring(1));
    }

    private String noX(String str) {
        if(str.length() <= 0){
            return "";
        }

        if (str.substring(0, 1).equals("x")) {
            return "" + noX(str.substring(1));
        }
        return str.substring(0, 1) + noX(str.substring(1));
    }

    private boolean array6(int[] nums, int index) {
        if (index == nums.length) {
            return false;
        }

        if (nums[index] == 6) {
            return true;
        }
        return array6(nums, index + 1);
    }

    private int array11(int[] nums, int index) {
        if (index == nums.length) {
            return 0;
        }

        if (nums[index] == 11) {
            return 1 + array11(nums, index + 1);
        }
        return array11(nums, index + 1);
    }

//    array220([1, 2, 20], 0) → true
//    array220([3, 30], 0) → true
//    array220([3], 0) → false
     private boolean array220(int[] nums, int index) {
        if (nums.length == 0 || index == nums.length - 1) {
            return false;
        }
        if (nums[index] * 10 == nums[index + 1]) {
            return true;
        }
        return array220(nums, index + 1);
    }

    private String allStar(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return str.substring(0, 1) + "*" + allStar(str.substring(1));
    }

    private String pairStar(String str) {
        if (str.length() <= 1) {
            return str;
        }
        if (str.charAt(0) == str.charAt(1)) {
            return str.substring(0, 1) + "*" + pairStar(str.substring(1));
        }
        return str.substring(0, 1) + pairStar(str.substring(1));
    }

    private String endX(String str) {
        if (str.length() <= 1) {
            return str;
        }
        if (str.substring(0, 1).equals("x")) {
            return endX(str.substring(1)) + "x";
        }
        return str.substring(0, 1) + endX(str.substring(1));
    }

    private int countPairs(String str) {
        if (str.length() <= 2) {
            return 0;
        }

        if (str.charAt(0) == str.charAt(2)) {
            return 1 + countPairs(str.substring(1));
        }
        return countPairs(str.substring(1));
    }

    private int count8(int n) {
        if (n == 0) {
            return 0;
        }
        if (n / 10 == 0) {
            if (n % 8 == 0) {
                return 1;
            }
            return 0;
        }
        if (n % 10 == 8) {
            if (n % 100 == 88) {
                return count8(n / 10) + count8(n % 10) + 1;
            }
        }
        return count8(n / 10) + count8(n % 10);
    }

    private int countAbc(String str) {

        if (str.length() <= 2) {
            return 0;
        }
        int match = 0;
        if (str.substring(0, 3).equals("abc") || str.substring(0, 3).equals("aba")) {
            match = 1;
        }
        return countAbc(str.substring(1)) + match;
    }

    private int count11(String str) {
        if (str.length() <= 1) {
            return 0;
        }
        if (str.substring(0, 2).equals("11")) {
            return count11(str.substring(2)) + 1;
        }
        return count11(str.substring(1));
    }

    private String stringClean(String str) {
        if (str.length() <= 1) {
            return str;
        }
        if (str.charAt(0) == str.charAt(1)) {
            return stringClean(str.substring(1));
        }
        return str.charAt(0) + stringClean(str.substring(1));
    }

    private int countHi2(String str) {
        if (str.length() <= 1) {
            return 0;
        }
        if (str.length() >= 3 && str.substring(0, 3).equals("xhi")) {
            return countHi2(str.substring(3));
        }
        if (str.substring(0, 2).equals("hi")) {
            return 1 + countHi2(str.substring(2));
        }
        return countHi2(str.substring(1));
    }

    private String parenBit(String str) {
        if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
            return str;
        }

        if (str.charAt(0) != '(') {
            return parenBit(str.substring(1));
        }
        if (str.charAt(str.length() - 1) != ')') {
            return parenBit(str.substring(0, str.length() - 1));
        }
        return "";
    }

    private boolean nestParen(String str) {
        if (str.length() <= 2) {
            if (str.equals("()") || str.equals("")) {
                return true;
            }
            return false;
        }
        if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
            return nestParen(str.substring(1, str.length() - 1));
        }
        return false;
    }
/*
    Given a string and a non-empty substring sub,
    compute recursively the number of times that sub appears in the string,
    without the sub strings overlapping.


    strCount("catcowcat", "cat") → 2
    strCount("catcowcat", "cow") → 1
    strCount("catcowcat", "dog") → 0
    */
    private int strCount(String str, String sub) {//todo
        int subLength = sub.length();
        if (str.length() <= 0) {
            return 0;
        }

        if (str.startsWith(sub)) {
            return 1 + strCount(str.substring(subLength), sub);
        }
        return strCount(str.substring(1), sub);
    }

    /*
    Given a string and a non-empty substring sub,
    compute recursively the largest substring
    which starts and ends with sub and return its length.


    strDist("catcowcat", "cat") → 9
    strDist("catcowcat", "cow") → 3
    strDist("cccatcowcatxx", "cat") → 9
     */
    private int strDist(String str, String sub) {

        if (!str.contains(sub)) {
            return 0;
        }
        if (str.startsWith(sub) && str.endsWith(sub)) {
            return str.length();
        }

        if (!str.startsWith(sub)) {
            return strDist(str.substring(1), sub);
        }
        if (!str.endsWith(sub)) {
            return strDist(str.substring(0, str.length() - 1), sub);
        }
        return 0;
    }

    /*
    Given a string and a non-empty substring sub, compute recursively if at least n copies of sub appear in the string somewhere,
    possibly with overlapping. N will be non-negative.
    strCopies("catcowcat", "cat", 2) → true
    strCopies("catcowcat", "cow", 2) → false
    strCopies("catcowcat", "cow", 1) → true
     */
    private boolean strCopies(String str, String sub, int n) {
        if (str.length() <= sub.length()) {
            if (str.startsWith(sub)) {
                n--;
            }
            if (n <= 0) {
                return true;
            }
            return false;
        }

        if (str.startsWith(sub)) {
            return strCopies(str.substring(1), sub, n - 1);
        }
        return strCopies(str.substring(1), sub, n);
    }

    /*
    Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target?
    This is a classic backtracking recursion problem.
    Once you understand the recursive backtracking strategy in this problem, you can use the same pattern for many problems to search a space of choices.
    Rather than looking at the whole array, our convention is to consider the part of the array starting at index start and continuing to the end of the array.
    The caller can specify the whole array simply by passing start as 0.
    No loops are needed -- the recursive calls progress down the array.
    groupSum(0, [2, 4, 8], 10) → true
    groupSum(0, [2, 4, 8], 14) → true
    groupSum(0, [2, 4, 8], 9) → false
     */

    private boolean groupSum(int start, int[] nums, int target) {
        if (start ==  nums.length) {
            if(target == 0){
                return true;
            }
            return false;
        }

        if (target - nums[start] == 0) {
            return true;
        }

        return groupSum(start + 1, nums, target)
                || groupSum(start + 1, nums, target - nums[start]);
    }

    /*
    Given an array of ints, is it possible to choose a group of some of the ints,
    beginning at the start index, such that the group sums to the given target?
     However, with the additional constraint that all 6's must be chosen. (No loops needed.)
    groupSum6(0, [5, 6, 2], 8) → true
    groupSum6(0, [5, 6, 2], 9) → false
    groupSum6(0, [5, 6, 2], 7) → false
     */

    private boolean groupSum6(int start, int[] nums, int target) {
        if (start == nums.length) {
            return target == 0;
        }

        if (nums[start] == 6) {
            return groupSum6(start + 1, nums, target - 6);
        }

        return groupSum6(start + 1, nums, target - nums[start])
                || groupSum6(start + 1, nums, target);
    }

    /*
    Given an array of ints, is it possible to choose a group of some of the ints,
    such that the group sums to the given target with this additional constraint:
    If a value in the array is chosen to be in the group,
    the value immediately following it in the array must not be chosen. (No loops needed.)
    groupNoAdj(0, [2, 5, 10, 4], 12) → true
    groupNoAdj(0, [2, 5, 10, 4], 14) → false
    groupNoAdj(0, [2, 5, 10, 4], 7) → false
     */

    private boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }

        if (target - nums[start] == 0) {
            return true;
        }
        return groupNoAdj(start + 2, nums, target - nums[start])
                || groupNoAdj(start + 1, nums, target);
    }

    /*
    Given an array of ints, is it possible to choose a group of some of the ints,
    such that the group sums to the given target with these additional constraints:
    all multiples of 5 in the array must be included in the group.
    If the value immediately following a multiple of 5 is 1, it must not be chosen.
      (No loops needed.)

    groupSum5(0, [2, 5, 10, 4], 19) → true
    groupSum5(0, [2, 5, 10, 4], 17) → true
    groupSum5(0, [2, 5, 10, 4], 12) → false
     */
    private boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }
        if (nums[start] % 5 == 0) {
            if (nums.length - 1 > start && nums[start + 1] == 1) {
                return groupSum5(start + 2, nums, target - nums[start]);
            }
            return groupSum5(start + 1, nums, target - nums[start]);
        }

        return groupSum5(start + 1, nums, target)
                || groupSum5(start + 1, nums, target - nums[start]);
    }

    /*
    Given an array of ints, is it possible to choose a group of some of the ints,
    such that the group sums to the given target,
    with this additional constraint:
    if there are numbers in the array that are adjacent and the identical value,
    they must either all be chosen, or none of them chosen.
    For example, with the array {1, 2, 2, 2, 5, 2},
    either all three 2's in the middle must be chosen or not, all as a group.
    (one loop can be used to find the extent of the identical values).


    groupSumClump(0, [2, 4, 8], 10) → true
    groupSumClump(0, [1, 2, 4, 8, 1], 14) → true
    groupSumClump(0, [2, 4, 4, 8], 14) → false
     */

    private boolean groupSumClump(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }
        int counter = 1;
        while (start < nums.length - 1 && nums[start] == nums[start + counter]) {
            counter++;
        }

        return groupSumClump(start + counter, nums, target)
                || groupSumClump(start + counter, nums, target - nums[start] * counter);
    }

    /*
    Given an array of ints, is it possible to divide the ints into two groups,
    so that the sums of the two groups are the same.
    Every int must be in one group or the other.
    Write a recursive helper method that takes whatever arguments you like,
    and make the initial call to your recursive helper from splitArray().
    (No loops needed.)


    splitArray([2, 2]) → true
    splitArray([2, 3]) → false
    splitArray([5, 2, 3]) → true
     */
    private boolean splitArray(int[] nums) {
        return splitArrayHelper(0, nums, 0, 0);
    }

    private boolean splitArrayHelper(int start, int[] nums, int firstSum, int secondSum) {
        if (start == nums.length) {
            return firstSum == secondSum;
        }

        return splitArrayHelper(start + 1, nums, firstSum + nums[start], secondSum)
                || splitArrayHelper(start + 1, nums, firstSum, secondSum + nums[start]);
    }

    /*

    Given an array of ints, is it possible to divide the ints into two groups,
    so that the sum of one group is a multiple of 10, and the sum of the other group is odd.
    Every int must be in one group or the other.
    Write a recursive helper method that takes whatever arguments you like,
    and make the initial call to your recursive helper from splitOdd10().
    (No loops needed.)


    splitOdd10([5, 5, 5]) → true
    splitOdd10([5, 5, 6]) → false
    splitOdd10([5, 5, 6, 1]) → true
     */

    private boolean splitOdd10(int[] nums) {
        return splitOdd10Helper(0, nums, 0, 0);
    }

    private boolean splitOdd10Helper(int start, int[] nums, int firstSum, int secondSum) {
        if (start == nums.length) {
            return firstSum % 10 == 0 && secondSum % 2 != 0;
        }
        return splitOdd10Helper(start + 1, nums, firstSum + nums[start], secondSum)
                || splitOdd10Helper(start + 1, nums, firstSum, secondSum + nums[start]);
    }

    /*
    Given an array of ints, is it possible to divide the ints into two groups,
    so that the sum of the two groups is the same, with these constraints:
    all the values that are multiple of 5 must be in one group,
    and all the values that are a multiple of 3 (and not a multiple of 5) must be in the other.
     (No loops needed.)

    split53([1, 1]) → true
    split53([1, 1, 1]) → false
    split53([2, 4, 2]) → true
     */

    private boolean split53(int[] nums) {
        return split53Helper(0, nums, 0, 0);
    }

    private boolean split53Helper(int start, int[] nums, int firstSum, int secondSum) {
        if (start == nums.length) {
            return firstSum == secondSum;
        }
        if (nums[start] % 5 == 0) {
            return split53Helper(start + 1, nums, firstSum + nums[start], secondSum);
        }
        if (nums[start] % 3 == 0) {
            return split53Helper(start + 1, nums, firstSum, secondSum + nums[start]);
        }
        return split53Helper(start + 1, nums, firstSum + nums[start], secondSum)
                || split53Helper(start + 1, nums, firstSum, secondSum + nums[start]);
    }

    private List<Integer> noNeg(List<Integer> nums) {
         nums.removeIf(n -> n < 0);
         return nums;
    }

    private List<Integer> no9(List<Integer> nums) {
        nums.removeIf(n -> n == 9 || n % 10 == 9);
        return nums;
    }

    public List<Integer> noTeen(List<Integer> nums) {
        nums.removeIf(n -> n > 12 && n < 20);
        return nums;
    }

    public List<String> noZ(List<String> strings) {
        strings.removeIf(string -> string.contains("z"));
        return strings;
    }

    public List<String> noLong(List<String> strings) {
        strings.removeIf(string -> string.length() >= 4);
        return strings;
    }

    public List<String> no34(List<String> strings) {
        strings.removeIf(string -> string.length() == 3 || string.length() == 4);
        return strings;
    }

    public List<String> noYY(List<String> strings) {
        strings.replaceAll(string -> string + "y");
        strings.removeIf(string -> string.contains("yy"));
        return strings;
    }

    public List<Integer> two2(List<Integer> nums) {
        nums.replaceAll(num -> num * 2);
        nums.removeIf(num -> (num + "").endsWith("2"));
        return nums;
    }

    public List<Integer> square56(List<Integer> nums) {
        nums.replaceAll(number -> number * number + 10);
        nums.removeIf(number -> number % 10 == 6 || number % 10 == 5);
        return nums;
    }

}
