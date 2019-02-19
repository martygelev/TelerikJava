package ok;

import java.util.ArrayList;
import java.util.Scanner;

public class indices {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());
        String str = console.nextLine();

        ArrayList<Integer> number = new ArrayList<>();

        ArrayList<Integer> result = new ArrayList<>();

        String[] arrString = str.split(" ");
        for (String string : arrString
        ) {
            number.add(Integer.parseInt(string));

        }
        boolean hasLoop = false;
        boolean[] isUsed = new boolean[number.size()];
        int index = 0;
        int loopStartIndex = 0;
        result.add(number.get(index));
        isUsed[index] = true;

        while (0 <= number.get(index) && number.get(index) <= number.size()) {
            index = number.get(index);
            if (isUsed[index]) {
                hasLoop = true;
                loopStartIndex = index;

                break;

            } else {
                result.add(number.get(index));
                isUsed[index] = true;


            }
        }
        if (!hasLoop) {
            System.out.print("0");
            for (int i = 0; i < result.size() - 1; i++) {
                System.out.print(" " + result.get(i));

            }
        } else {
            if (loopStartIndex == 0) {
                System.out.print("(0");
                for (int i = 0; i < result.size() - 1; i++) {
                    System.out.print(" " + result.get(i));

                }
                System.out.println(")");


            } else {
                System.out.print("0");
                for (int i = 0; i < result.size() - 1; i++) {


                    if (loopStartIndex == result.get(i)) {
                        System.out.print("(" + result.get(i));

                    } else {
                        System.out.print(" " + result.get(i));
                    }

                }
                System.out.println(")");
            }
        }
    }
}
