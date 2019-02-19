import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tubesFact {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int numOfTubes = Integer.parseInt(in.readLine());
        int wantedTubes = Integer.parseInt(in.readLine());
        int[] tubes = new int[numOfTubes];
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < numOfTubes; i++) {
            tubes[i] = Integer.parseInt(in.readLine());
            if (tubes[i] > maxValue) {
                maxValue = tubes[i];
            }
        }
        System.out.println(splitTheTubes(tubes, wantedTubes, maxValue));

    }

    public static int splitTheTubes(int[] tubes, int wantedTubes, int end) {
        int tubeResult = 0;
        int start = 1;
        int middle = (end + start) / 2;
        int currentSplit;
        while (start <= end) {
            currentSplit = 0;
            for (int i = 0; i < tubes.length; i++) {
                currentSplit += (tubes[i] / middle);
            }
            if (currentSplit < wantedTubes) {
                end = middle - 1;
                middle = (start + end) / 2;
            } else {
                start = middle + 1;
                tubeResult = middle;
                middle = (start + end) / 2;
            }
        }
        return tubeResult;
    }
}