package ok;

import java.util.ArrayList;
import java.util.List;

public class nRepElements {
    public static void main(String[] args) {
        int[] arr = {5, 1, 5, 2, 5, 3, 5, 4};
        System.out.println(repeatedNTimes(arr));
    }

    public static int repeatedNTimes(int[] A) {
        List<Integer> list = new ArrayList<>();

        for (int a : A) {
            if (list.contains(a)) {
                return a;
            }
            list.add(a);
        }
        return 0;
    }
}
