import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;


class P03Medians_NW {
    private static Queue<Double> small = new ArrayDeque<>();
    private static Queue<Double> large = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            String input = console.readLine();

            if (input.equals("END")) {
                break;
            }
            String[] inputData = input.split(" ");

            switch (inputData[0]) {
                case "ADD":
                    addNumber(Double.parseDouble(inputData[1]));
                    System.out.println(large.peek());
                    System.out.println(small.peek());
                    System.out.println("------------");
                    break;
                default:
                    double output = findMedian();
                    System.out.println("Peek L:" + large.peek());
                    System.out.println("Peek S:" + small.peek());

                    System.out.println("Find:" + output);
                    System.out.println("----------");
                    break;
            }
        }
    }

    public static void addNumber(double number) {
        if (large.size() > 0) {
            small.add(-large.poll());
        }

        large.add(number);
        if (large.size() < small.size()) {
            large.offer(-small.poll());
        }
    }

    public static double findMedian() {
        if (large.size() > small.size()) {
            return large.peek();
        }
        return (large.peek() - small.peek()) / 2;
    }

}