package dsa;

import java.util.Scanner;

class kBase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int k = Integer.parseInt(in.nextLine());

        long[] arr = new long[n];
        arr[0] = k - 1;
        arr[1] = (k - 1) * (k - 1);

        for (int i = 2; i < n; ++i) {
            arr[i] = (k - 1) * (arr[i - 2] + arr[i - 1]);
        }
        System.out.println(arr[n - 2] + arr[n - 1]);
    }
}

