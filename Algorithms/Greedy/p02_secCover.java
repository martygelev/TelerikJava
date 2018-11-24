import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p02_secCover {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(10).split(", ");
        int[] universe = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            universe[i] = Integer.parseInt(elements[i]);
        }

        int numberOfSets = Integer.parseInt(in.nextLine().substring(16));
        List<int[]> sets = new ArrayList<>();
        for (int i = 0; i < numberOfSets; i++) {
            String[] setElements = in.nextLine().split(", ");
            int[] set = new int[setElements.length];
            for (int j = 0; j < setElements.length; j++) {
                set[i] = Integer.parseInt(setElements[i]);
            }
        }

        List<int[]> choosenSets = chooseSets(sets, universe);
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {
        return null;
    }
}
