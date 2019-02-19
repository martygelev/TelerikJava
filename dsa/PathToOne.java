package dsa;

import java.util.*;

public class PathToOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> depth = new ArrayDeque<>();

        queue.add(num);
        depth.add(0);

        int pathLen;

        while (true) {
            num = queue.poll();
            int nodeDepth = depth.poll();

            if (num % 2 != 0) {
                int nodeLeft = num + 1;
                int nodeRight = num - 1;
                depth.add(nodeDepth + 1);
                depth.add(nodeDepth + 1);

                queue.add(nodeLeft);
                queue.add(nodeRight);

            } else if (num % 2 == 0) {
                int nodeLeft = num / 2;
                depth.add(nodeDepth + 1);
                queue.add(nodeLeft);
            }

            if (num == 1) {
                pathLen = nodeDepth;
                break;
            }
        }

        System.out.println(pathLen);
    }
}
