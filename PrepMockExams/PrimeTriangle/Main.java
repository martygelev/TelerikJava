package com.company;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner input = new Scanner(System.in);

        List<Integer> list = new ArrayList<Integer>();
        int m = input.nextInt();
        for (int num = 1; num <= m; num++) {
            boolean prime = true;
            int divider = 2;
            int maxDivider = (int) Math.sqrt(num);
            while (divider <= maxDivider) {
                if (num % divider == 0) {
                    prime = false;
                    break;
                }
                divider++;
            }
            if (prime) {
                list.add(num);
            }
        }

        int size = list.size();
        for (int row = 0; row < size; row++) {
            for (int col = 1; col <= list.get(row); col++) {
                boolean prime = true;
                int divider = 2;
                int maxDivider = (int) Math.sqrt(col);
                while (divider <= maxDivider) {
                    if (col % divider == 0) {
                        prime = false;
                        break;
                    }
                    divider++;
                }
                if (prime) {
                    System.out.print(1);
                } else System.out.print(0);

            }
            System.out.println();
        }


    }
}
