import java.util.Scanner;

public class Tubes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int target = in.nextInt();

        long[] tubes = new long[n];
        long maxTube = 0;

        for (int i = 0; i < n; i++) {
            tubes[i] = in.nextInt();
            maxTube = Math.max(maxTube, tubes[i]);
        }

        maxTube = findMaxTube(tubes, target, 0, maxTube);

        if ((maxTube > 0)) {
            System.out.println(maxTube);
        } else {
            System.out.println(-1);
        }
    }

    private static long findMaxTube(long[] tubes, int target, long minTube, long maxTube) {

        while (maxTube > minTube) {
            if (isValidTube(tubes, target, maxTube)) {
                minTube = maxTube;
                maxTube = (long) (maxTube * 1.5);
            } else {
                maxTube = (minTube + maxTube) / 2;
            }
        }

        return maxTube;

    }

    private static boolean isValidTube(long[] tubes, int target, long maxTube) {
        int counter = 0;
        for (long tube : tubes) {
            counter += tube / maxTube;
        }

        return counter>=target;
    }

}

