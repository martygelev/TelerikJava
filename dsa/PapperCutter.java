import java.util.LinkedList;
import java.util.Scanner;

 class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int sizes = 10;
        LinkedList<String> unused = new LinkedList<>();
        for (int x = sizes; x >= 0; x--) {
            if ((n & 1) == 0) {
                unused.addFirst(String.format("A%d", x));
            }
            n >>= 1;
        }

        unused
                .forEach(System.out::println);
    }
}