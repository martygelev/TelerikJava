package dsa;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class SequenceNtoM {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(bufferedReader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int start = input[0];
        int end = input[1];

        if (end < start) {
            return;
        }


        if (end == start) {
            System.out.println(end);
            return;
        }

        Deque<Item> queue = new LinkedList<>();

        queue.addLast(new Item(start));

        while (queue.size() > 0) {
            Item current = queue.removeFirst();

            int nextValue1 = current.value + 1;
            int nextValue2 = current.value + 2;
            int nextValue3 = current.value * 2;

            if (nextValue1 == end
                    || nextValue2 == end
                    || nextValue3 == end) {
                print(current, end);
                break;
            }

            if (nextValue1 < end) {
                queue.addLast(new Item(nextValue1, current));
            }
            if (nextValue2 < end) {
                queue.addLast(new Item(nextValue2, current));
            }
            if (nextValue3 < end) {
                queue.addLast(new Item(nextValue3, current));
            }
        }
    }

    private static void print(Item item, int end) {

        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(end);
        while (item.previous != null) {
            deque.addFirst(item.value);
            item = item.previous;
        }
        deque.addFirst(item.value);

        System.out.println(Arrays.stream(deque.toArray())
                .map(String::valueOf)
                .collect(Collectors.joining(" -> ")));
    }

    private static class Item {

        private int value;
        private Item previous;

        public Item() {
            this.previous = null;
        }

        public Item(int value) {
            this(value, null);
        }

        public Item(int value, Item previous) {
            this.value = value;
            this.previous = previous;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Item getPrevious() {
            return previous;
        }

        public void setPrevious(Item previous) {
            this.previous = previous;
        }
    }
}