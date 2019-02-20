import java.util.Scanner;

public class TownsGO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfTowns = Integer.parseInt(in.nextLine());
        int[] citizens = new int[numberOfTowns];
        for (int currentTown = 0; currentTown < numberOfTowns; currentTown++) {
            String line = in.nextLine();
            String[] lineParts = line.split(" ");
            citizens[currentTown] = Integer.parseInt(lineParts[0]);
        }

        int bestPath = FindLongestPath(citizens);
        System.out.println(bestPath);
    }

    public static int FindLongestPath(int[] citizens) {
        int numberOfTowns = citizens.length;

        int[] longestPathAscending = new int[numberOfTowns];
        for (int currentTown = 0; currentTown < numberOfTowns; currentTown++) {
            longestPathAscending[currentTown] = 1;
            for (int previousTown = 0; previousTown < currentTown; previousTown++) {
                if (citizens[previousTown] < citizens[currentTown]) {
                    longestPathAscending[currentTown] = Math.max(longestPathAscending[currentTown], longestPathAscending[previousTown] + 1);
                }
            }
        }

        int[] longestPathDescending = new int[numberOfTowns];
        for (int currentTown = numberOfTowns - 1; currentTown >= 0; currentTown--) {
            longestPathDescending[currentTown] = 1;
            for (int previousTown = numberOfTowns - 1; previousTown > currentTown; previousTown--) {
                if (citizens[previousTown] < citizens[currentTown]) {
                    longestPathDescending[currentTown] = Math.max(longestPathDescending[currentTown], longestPathDescending[previousTown] + 1);
                }
            }
        }

        int bestPath = 0;
        for (int currentTown = 0; currentTown < numberOfTowns; currentTown++) {
            int currentPath = longestPathAscending[currentTown] + longestPathDescending[currentTown] - 1;
            bestPath = Math.max(bestPath, currentPath);
        }

        return bestPath;
    }
}
/*
8
108214 Pleven
339077 Plovdiv
200612 Burgas
334688 Varna
1241396 Sofia
92162 Sliven
151951 Ruse
137907 StaraZagora
 */