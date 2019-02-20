package demo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            int[] array;
            array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            boolean sym;
            sym = IsSymetric(array);

            if (sym) {
                System.out.println("yes");
            } else System.out.println("no");
        }

    }

    static boolean IsSymetric(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {

            if (arr[i] == arr[arr.length - 1 - i]) {
                continue;
            } else {
                return false;
            }

        }
        return true;
    }
}
