package ok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;

public class ToyHDNL {
    private static StringBuilder result = new StringBuilder();
    private static String[] tags;
    private static int[] nums;
    private static Stack<Tag> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numOfLines = Integer.parseInt(in.readLine());
        tags = new String[numOfLines];
        nums = new int[numOfLines];
        for (int i = 0; i < numOfLines; i++) {
            String input = in.readLine();
            StringBuilder sb = new StringBuilder(input);
            int number = Integer.parseInt(sb.deleteCharAt(0).toString());
            tags[i] = input;
            nums[i] = number;
        }

        int curValue = nums[0];
        int nestLvl = 0;
        printOpenTag(nestLvl, tags[0]);
        stack.push(new Tag(tags[0], nums[0], nestLvl));

        for (int i = 1; i < numOfLines; i++) {
            if (nums[i] > curValue) {
                curValue = nums[i];
                nestLvl++;
                printOpenTag(nestLvl, tags[i]);
                stack.push(new Tag(tags[i], nums[i], nestLvl));
            } else {
                curValue = nums[i];
                while (!stack.isEmpty() && curValue <= stack.peek().value) {
                    Tag newTag = stack.pop();
                    printCloseTag(newTag.nestLvl, newTag.tag);
                    if (curValue < newTag.value) {
                        nestLvl--;
                        nestLvl = Math.max(nestLvl, 0);
                    }
                }
                printOpenTag(nestLvl, tags[i]);
                stack.push(new Tag(tags[i], nums[i], nestLvl));
            }
        }
        while (!stack.isEmpty()) {
            Tag newTag = stack.pop();
            printCloseTag(newTag.nestLvl, newTag.tag);
        }
        System.out.print(result);
    }

    private static void printCloseTag(int nestLvl, String tag) {
        String spaces = String.join("", Collections.nCopies(nestLvl, " "));
        result.append(spaces).append("<").append("/").append(tag).append(">").append("\n");
    }

    private static void printOpenTag(int nestLvl, String tag) {
        String spaces = String.join("", Collections.nCopies(nestLvl, " "));
        result.append(spaces).append("<").append(tag).append(">").append("\n");
    }

    public static class Tag {
        public String tag;
        public int value;
        public int nestLvl;

        public Tag(String tag, int value, int nestLvl) {
            this.tag = tag;
            this.value = value;
            this.nestLvl = nestLvl;
        }
    }
}