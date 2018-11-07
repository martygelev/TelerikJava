
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] inputPath = in.readLine().split(", ");
        int[] path = new int[inputPath.length];
        for(int i = 0; i < path.length; i++) {
            path[i] = Integer.parseInt(inputPath[i]);
        }
        int m = Integer.parseInt(in.readLine());
        int maxSum = Integer.MIN_VALUE;
        for(int times = 0; times < m; times++) {
            String[] inputDir = in.readLine().split(", ");
            int[] dir = new int[inputDir.length];
            for(int i = 0; i < dir.length; i++) {
                dir[i] = Integer.parseInt(inputDir[i]);
            }
            boolean[] visited = new boolean[path.length];
            for(int i = 0; i < visited.length; i++) {
                visited[i] = true;
            }
            int sum = path[0];
            visited[0] = false;
            int index = 0;
            int position = 0;

            while(true) {
                if(index > dir.length - 1) {
                    index = 0;
                }
                position += dir[index];
                if(position >= 0 && position < path.length && visited[position]) {
                    sum += path[position];
                    visited[position] = false;
                    index++;
                } else {
                    break;
                }
            }
            if(maxSum < sum) {
                maxSum = sum;
            }
        }
        System.out.println(maxSum);
    }
}